package s18746.financialsettlementbackend.messagesender;


import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MessageSenderFacade {

    private final InvitationSender invitationSender;
    private final SettlementReminderDispatcher settlementReminderDispatcher;




    public void sendInvitationForEmployee(String email){

    }


    public void sendSettlementRemind(List<String> emails){

    }

}
