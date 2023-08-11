package library.controllers;

import library.models.Book;
import library.models.Employee;
import library.services.BookService;
import library.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/api/employee")
    public void save(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @GetMapping("/api/employee")
    public List<Employee> getAll(){
        return (List<Employee>) employeeService.getAll();
    }

    @GetMapping ("/api/employee/{id}")
    public Employee get(@PathVariable("id") Long id) {
        return employeeService.get(id);
    }

}