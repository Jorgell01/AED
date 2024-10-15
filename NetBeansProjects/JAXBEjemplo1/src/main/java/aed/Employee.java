package aed;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Employee {

    private int id;

    private String name;

    private String role;

    private int salary;

    // Constructor sin argumentos es requerido por JAXB

    public Employee() {}

    @XmlElement

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    @XmlElement

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    @XmlElement

    public String getRole() {

        return role;

    }

    public void setRole(String role) {

        this.role = role;

    }

    @XmlElement

    public int getSalary() {

        return salary;

    }

    public void setSalary(int salary) {

        this.salary = salary;

    }

    @Override

    public String toString() {

        return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + "]";

    }

}
