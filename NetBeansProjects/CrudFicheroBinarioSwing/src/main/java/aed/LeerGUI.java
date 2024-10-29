package aed;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerGUI extends JFrame {
    private JTextField idField, nombreField, edadField;
    private JTextArea displayArea;
    private JButton agregarButton, buscarButton, editarButton, eliminarButton, mostrarButton, salirButton;

    // Tamaño de los campos
    private static final int TAMANO_ID = 4; // Tamaño del campo de ID (4 bytes para un int)
    private static final int TAMANO_NOMBRE = 40; // Tamaño del campo de nombre (20 caracteres * 2 bytes por carácter)
    private static final int TAMANO_EDAD = 4; // Tamaño del campo de edad (4 bytes para un int)
    private static final int TAMANO_REGISTRO = TAMANO_ID + TAMANO_NOMBRE + TAMANO_EDAD;

    public LeerGUI() {
        setTitle("CRUD Usuarios - Fichero Binario");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Crear campos de texto
        idField = new JTextField(10);
        nombreField = new JTextField(20);
        edadField = new JTextField(3);

        // Crear botones
        agregarButton = new JButton("Agregar Usuario");
        buscarButton = new JButton("Buscar Usuario");
        editarButton = new JButton("Editar Usuario");
        eliminarButton = new JButton("Eliminar Usuario");
        mostrarButton = new JButton("Mostrar Todos");
        salirButton = new JButton("Salir");

        // Área de texto para mostrar resultados
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Panel para los campos de texto y etiquetas
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(nombreField);
        inputPanel.add(new JLabel("Edad:"));
        inputPanel.add(edadField);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
        buttonPanel.add(buscarButton);
        buttonPanel.add(editarButton);
        buttonPanel.add(eliminarButton);
        buttonPanel.add(mostrarButton);
        buttonPanel.add(salirButton);

        // Agregar los paneles a la ventana
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Acciones de los botones
        agregarButton.addActionListener(e -> agregarUsuario());
        buscarButton.addActionListener(e -> buscarUsuario());
        editarButton.addActionListener(e -> editarUsuario());
        eliminarButton.addActionListener(e -> eliminarUsuario());
        mostrarButton.addActionListener(e -> mostrarTodosLosUsuarios());
        salirButton.addActionListener(e -> System.exit(0)); // Cerrar el programa
    }

    private void agregarUsuario() {
        String id = idField.getText().trim();
        String nombre = ajustarLongitud(nombreField.getText(), 20);
        int edad;

        try {
            edad = Integer.parseInt(edadField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad debe ser un número válido.");
            return;
        }

        try (RandomAccessFile archivo = new RandomAccessFile("usuarios.dat", "rw")) {
            archivo.seek(archivo.length()); // Ir al final del archivo
            archivo.writeInt(Integer.parseInt(id)); // Guardar ID como int
            archivo.write(fijarLongitudBytes(nombre, TAMANO_NOMBRE)); // Guardar Nombre como bytes
            archivo.writeInt(edad); // Guardar Edad como int
            displayArea.append("Usuario agregado correctamente.\n");
            limpiarCampos();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar el usuario: " + ex.getMessage());
        }
    }

    private void buscarUsuario() {
        int id;
        try {
            id = Integer.parseInt(idField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID debe ser un número válido.");
            return;
        }

        try (RandomAccessFile archivo = new RandomAccessFile("usuarios.dat", "r")) {
            boolean encontrado = false;
            while (archivo.getFilePointer() < archivo.length()) {
                int idLeido = archivo.readInt();
                String nombre = leerCampo(archivo, TAMANO_NOMBRE);
                int edad = archivo.readInt();

                if (idLeido == id) {
                    displayArea.setText("ID: " + idLeido + "\nNombre: " + nombre.trim() + "\nEdad: " + edad);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                displayArea.setText("Usuario no encontrado.\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar el usuario: " + ex.getMessage());
        }
    }

    private void editarUsuario() {
        int id;
        String nuevoNombre = ajustarLongitud(nombreField.getText(), 20);
        int nuevaEdad;

        try {
            id = Integer.parseInt(idField.getText().trim());
            nuevaEdad = Integer.parseInt(edadField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID y Edad deben ser números válidos.");
            return;
        }

        try (RandomAccessFile archivo = new RandomAccessFile("usuarios.dat", "rw")) {
            boolean encontrado = false;
            while (archivo.getFilePointer() < archivo.length()) {
                long posicion = archivo.getFilePointer();
                int idLeido = archivo.readInt();
                String nombre = leerCampo(archivo, TAMANO_NOMBRE);
                int edad = archivo.readInt();

                if (idLeido == id) {
                    archivo.seek(posicion); // Volver al inicio del registro
                    archivo.writeInt(id); // Guardar el ID
                    archivo.write(fijarLongitudBytes(nuevoNombre, TAMANO_NOMBRE)); // Actualizar el nombre
                    archivo.writeInt(nuevaEdad); // Actualizar la edad
                    displayArea.append("Usuario actualizado correctamente.\n");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                displayArea.append("Usuario no encontrado.\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al editar el usuario: " + ex.getMessage());
        }
    }

    private void eliminarUsuario() {
        int id;
        try {
            id = Integer.parseInt(idField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID debe ser un número válido.");
            return;
        }

        try (RandomAccessFile archivo = new RandomAccessFile("usuarios.dat", "rw")) {
            boolean encontrado = false;
            while (archivo.getFilePointer() < archivo.length()) {
                long posicion = archivo.getFilePointer();
                int idLeido = archivo.readInt();
                String nombre = leerCampo(archivo, TAMANO_NOMBRE);
                int edad = archivo.readInt();

                if (idLeido == id) {
                    archivo.seek(posicion); // Ir al inicio del registro
                    archivo.writeInt(0); // Eliminar ID (poniendo 0)
                    archivo.write(fijarLongitudBytes("", TAMANO_NOMBRE)); // Vaciar el nombre
                    archivo.writeInt(0); // Vaciar la edad
                    displayArea.append("Usuario eliminado correctamente.\n");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                displayArea.append("Usuario no encontrado.\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el usuario: " + ex.getMessage());
        }
    }

    private void mostrarTodosLosUsuarios() {
        try (RandomAccessFile archivo = new RandomAccessFile("usuarios.dat", "r")) {
            displayArea.setText("");
            while (archivo.getFilePointer() < archivo.length()) {
                int idLeido = archivo.readInt();
                String nombre = leerCampo(archivo, TAMANO_NOMBRE);
                int edad = archivo.readInt();

                if (idLeido != 0) {
                    displayArea.append("ID: " + idLeido + ", Nombre: " + nombre.trim() + ", Edad: " + edad + "\n");
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al mostrar los usuarios: " + ex.getMessage());
        }
    }

    private String leerCampo(RandomAccessFile archivo, int longitud) throws IOException {
        byte[] buffer = new byte[longitud];
        archivo.read(buffer);
        return new String(buffer).trim();
    }

    private String ajustarLongitud(String cadena, int longitud) {
        StringBuilder sb = new StringBuilder(cadena);
        while (sb.length() < longitud) {
            sb.append(' ');
        }
        return sb.toString().substring(0, longitud);
    }

    private byte[] fijarLongitudBytes(String cadena, int longitudBytes) {
        byte[] bytes = new byte[longitudBytes];
        byte[] cadenaBytes = cadena.getBytes();
        System.arraycopy(cadenaBytes, 0, bytes, 0, Math.min(cadenaBytes.length, longitudBytes));
        return bytes;
    }

    private void limpiarCampos() {
        idField.setText("");
        nombreField.setText("");
        edadField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LeerGUI().setVisible(true));
    }
}
