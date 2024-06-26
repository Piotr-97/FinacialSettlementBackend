package s18746.financialsettlementbackend.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import s18746.financialsettlementbackend.autht.Role;
import s18746.financialsettlementbackend.autht.User;
import s18746.financialsettlementbackend.autht.UserRepository;
import s18746.financialsettlementbackend.employeemanager.Employee;
import s18746.financialsettlementbackend.employeemanager.EmployeeRepository;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementStatus;
import s18746.financialsettlementbackend.financialsettelmentsmanager.SettlementType;
import s18746.financialsettlementbackend.financialsettelmentsmanager.repositories.FinancialSettlementRepository;
import s18746.financialsettlementbackend.projectmanager.repositories.WorkUnderProjectRepository;
import s18746.financialsettlementbackend.projectmanager.ProjectRepository;
import s18746.financialsettlementbackend.projectmanager.entities.Address;
import s18746.financialsettlementbackend.projectmanager.entities.Client;
import s18746.financialsettlementbackend.projectmanager.entities.Project;
import s18746.financialsettlementbackend.projectmanager.entities.WorkUnderProject;
import s18746.financialsettlementbackend.projectmanager.repositories.AddressRepository;
import s18746.financialsettlementbackend.projectmanager.repositories.ClientRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class DataInitializer {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private WorkUnderProjectRepository workUnderProjectRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    FinancialSettlementRepository financialSettlementRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        // Tworzenie przykładowych danych dla Address
        Address address1 = Address.builder()
                .street("123 Main St")
                .build();

        Address address2 = Address.builder()
                .street("456 Elm St")
                .build();

        addressRepository.save(address1);
        addressRepository.save(address2);

        // Tworzenie przykładowych danych dla Client
        Client client1 = new Client();
        client1.setName("Client One");
        client1.setNip("1234567890");
        client1.setAddress(address1);

        Client client2 = new Client();
        client2.setName("Client Two");
        client2.setNip("0987654321");
        client2.setAddress(address2);

        clientRepository.save(client1);
        clientRepository.save(client2);

        // Tworzenie przykładowych danych dla Project
        Project project1 = new Project();
        project1.setName("Project One");
        project1.setClient(client1);

        Project project2 = new Project();
        project2.setName("Project Two");
        project2.setClient(client2);

        projectRepository.save(project1);
        projectRepository.save(project2);

        WorkUnderProject work1 = new WorkUnderProject();
        work1.setId(2L);
        work1.setProject(project1);
        work1.setName("Work One");
        work1.setDescription("Description of Work One");
        work1.setFinancialSettlements(new HashSet<>());

        WorkUnderProject work2 = new WorkUnderProject();
        work1.setId(1L);
        work2.setProject(project2);
        work2.setName("Work Two");
        work2.setDescription("Description of Work Two");
        work2.setFinancialSettlements(new HashSet<>());

        workUnderProjectRepository.save(work1);
        workUnderProjectRepository.save(work2);

        // Ustawienie workUnderProject w Project
        Set<WorkUnderProject> worksForProject1 = new HashSet<>();
        worksForProject1.add(work1);
        project1.setWorkUnderProject(worksForProject1);

        Set<WorkUnderProject> worksForProject2 = new HashSet<>();
        worksForProject2.add(work2);
        project2.setWorkUnderProject(worksForProject2);

        projectRepository.save(project1);
        projectRepository.save(project2);
        User user1 = new User();
        user1.setEmail("pikarolak12@gmail.com");
        user1.setPassword(passwordEncoder.encode("password123"));
        user1.setRole(Role.ROLE_ADMIN);
        userRepository.save(user1);
        List<Employee> employeeList = new ArrayList<>();
        // Tworzenie przykładowych danych dla Employee
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setEmail("user" + i + "@example.com");
            user.setPassword(passwordEncoder.encode("password" + i));
            user.setRole(Role.ROLE_USER);
            userRepository.save(user);

            Employee employee = Employee.builder()
                    .user(user)
                    .firstname("Firstname" + i)
                    .lastname("Lastname" + i)
                    .email("user" + i + "@example.com")
                    .build();
            employee.setUuid(user.getUuid());
            employeeRepository.save(employee);
            employeeList.add(employee);
        }



        for (int i = 1; i <= 10; i++) {
            FinancialSettlement settlement = FinancialSettlement.builder()
                    .description("Settlement description " + i)
                    .amountOfMoney(BigDecimal.valueOf(1000 + i * 100))
                    .status(FinancialSettlementStatus.PENDING)
                    .workUnderProject(i % 2 == 0 ? work1 : work2)
                    .employee(employeeList.get(i-1))
                            .settlementType(SettlementType.GENERAL)
                    .date(LocalDateTime.now().minusDays(i))
                    .uuid(UuidGenerator.generateUuid())
                    .build();
            financialSettlementRepository.save(settlement);
        }
    }
}


