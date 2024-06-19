package s18746.financialsettlementbackend.employeemanager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s18746.financialsettlementbackend.utils.EmployeeMapper;

@Configuration
public class EmployeeManagerConfiguration {


    @Bean
    public EmployeeManagerFacade employeeManagerFacade(EmployeeRepository employeeRepository){

        return new
                EmployeeManagerFacade(employeeRepository);
    }

    public EmployeeManagerFacade employeeManagerFacadeForTest(EmployeeRepository employeeRepository)
    {
        return new EmployeeManagerFacade(employeeRepository);

    }
}
