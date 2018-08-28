package car.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Builder
@Data
@Entity
@Table(name = "demand")
@JsonAutoDetect
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemandEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="demand_id")
    private int demandId;

    @ManyToOne
    private UserEntity user;

    private double pickUpLocation;

    private double dropOffLocation;

    private String model;

    private String engine;

    private String infotainmentSystem;

    private String interiorDesign;

    private Date pickUpTime;

    private Date dropOffTime;

}