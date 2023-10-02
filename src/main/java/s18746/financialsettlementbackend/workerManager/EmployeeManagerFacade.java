package s18746.financialsettlementbackend.workerManager;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class EmployeeManagerFacade {

    private final EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(Long id){
        return  employeeRepository.findById(id);
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



    public Employee updateEmployee(Employee newEmployee){
       Optional <Employee> employeeOld = employeeRepository.findById(newEmployee.getId());

       if(employeeOld.isPresent()){
           Employee updatedEmployee = employeeOld.get();
           //TODO ADD LOGIC
           employeeRepository.save(updatedEmployee);
       }
        return null;
    }

    public Employee addEmployee(Employee employee){

       return employeeRepository.save(employee);
    }







}
