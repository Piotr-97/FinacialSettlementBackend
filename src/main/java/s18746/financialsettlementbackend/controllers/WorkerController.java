package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s18746.financialsettlementbackend.services.WorkerService;

@RestController
@RequestMapping("/worker")
@AllArgsConstructor
public class WorkerController {


    private final WorkerService workerService;






}
