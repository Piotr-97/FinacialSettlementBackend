package s18746.financialsettlementbackend.projectmanager;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s18746.financialsettlementbackend.projectmanager.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
