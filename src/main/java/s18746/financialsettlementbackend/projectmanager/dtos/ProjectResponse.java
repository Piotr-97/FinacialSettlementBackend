package s18746.financialsettlementbackend.projectmanager.dtos;

import s18746.financialsettlementbackend.projectmanager.dtos.WorkUnderProjectResponse;


import java.util.List;

public record ProjectResponse(String name, String clientName, String projectUuid, List<WorkUnderProjectResponse> worksUnderProject) {
}
