package test.java.developer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.java.developer.model.Employee;
import test.java.developer.repository.EmployeeRepository;
import test.java.developer.service.EmployeeService;

import java.util.List;

@Service
@Transactional
public class EmployeeImplService implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeImplService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> fetchEmployeesAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        System.out.println("Employee Id = "+employee.getEmp_no());
        Employee employee1 = employeeRepository.findById(employee.getEmp_no()).get();
        // Setting Up Object
        employee1.setFirst_name(employee.getFirst_name());
        employee1.setLast_name(employee.getLast_name());
        employee1.setBirth_date(employee.getBirth_date());
        employee1.setGender(employee.getGender());
        employee1.setHire_date(employee.getHire_date());
        System.out.println("Employee Add = "+employee1.toString());
        // update
        Employee updateEmployee = employeeRepository.save(employee1);
        System.out.println("Update Employee Fetch = "+updateEmployee);
        return updateEmployee;
    }

    @Override
    public void deletedEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
