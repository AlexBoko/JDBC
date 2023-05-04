package hibernate.service;

import hibernate.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Integer createEmployee(Employee employee);

    Employee getEmployeeById(int idEmployee);

    List getAllEmployees();

    void updateEmployee(Employee employee, int id);

    void deleteEmployee(Employee employee);
}