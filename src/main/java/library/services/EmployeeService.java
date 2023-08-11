package library.services;

import jakarta.transaction.Transactional;
import library.models.Employee;
import library.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void save(Employee employee){employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> getAll(){
        return (List<Employee>) employeeRepository.findAll();
    }

    @Transactional
    public Employee get(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
