package spring.SpringProject3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


@Entity
@Table(name = "measurement")
public class Measurement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    @Min(value = -100, message = "Value should be greater than -100")
    @Max(value = 100, message = "Value should be less than 100")
    private float value;

    @Column(name = "raining")
    @NotNull(message = "isRaining shouldn't be null")
    private boolean isRaining;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Sensor should not be empty")
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(float value, boolean isRaining) {
        this.value = value;
        this.isRaining = isRaining;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
