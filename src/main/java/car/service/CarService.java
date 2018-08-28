package car.service;

import car.domain.CarEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface CarService {

    CarEntity create(CarEntity entity) throws Exception;

    CarEntity update(CarEntity entity) throws Exception;

    Collection<CarEntity> findAll();

    CarEntity findById(Integer id) throws Exception;

    void deleteById(Integer id) throws Exception;

}