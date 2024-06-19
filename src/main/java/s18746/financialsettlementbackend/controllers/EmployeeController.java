package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.employeemanager.Employee;
import s18746.financialsettlementbackend.employeemanager.EmployeeDto;
import s18746.financialsettlementbackend.employeemanager.EmployeeManagerFacade;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {


    private final EmployeeManagerFacade employeeManagerFacade;


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeManagerFacade.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {

        Optional<EmployeeDto> employee = employeeManagerFacade.getEmployeeDtoById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employee) {
        employeeManagerFacade.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {

        employeeManagerFacade.deleteEmployeeById(id);
    }

    @PatchMapping
    public ResponseEntity<Employee> updateData(@RequestBody EmployeeDto employeeDto) {
        employeeManagerFacade.updateEmployee(employeeDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
