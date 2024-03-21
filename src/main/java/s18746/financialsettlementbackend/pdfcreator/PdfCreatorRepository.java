package s18746.financialsettlementbackend.pdfcreator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface PdfCreatorRepository extends JpaRepository<PdfFileData, UUID> {
}
