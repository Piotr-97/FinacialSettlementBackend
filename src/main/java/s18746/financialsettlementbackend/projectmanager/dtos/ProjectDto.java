package s18746.financialsettlementbackend.projectmanager.dtos;

import s18746.financialsettlementbackend.projectmanager.entities.WorkUnderProject;

import java.util.List;

public record ProjectDto(Long id, Long clientId, String clientName, List<WorkUnderProjectDto> worksUnderProjectDto, String projectName) {
}
