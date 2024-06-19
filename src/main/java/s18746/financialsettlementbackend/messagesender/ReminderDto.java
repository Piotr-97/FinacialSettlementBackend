package s18746.financialsettlementbackend.messagesender;

import jakarta.validation.constraints.Email;

import java.util.List;

public record ReminderDto(@Email List<String> emails) {
}
