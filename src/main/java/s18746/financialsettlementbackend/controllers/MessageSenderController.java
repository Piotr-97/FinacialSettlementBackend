package s18746.financialsettlementbackend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s18746.financialsettlementbackend.messagesender.ReminderDto;

@RestController
@RequestMapping("/sender")
public class MessageSenderController {



    @GetMapping("/invite")
    public void sendInvitation(@RequestBody String email){

    }


    @GetMapping("/reminder")
    public void sendReminder(@RequestBody ReminderDto listOfEmails){

    }





}
