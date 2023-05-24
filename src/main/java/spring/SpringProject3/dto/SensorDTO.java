package spring.SpringProject3.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import spring.SpringProject3.models.Measurement;

import java.util.List;

public class SensorDTO {

    //check unique name
    @Size(min = 3, max = 30, message = "Name's size should be between 3 and 30")
    @Column(name = "name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
