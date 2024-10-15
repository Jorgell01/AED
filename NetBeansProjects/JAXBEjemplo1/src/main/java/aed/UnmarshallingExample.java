package aed;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBException;

import javax.xml.bind.Unmarshaller;

import java.io.File;



public class UnmarshallingExample {

    public static void main(String[] args) {

        try {

            // Crear el contexto de JAXB para la clase Employee

            JAXBContext context = JAXBContext.newInstance(Employee.class);



            // Crear el Unmarshaller para convertir el XML a un objeto

            Unmarshaller unmarshaller = context.createUnmarshaller();



            // Leer el archivo XML y convertirlo a un objeto Employee

            Employee employee = (Employee) unmarshaller.unmarshal(new File("employee.xml"));



            // Mostrar la información del empleado

            System.out.println("Empleado cargado desde XML: " + employee);



        } catch (JAXBException e) {

            e.printStackTrace();

        }

    }

}
