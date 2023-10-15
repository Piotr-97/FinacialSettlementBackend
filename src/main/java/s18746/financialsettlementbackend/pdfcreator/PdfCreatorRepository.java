package s18746.financialsettlementbackend.pdfcreator;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PdfCreatorRepository extends JpaRepository<PdfFileData, UUID> {
}
