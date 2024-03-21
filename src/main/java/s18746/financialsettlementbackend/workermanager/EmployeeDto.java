package s18746.financialsettlementbackend.workermanager;

import java.time.LocalDate;

public record EmployeeDto(Long id, String firstname, String lastname, LocalDate birthdate) {
}
