package aed;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBException;

import javax.xml.bind.Marshaller;

import java.io.File;



public class MarshallingExample {

    public static void main(String[] args) {

        try {

            // Crear un objeto Employee

            Employee employee = new Employee();

            employee.setId(101);

            employee.setName("John Doe");

            employee.setRole("Developer");

            employee.setSalary(50000);



            // Crear el contexto de JAXB para la clase Employee

            JAXBContext context = JAXBContext.newInstance(Employee.class);



            // Crear el Marshaller para convertir el objeto en XML

            Marshaller marshaller = context.createMarshaller();



            // Formatear el XML con sangrías

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);



            // Guardar el objeto Employee como XML en un archivo

            marshaller.marshal(employee, new File("employee.xml"));



            System.out.println("Archivo XML creado exitosamente: employee.xml");



        } catch (JAXBException e) {

            e.printStackTrace();

        }

    }

}