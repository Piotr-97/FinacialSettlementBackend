package s18746.financialsettlementbackend.pdfcreator;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s18746.financialsettlementbackend.employeemanager.Employee;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.itextpdf.layout.property.TextAlignment.CENTER;

@AllArgsConstructor
@Service
public class PdfCreatorFacade {


    public byte[] createReport(List<FinancialSettlement> settlements) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            Document document = new Document(new com.itextpdf.kernel.pdf.PdfDocument(writer));
            document.add(new Paragraph("FinSettApp").setBold().setFontSize(25));

            Map<Employee, List<FinancialSettlement>> groupedByUser = settlements.stream()
                    .collect(Collectors.groupingBy(FinancialSettlement::getEmployee));

            for (Map.Entry<Employee, List<FinancialSettlement>> entry : groupedByUser.entrySet()) {
                Employee employee = entry.getKey();
                List<FinancialSettlement> userSettlements = entry.getValue();
                BigDecimal totalAmount = userSettlements.stream()
                        .map(FinancialSettlement::getAmountOfMoney)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                document.add(new Paragraph("Firstname and lastname: " + employee.getFirstname() + " " + employee.getLastname()));
                document.add(new Paragraph("UUID: " + userSettlements.get(0).getUuid()));
                document.add(new Paragraph("Settlement count: " + userSettlements.size()));
                document.add(new Paragraph("Total amount of money: " + totalAmount));
                document.add(new Paragraph("\n"));

                Table table = new Table(new float[]{1, 5, 3, 3});
                table.addHeaderCell(new Cell().add(new Paragraph("ID")).setTextAlignment(CENTER));
                table.addHeaderCell(new Cell().add(new Paragraph("Description")).setTextAlignment(CENTER));
                table.addHeaderCell(new Cell().add(new Paragraph("Cost")).setTextAlignment(CENTER));
                table.addHeaderCell(new Cell().add(new Paragraph("Date")).setTextAlignment(CENTER));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                for (FinancialSettlement settlement : userSettlements) {
                    table.addCell(new Cell().add(new Paragraph(settlement.getId().toString())));
                    table.addCell(new Cell().add(new Paragraph(settlement.getDescription())));
                    table.addCell(new Cell().add(new Paragraph(settlement.getAmountOfMoney().toString())));
                    table.addCell(new Cell().add(new Paragraph(settlement.getDate().format(formatter))));
                }

                document.add(table);
                document.add(new Paragraph("\n\n"));
            }

            document.close();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }




}
