package car.repository;

import car.domain.DemandEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DemandRepository
        extends CrudRepository<DemandEntity, Integer> {

    DemandEntity findTopByUser_UserId(Integer userId) throws Exception;


}
