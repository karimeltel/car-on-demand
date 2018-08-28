package car.repository;

import car.domain.CarEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository
        extends CrudRepository<CarEntity, Integer> {


    List<CarEntity> findByEngineAndInfotainmentSystemAndInteriorDesignAndModel(
            String engine, String infotainmentSystem, String interiorDesign, String model) throws Exception;



}
