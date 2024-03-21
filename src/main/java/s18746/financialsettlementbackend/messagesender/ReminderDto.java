package s18746.financialsettlementbackend.messagesender;

import java.util.List;

public record ReminderDto(List<String> emails) {
}
