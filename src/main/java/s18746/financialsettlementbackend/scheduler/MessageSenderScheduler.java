package s18746.financialsettlementbackend.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import s18746.financialsettlementbackend.employeemanager.Employee;
import s18746.financialsettlementbackend.employeemanager.EmployeeManagerFacade;
import s18746.financialsettlementbackend.messagesender.MessageSenderFacade;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageSenderScheduler {

    private final EmployeeManagerFacade employeeManagerFacade;
    private final MessageSenderFacade messageSenderFacade;


    @Scheduled(cron = "0 15 10 15 * ?")
    public void sendRemindersToAllEmployees(){
        List<Employee> allEmployees = employeeManagerFacade.getAllEmployees();

        messageSenderFacade.sendReminderToEmployeesMail(allEmployees);
    }

}
