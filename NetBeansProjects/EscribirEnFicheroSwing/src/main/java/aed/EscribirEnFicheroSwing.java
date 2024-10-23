import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirEnFicheroSwing extends JFrame {

    private JTextArea areaTexto;
    private JButton botonGuardar;

    public EscribirEnFicheroSwing() {
        super("Escribir en Fichero");

        // Crear componentes
        areaTexto = new JTextArea(10, 30);
        botonGuardar = new JButton("Guardar en archivo");

        // Configurar el botón para guardar el archivo
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEnArchivo();
            }
        });

        // Crear un panel para los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        panel.add(botonGuardar, BorderLayout.SOUTH);

        // Configurar la ventana
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    // Método para guardar el contenido del JTextArea en un archivo de texto
    private void guardarEnArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int opcion = fileChooser.showSaveDialog(this); // Mostrar el diálogo de guardado

        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile(); // Obtener el archivo seleccionado

            String texto = areaTexto.getText(); // Obtener el texto del JTextArea

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) { // Habilitar el modo de añadir
                writer.write(texto); // Escribir el texto en el archivo
                writer.newLine(); // Añadir una nueva línea después del texto
                JOptionPane.showMessageDialog(this, "Texto guardado en '" + archivo.getAbsolutePath() + "'.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EscribirEnFicheroSwing());
    }
}
