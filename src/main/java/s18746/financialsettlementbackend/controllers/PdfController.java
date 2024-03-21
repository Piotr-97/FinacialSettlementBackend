package s18746.financialsettlementbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PdfController {

    @GetMapping("/pobierz-pdf")
    public void pobierzPdf(HttpServletResponse response) throws IOException {
        // Ustaw nagłówki odpowiedzi
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=plik.pdf");

        // Wczytaj plik PDF z dysku lub generuj go dynamicznie
        FileInputStream fileInputStream = new FileInputStream("hello.pdf");

        // Przepisz dane z FileInputStream do OutputStream odpowiedzi
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        fileInputStream.close();
        outputStream.flush();
    }

}
