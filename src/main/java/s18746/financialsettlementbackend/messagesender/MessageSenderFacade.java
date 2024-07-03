package s18746.financialsettlementbackend.messagesender;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import s18746.financialsettlementbackend.employeemanager.Employee;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageSenderFacade {

    private final MessageSenderConfiguration messageSenderConfiguration;

    @Value("classpath:static/mail-resetpassword.html")
    Resource resetPasswordMailTemplate;
    @Value("classpath:static/mail-reminder.html")
    Resource reminderMailTemplate;
    @Value("${front.url}")
    private String frontendUrl;



    public void sendPasswordRecovery(String email, String uuid){
        try{
            String html = Files.toString(resetPasswordMailTemplate.getFile(), Charsets.UTF_8);
            html = html.replace("href=\"https://google.com\"","href=\""+frontendUrl+"/password-recover/"+uuid);
            html = html.replace("link2",frontendUrl+"/password-recover/"+uuid);
            messageSenderConfiguration.sendMail(email, html,"Password recovery",true);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void sendReminderToEmployeesMail(List<Employee> employees) {
//        employees.stream().map(employee -> sendReminderToEmployeesMail(employee.getEmail())).forEach();
       employees.forEach(employee -> {
           try {
               sendReminderEmail(employee.getEmail());
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       });
    }

    private void sendReminderEmail(String email) throws IOException {
        String html = Files.toString(resetPasswordMailTemplate.getFile(), Charsets.UTF_8);
        html = html.replace("href=\"https://google.com\"","href=\""+frontendUrl+"\"");
        html = html.replace("link2",frontendUrl);
        messageSenderConfiguration.sendMail(email, html,"Password recovery",true);
    }

    public void sendInvitationToApplication(String email) throws IOException {
        String html = Files.toString(resetPasswordMailTemplate.getFile(), Charsets.UTF_8);
        html = html.replace("href=\"https://google.com\"","href=\""+frontendUrl+"\"");
        html = html.replace("link2",frontendUrl);
        messageSenderConfiguration.sendMail(email, html,"Password recovery",true);
    }
}
