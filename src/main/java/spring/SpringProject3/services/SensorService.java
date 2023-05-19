package spring.SpringProject3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.SpringProject3.models.Sensor;
import spring.SpringProject3.repositories.SensorRepository;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll(){
        return sensorRepository.findAll();
    }
}
