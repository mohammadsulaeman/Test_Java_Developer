package test.java.developer.service;

import test.java.developer.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> fetchEmployeesAll();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void  deletedEmployee(Integer id);
}
