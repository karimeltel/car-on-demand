package car.service;

import car.domain.CarEntity;
import car.domain.DemandEntity;
import car.domain.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface DemandService {

    DemandEntity create(DemandEntity entity) throws Exception;

    DemandEntity update(DemandEntity entity) throws Exception;

    Collection<DemandEntity> findAll();

    DemandEntity findById(Integer id) throws Exception;

    void deleteById(Integer id) throws Exception;

}