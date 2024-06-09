package s18746.financialsettlementbackend.controllers;



import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.employeemanager.Employee;
import s18746.financialsettlementbackend.employeemanager.EmployeeDto;
import s18746.financialsettlementbackend.employeemanager.EmployeeManagerFacade;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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

        Optional<EmployeeDto> employee = employeeManagerFacade.getEmployeeById(id);
    return  new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employee) {
        employeeManagerFacade.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){

        employeeManagerFacade.deleteEmployeeById(id);
    }

    @PatchMapping
    public ResponseEntity<Employee> updateData(@RequestBody EmployeeDto employeeDto){
        employeeManagerFacade.updateEmployee(employeeDto);

        return new ResponseEntity<>(HttpStatus.OK);
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
