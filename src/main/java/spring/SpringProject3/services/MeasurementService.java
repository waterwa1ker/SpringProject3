package spring.SpringProject3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.SpringProject3.models.Measurement;
import spring.SpringProject3.repositories.MeasurementRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<Measurement> findAll(){
        return measurementRepository.findAll();
    }

    public List<Measurement> findByIsRainingTrue(){
        return measurementRepository.findByIsRainingTrue();
    }

    @Transactional
    public void save(Measurement measurement){
        measurementRepository.save(measurement);
    }

}
