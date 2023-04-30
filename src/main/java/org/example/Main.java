package org.example;

import service.EmployeeDAOImpl;

public class Main {
    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employeeDAO.getEmployeeById(4);
        employeeDAO.getAllEmployees();

    }
}
