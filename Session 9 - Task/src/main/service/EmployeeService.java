package main.service;

import main.dao.EmployeeDao;
import main.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    public void saveEmployee(Employee employee) {

        employeeDao.save(employee);

    }

}