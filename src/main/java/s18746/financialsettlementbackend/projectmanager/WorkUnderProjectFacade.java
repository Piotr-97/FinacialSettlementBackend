package s18746.financialsettlementbackend.projectmanager;


import lombok.AllArgsConstructor;
import s18746.financialsettlementbackend.projectmanager.repositories.WorkUnderProjectRepository;
import s18746.financialsettlementbackend.projectmanager.entities.WorkUnderProject;

import java.util.Optional;

@AllArgsConstructor
public class WorkUnderProjectFacade {


    WorkUnderProjectRepository workUnderProjectRepository;
    public WorkUnderProject findWorkUnderProjectById(String workId) {
        Long id  = Long.valueOf(workId);
        Optional<WorkUnderProject> byId = workUnderProjectRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        throw new WorkUnderProjectException("Couldn't find work");
    }
}
