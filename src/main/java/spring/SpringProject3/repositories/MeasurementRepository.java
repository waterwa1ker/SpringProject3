package spring.SpringProject3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.SpringProject3.models.Measurement;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    List<Measurement> findByIsRainingTrue();
    
}
