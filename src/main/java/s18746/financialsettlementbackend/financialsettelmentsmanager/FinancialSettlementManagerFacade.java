package s18746.financialsettlementbackend.financialsettelmentsmanager;

import lombok.AllArgsConstructor;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementDto;
import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementRequest;
import s18746.financialsettlementbackend.employeemanager.Employee;
import s18746.financialsettlementbackend.employeemanager.EmployeeDto;
import s18746.financialsettlementbackend.employeemanager.EmployeeManagerFacade;
import s18746.financialsettlementbackend.financialsettelmentsmanager.exceptions.ProjectNotFoundException;
import s18746.financialsettlementbackend.financialsettelmentsmanager.repositories.FinancialSettlementRepository;
import s18746.financialsettlementbackend.projectmanager.ProjectManagerFacade;
import s18746.financialsettlementbackend.projectmanager.WorkUnderProjectFacade;
import s18746.financialsettlementbackend.projectmanager.entities.Address;
import s18746.financialsettlementbackend.projectmanager.entities.WorkUnderProject;
import s18746.financialsettlementbackend.projectmanager.repositories.AddressRepository;
import s18746.financialsettlementbackend.utils.SettlementMapper;
import s18746.financialsettlementbackend.utils.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FinancialSettlementManagerFacade {

    private final FinancialSettlementRepository financialSettlementRepository;
    private final WorkUnderProjectFacade workUnderProjectFacade;
    private final ProjectManagerFacade projectManagerFacade;
    private final EmployeeManagerFacade employeeManagerFacade;
    private final AddressRepository addressRepository;


    public void createNewSettlement(FinancialSettlementRequest financialSettlementRequest) throws ProjectNotFoundException {
        WorkUnderProject workUnderProjectById = workUnderProjectFacade.findWorkUnderProjectById(financialSettlementRequest.workId());
        Employee employee = employeeManagerFacade.getEmployeeById(Long.parseLong(financialSettlementRequest.employeeId()));
        if (financialSettlementRequest.settlementType().equals(SettlementType.TAXI.getType())) {
            TaxiSettlement taxiSettlement = createTaxiSettlement(financialSettlementRequest, workUnderProjectById, employee);
            financialSettlementRepository.save(taxiSettlement);
            return;
        } else if (financialSettlementRequest.settlementType().equals(SettlementType.GENERAL.getType())) {
            FinancialSettlement financialSettlement = createFinancialSettlement(financialSettlementRequest, workUnderProjectById, employee);
            financialSettlementRepository.save(financialSettlement);
            return;
        } else if (financialSettlementRequest.settlementType().equals(SettlementType.BUSSINESMEETING.getType())) {
            BusinessMeetingSettlement businessMeetingSettlement = createBusinessMeetingSettlement(financialSettlementRequest, workUnderProjectById, employee);
            financialSettlementRepository.save(businessMeetingSettlement);
            return ;
        } else if (financialSettlementRequest.settlementType().equals(SettlementType.BUSSINESTRIP.getType())) {
            TripSettlement tripFinancialSettlement = createTripFinancialSettlement(financialSettlementRequest, workUnderProjectById, employee);
            financialSettlementRepository.save(tripFinancialSettlement);
            return;
        }
    }

    private TripSettlement createTripFinancialSettlement(FinancialSettlementRequest financialSettlementRequest, WorkUnderProject workUnderProjectById, Employee employee) {

        return TripSettlement.builder()
                .settlementType(SettlementType.valueOf(financialSettlementRequest.settlementType()))
                .status(FinancialSettlementStatus.PENDING)
                .date(LocalDateTime.now())
                .describe(financialSettlementRequest.description())
                .workUnderProject(workUnderProjectById)
                .amountOfMoney(BigDecimal.valueOf(Double.parseDouble(financialSettlementRequest.amountOfMoney())))
                .employee(employee)
                .country(financialSettlementRequest.country())
                .uuid(UuidGenerator.generateUuid())
                .build();
    }

    private BusinessMeetingSettlement createBusinessMeetingSettlement(FinancialSettlementRequest financialSettlementRequest, WorkUnderProject workUnderProjectById, Employee employee) {
        return BusinessMeetingSettlement.builder()
                .settlementType(SettlementType.BUSSINESMEETING)
                .status(FinancialSettlementStatus.PENDING)
                .date(LocalDateTime.now())
                .describe(financialSettlementRequest.description())
                .workUnderProject(workUnderProjectById)
                .amountOfMoney(BigDecimal.valueOf(Double.parseDouble(financialSettlementRequest.amountOfMoney())))
                .employee(employee)
                .place(financialSettlementRequest.place())
                .uuid(UuidGenerator.generateUuid())
                .build();
    }

    private TaxiSettlement createTaxiSettlement(FinancialSettlementRequest financialSettlementRequest, WorkUnderProject workUnderProjectById, Employee employee) {
        Address startAddress = Address.builder().street(financialSettlementRequest.startAddress()).build();
        Address targetAddress = Address.builder().street(financialSettlementRequest.targetAddress()).build();
        addressRepository.save(startAddress);
        addressRepository.save(targetAddress);
        return TaxiSettlement.builder()
                .settlementType(SettlementType.valueOf(financialSettlementRequest.settlementType()))
                .status(FinancialSettlementStatus.PENDING)
                .date(LocalDateTime.now())
                .describe(financialSettlementRequest.description())
                .workUnderProject(workUnderProjectById)
                .amountOfMoney(BigDecimal.valueOf(Double.parseDouble(financialSettlementRequest.amountOfMoney())))
                .employee(employee)
                .startAddress(startAddress)
                .targetAddress(targetAddress)
                .uuid(UuidGenerator.generateUuid())
                .build();
    }

    private FinancialSettlement createFinancialSettlement(FinancialSettlementRequest financialSettlementRequest, WorkUnderProject workUnderProjectById, Employee employee) {
        return FinancialSettlement.builder()
                .settlementType(SettlementType.valueOf(financialSettlementRequest.settlementType()))
                .status(FinancialSettlementStatus.PENDING)
                .date(LocalDateTime.now())
                .describe(financialSettlementRequest.description())
                .workUnderProject(workUnderProjectById)
                .amountOfMoney(BigDecimal.valueOf(Double.parseDouble(financialSettlementRequest.amountOfMoney())))
                .employee(employee)
                .build();
    }

    public List<FinancialSettlementDto> getAllFinancialSettlements() {
        List<FinancialSettlementDto> settlementDtos = financialSettlementRepository.findAll().stream()
                .map(SettlementMapper::mapSettlementToDto)
                .toList();
        return settlementDtos;
    }

    public Optional<FinancialSettlement> getFinancialSettlementByUuId(String uuid) {
        return financialSettlementRepository.findFinancialSettlementByUuid(uuid);
    }

    public void deleteFinancialSettlementById(Long id) {
        financialSettlementRepository.deleteById(id);
    }

    public List<FinancialSettlementRequest> getFinancialSettlementsByEmployeee(EmployeeDto employee) {
        Long employeeId = employee.id();
        List<FinancialSettlement> settlementsByUser = financialSettlementRepository.findAllByEmployeeId(employeeId);
        return null;
    }
    public List<FinancialSettlementDto> findFinancialSettlementsByEmployeeUuid(String uuid){
        Employee employeeByUuid = employeeManagerFacade.getEmployeeByUuid(uuid);
        List<FinancialSettlement> allByEmployeeId = financialSettlementRepository.findAllByEmployeeId(employeeByUuid.getId());
        return allByEmployeeId.stream()
                .map(SettlementMapper::mapSettlementToDto)
                .toList();
    }
}
