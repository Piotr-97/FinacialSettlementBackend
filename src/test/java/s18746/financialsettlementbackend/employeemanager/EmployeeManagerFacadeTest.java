package s18746.financialsettlementbackend.employeemanager;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
public class EmployeeManagerFacadeTest {


    EmployeeRepository employeeRepository = new EmployeeRepositoryTestImpl();

    @Test
    public void shouldAddNewWorkerToRepository() {
        //given
        EmployeeManagerFacade employeeManagerFacade = new EmployeeManagerConfiguration().employeeManagerFacadeForTest(employeeRepository);
        EmployeeDto employeeDto = new EmployeeDto(1L,"Marek","Kowalski",LocalDate.of(1997, Month.APRIL, 12));
        //when
        employeeManagerFacade.addEmployee(employeeDto);
        //then
        assertEquals(employeeDto,employeeManagerFacade.getEmployeeById(1L).get());
        assertEquals(employeeRepository.findAll().size(), 1);


    }

    @Test
    public void shouldFindWorkerByIdFromRepository(){
        //given
        EmployeeManagerFacade employeeManagerFacade = new EmployeeManagerConfiguration().employeeManagerFacadeForTest(employeeRepository);
        EmployeeDto employeeDto = new EmployeeDto(1L,"Marek","Kowalski",LocalDate.of(1997, Month.APRIL, 12));

        employeeManagerFacade.addEmployee(employeeDto);

        //when
        EmployeeDto employee1 = employeeManagerFacade.getEmployeeById(1L).get();

        //then
        assertEquals(employeeDto, employee1);
        assertEquals(1, employeeRepository.findAll().size());
    }

    @Test
    public void ShouldDeleteWorkerFromRepository(){
        //given
        EmployeeManagerFacade employeeManagerFacade = new EmployeeManagerConfiguration().employeeManagerFacadeForTest(employeeRepository);
        EmployeeDto employee = new EmployeeDto(1L,"Marek","Kowalski",LocalDate.of(1997, Month.APRIL, 12));
        EmployeeDto employee2 = new EmployeeDto(2L,"Marek","Kowalski",LocalDate.of(1997, Month.APRIL, 12));

        employeeManagerFacade.addEmployee(employee);
        employeeManagerFacade.addEmployee(employee2);
        //when
        employeeManagerFacade.deleteEmployeeById(1L);
        //then
        assertEquals(1, employeeRepository.findAll().size());

    }

    @Test
    public void shouldReturnListOfAllEmployeesInDatabase(){
        //given
        EmployeeManagerFacade employeeManagerFacade = new EmployeeManagerConfiguration().employeeManagerFacadeForTest(employeeRepository);
        EmployeeDto employee = new EmployeeDto(1L,"Marek","Kowalski",LocalDate.of(1997, Month.APRIL, 12));
        EmployeeDto employee2 = new EmployeeDto(2L,"Marek","Kowalski",LocalDate.of(1997, Month.APRIL, 12));
        employeeManagerFacade.addEmployee(employee);
        employeeManagerFacade.addEmployee(employee2);
        //when & Then
        assertEquals(2,employeeRepository.findAll().size());
    }








}
