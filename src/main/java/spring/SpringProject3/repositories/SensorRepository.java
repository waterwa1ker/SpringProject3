package spring.SpringProject3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.SpringProject3.models.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
