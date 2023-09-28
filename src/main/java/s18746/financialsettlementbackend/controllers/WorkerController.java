package s18746.financialsettlementbackend.controllers;


import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.workerManager.Worker;
import s18746.financialsettlementbackend.workerManager.WorkerService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workers")
@AllArgsConstructor
public class WorkerController {


    private final WorkerService workerService;


    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorker(@PathVariable Long id) {

        Optional<Worker> worker = workerService.getWorkerById(id);
        return worker.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
        workerService.addWorker(worker);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id){

        workerService.deleteWorkerById(id);
    }

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
