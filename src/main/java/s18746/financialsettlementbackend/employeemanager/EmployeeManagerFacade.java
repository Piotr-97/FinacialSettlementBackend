package s18746.financialsettlementbackend.employeemanager;

import lombok.AllArgsConstructor;
import s18746.financialsettlementbackend.autht.User;
import s18746.financialsettlementbackend.utils.EmployeeMapper;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class EmployeeManagerFacade {

    private final EmployeeRepository employeeRepository;


    public Optional<EmployeeDto> getEmployeeDtoById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return Optional.of(mapEmployeeToDto(employee.get()));
        }
        return Optional.empty();
    }

    public  Employee getEmployeeById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new EmployeeNotFoundException("Employee not found");
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
                .build();
    }

    private EmployeeDto mapEmployeeToDto(Employee employee){
        return new EmployeeDto(employee.getId(),employee.getFirstname(),employee.getLastname());
    }


    public void addEmployee(RegisterEmployee registerEmployee, User newuser) {
        //save new employee
    }

    public Employee getEmployeeByUuid(String uuid) {
        Optional<Employee> byUuid = employeeRepository.findByUuid(uuid);
        if(byUuid.isPresent()){
            return byUuid.get();
        }
        throw new EmployeeNotFoundException("Couldn't find employee");
    }
}
