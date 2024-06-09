package s18746.financialsettlementbackend.employeemanager;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class EmployeeManagerFacade {

    private final EmployeeRepository employeeRepository;

    public Optional<EmployeeDto> getEmployeeById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return Optional.of(mapEmployeeToDto(employee.get()));
        }
        return Optional.empty();
    }

    public Optional<Employee> getEmployeeByFirstnameAndLastname(String firstname, String lastname) {
        return employeeRepository.findByFirstnameAndLastname(firstname,lastname);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();

    }

    public  Optional<Employee> deleteEmployeeById(Long id){
        Optional<Employee> workerToDelete = employeeRepository.findById(id);
        if(workerToDelete.isPresent()){
            employeeRepository.delete(workerToDelete.get());
                return workerToDelete;
        }
        return workerToDelete;
    }



    public Employee updateEmployee(EmployeeDto newEmployee){
       Optional <Employee> employeeOld = employeeRepository.findById(newEmployee.id());
       if(employeeOld.isPresent()){
           Employee updatedEmployee = employeeOld.get();
           //TODO
           if(updatedEmployee.getFirstname() != newEmployee.firstname() && newEmployee.firstname() != null){
               updatedEmployee.setFirstname(newEmployee.firstname());
           }
           if(updatedEmployee.getLastname() != newEmployee.lastname() && newEmployee.lastname() != null){
               updatedEmployee.setLastname(newEmployee.lastname());
           }
           if(updatedEmployee.getBirthdate() != newEmployee.birthdate() && newEmployee.birthdate() != null){
               updatedEmployee.setBirthdate(newEmployee.birthdate());
           }
           employeeRepository.save(updatedEmployee);
       }
       return null;
    }


    public Employee addEmployee(EmployeeDto employeeDto){
        Employee employee = mapDtoToEmployee(employeeDto);

       return employeeRepository.save(employee);
    }

    private Employee mapDtoToEmployee(EmployeeDto employeeDto) {
        return Employee.builder()
                .id(employeeDto.id())
                .firstname(employeeDto.firstname())
                .lastname(employeeDto.lastname())
                .birthdate(employeeDto.birthdate())
                .build();
    }

    private EmployeeDto mapEmployeeToDto(Employee employee){
        return new EmployeeDto(employee.getId(),employee.getFirstname(),employee.getLastname(),employee.getBirthdate());
    }


}
