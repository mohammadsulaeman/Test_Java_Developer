package test.java.developer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.java.developer.model.Employee;
import test.java.developer.service.EmployeeService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public CollectionModel<Employee> fetchEmployeesAll(){
        List<Employee> employeeList = employeeService.fetchEmployeesAll();
        CollectionModel<Employee> collectionModel = CollectionModel.of(employeeList);
        collectionModel.add(linkTo(methodOn(EmployeeController.class).fetchEmployeesAll()).withSelfRel());
        return collectionModel;
    }

    @PostMapping
    public HttpEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employeeAdd = employeeService.createEmployee(employee);
        employeeAdd.add(linkTo(methodOn(EmployeeController.class).fetchEmployeesAll()).withRel(IanaLinkRelations.COLLECTION));
        return ResponseEntity.created(linkTo(methodOn(EmployeeController.class).fetchEmployeesAll()).toUri()).body(employeeAdd);
    }

    @PutMapping("/{id}")
    public HttpEntity<Employee> updateEmployee(@PathVariable("id") Integer empNo, @RequestBody Employee employee){
        employee.setEmp_no(empNo);
        Employee updateEmployee = employeeService.updateEmployee(employee);
        updateEmployee.add(linkTo(methodOn(EmployeeController.class).fetchEmployeesAll()).withRel(IanaLinkRelations.COLLECTION));
        return ResponseEntity.created(linkTo(methodOn(EmployeeController.class).updateEmployee(empNo, employee)).toUri()).body(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<String> deletedEmployee(@PathVariable("id") Integer empNo){
        employeeService.deletedEmployee(empNo);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}
