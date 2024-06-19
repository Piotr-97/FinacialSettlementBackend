package s18746.financialsettlementbackend.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.messagesender.InvitationResponse;
import s18746.financialsettlementbackend.messagesender.MessageSenderFacade;
import s18746.financialsettlementbackend.messagesender.ReminderDto;

import java.io.IOException;

@RestController
@RequestMapping("/sender")
@RequiredArgsConstructor
public class MessageSenderController {

    private final MessageSenderFacade messageSenderFacade;


    @PostMapping("/invite")
    public ResponseEntity<?> sendInvitation(@RequestBody @Valid String email){
        try {
            messageSenderFacade.sendInvitationToApplication(email);
            return ResponseEntity.ok(new InvitationResponse("The invitation has been successfully sent"));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }








}
