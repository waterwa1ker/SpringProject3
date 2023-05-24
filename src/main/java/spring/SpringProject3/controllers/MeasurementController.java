package spring.SpringProject3.controllers;



import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.SpringProject3.dto.MeasurementDTO;
import spring.SpringProject3.dto.SensorDTO;
import spring.SpringProject3.models.Measurement;
import spring.SpringProject3.models.Sensor;
import spring.SpringProject3.services.MeasurementService;
import spring.SpringProject3.services.SensorService;
import spring.SpringProject3.util.measurementexception.MeasurementNotCreatedException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;
    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementController(MeasurementService measurementService, SensorService sensorService, ModelMapper modelMapper) {
        this.measurementService = measurementService;
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<MeasurementDTO> getMeasurements(){
        return measurementService.findAll().stream().map(this::convertToMeasurementDTO).collect(Collectors.toList());
    }

    @GetMapping("/rainyDaysCount")
    public List<MeasurementDTO> getRainyMeasurements(){
        return measurementService.findByIsRainingTrue().stream().map(this::convertToMeasurementDTO).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@Valid @RequestBody MeasurementDTO  measurementDTO,
                                          BindingResult bindingResult){
        System.out.println(measurementDTO);
        if (bindingResult.hasErrors())
            throw new MeasurementNotCreatedException("Measurement not created. Check your fields");
        measurementService.save(convertToMeasurement(measurementDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO){
        Measurement measurement = new Measurement(measurementDTO.getValue(), measurementDTO.isRaining());
        Sensor sensor = convertToSensor(measurementDTO.getSensorDTO());
        sensorService.save(sensor);
        measurement.setSensor(sensor);
        return measurement;
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }


}
