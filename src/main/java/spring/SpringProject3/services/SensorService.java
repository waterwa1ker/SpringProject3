package spring.SpringProject3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.SpringProject3.models.Sensor;
import spring.SpringProject3.repositories.SensorRepository;
import spring.SpringProject3.util.sensorexception.SensorNotCreatedException;

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

    @Transactional
    public void save(Sensor sensor){
        boolean flag = false;
        List<Sensor> sensors = findAll();
        for (Sensor sensorr:
             sensors) {
            if (sensorr.getName().equals(sensor.getName()))
            flag = true;
        }
        if (!flag)
            sensorRepository.save(sensor);
        else
            throw new SensorNotCreatedException("Sensor with this name already exists!");
    }
}
