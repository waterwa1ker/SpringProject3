package spring.SpringProject3.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import spring.SpringProject3.models.Measurement;
import spring.SpringProject3.services.MeasurementService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    public MeasurementService measurementService;
    
    @GetMapping("/measurements")
    public List<Measurement> getMeasurements(){
        return measurementService.findAll();
    }
    
}
