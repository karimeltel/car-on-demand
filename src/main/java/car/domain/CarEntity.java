package car.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Builder
@Data
@Entity
@Table(name = "car")
@JsonAutoDetect
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="car_id")
    private int carId;

    private String model;
    
    private String engine;

    private String infotainmentSystem;
    
    private String interiorDesign;
    
    private double location;
    

}