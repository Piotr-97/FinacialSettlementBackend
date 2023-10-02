package s18746.financialsettlementbackend.workermanager;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import s18746.financialsettlementbackend.workerManager.Employee;
import s18746.financialsettlementbackend.workerManager.EmployeeManagerConfiguration;
import s18746.financialsettlementbackend.workerManager.EmployeeManagerFacade;
import s18746.financialsettlementbackend.workerManager.EmployeeRepository;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
public class EmployeeManagerFacadeTest {


    EmployeeRepository employeeRepository = new EmployeeRepositoryTestImpl();

    @Test
    public void shouldAddNewWorkerToRepository() {
        //given
        EmployeeManagerFacade employeeManagerFacade = new EmployeeManagerConfiguration().employeeManagerFacadeForTest(employeeRepository);
        Employee employee = Employee.builder()
                .id(1L)
                .firstname("Marek")
                .lastname("Kowalski")
                .email("marek.kowalski@email.com")
                .birthdate(LocalDate.of(1997, Month.APRIL, 12)).build();
        //when
        employeeManagerFacade.addEmployee(employee);
        //then
        assertEquals(employee, employeeRepository.findById(1L).get());
        assertEquals(employeeRepository.findAll().size(), 1);


    }

    @Test
    public void shouldFindWorkerByIdFromRepository(){
        //given
        EmployeeManagerFacade employeeManagerFacade = new EmployeeManagerConfiguration().employeeManagerFacadeForTest(employeeRepository);
        Employee employee = Employee.builder()
                .id(2L)
                .firstname("Marek")
                .lastname("Kowalski")
                .email("marek.kowalski@email.com")
                .birthdate(LocalDate.of(1997, Month.APRIL, 12)).build();
        employeeManagerFacade.addEmployee(employee);

        //when
        Employee employee1 = employeeManagerFacade.getEmployeeById(2L).get();

        //then
        assertEquals(employee, employee1);
        assertEquals(1, employeeRepository.findAll().size());
    }

    @Test
    public void ShouldDeleteWorkerFromRepository(){
        //given
        EmployeeManagerFacade employeeManagerFacade = new EmployeeManagerConfiguration().employeeManagerFacadeForTest(employeeRepository);
        Employee employee = Employee.builder()
                .id(2L)
                .firstname("Marek")
                .lastname("Kowalski")
                .email("marek.kowalski@email.com")
                .birthdate(LocalDate.of(1997, Month.APRIL, 12)).build();
        Employee employee2 = employee.builder()
                .id(1L)
                .firstname("Kowalski")
                .lastname("Kowalski")
                .email("marek.kowalski@email.com")
                .birthdate(LocalDate.of(1997, Month.APRIL, 12)).build();
        employeeManagerFacade.addEmployee(employee);
        employeeManagerFacade.addEmployee(employee2);
        //when
        employeeManagerFacade.deleteEmployeeById(1L);
        //then
        assertEquals(1, employeeRepository.findAll().size());

    }

    @Test
    public void shouldReturnListOfAllEmployeesInDatabase(){

    }








}
