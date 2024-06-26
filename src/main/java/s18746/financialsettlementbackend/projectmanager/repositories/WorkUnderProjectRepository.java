package s18746.financialsettlementbackend.projectmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s18746.financialsettlementbackend.projectmanager.entities.WorkUnderProject;

import java.util.Optional;

@Repository
public interface WorkUnderProjectRepository extends JpaRepository< WorkUnderProject, Long> {


    Optional<WorkUnderProject> findWorkUnderProjectByUuid(String uuid);
}
