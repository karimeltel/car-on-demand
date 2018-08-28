package car.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Builder
@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="user_id")
    private int userId;

    private String name;

    @Column(length=1)
    private String gender;

    private int age;
}