package s18746.financialsettlementbackend.controllers;


import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.workerManager.Employee;
import s18746.financialsettlementbackend.workerManager.EmployeeManagerFacade;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {


    private final EmployeeManagerFacade employeeService;


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {

        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){

        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/pobierz-pdf")
    public void pobierzPdf(HttpServletResponse response) throws IOException {
        // Ustaw nagłówki odpowiedzi
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=plik.pdf");

        // Wczytaj plik PDF z dysku lub generuj go dynamicznie
        FileInputStream fileInputStream = new FileInputStream("hello.pdf");

        // Przepisz dane z FileInputStream do OutputStream odpowiedzi
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        fileInputStream.close();
        outputStream.flush();
    }





}
