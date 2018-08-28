package car.service.impl;

import car.domain.CarEntity;
import car.repository.CarRepository;
import car.service.CarService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

    private static final String ID_DOES_NOT_EXIST = "ID does not exist ";
    private static final String ID_MUST_BE_PROVIDED = "ID must be provided";

    @Autowired
    private CarRepository repository;


    @Override
    @Transactional(rollbackOn = Exception.class)
    public CarEntity create(CarEntity entity) throws Exception {
        return repository.save(entity);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public CarEntity update(CarEntity entity) throws Exception {
        return repository.save(entity);
    }

    @Override
    public Collection<CarEntity> findAll() {
        if (repository.findAll() == null) {
            return Lists.newArrayList();
        }
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public CarEntity findById(Integer id) throws Exception {

        if (id == null) {
            throw new Exception(ID_MUST_BE_PROVIDED);
        }

        Optional<CarEntity> entity = Optional.ofNullable(repository.findOne(id));
        if (!entity.isPresent()) {
            throw new Exception(ID_DOES_NOT_EXIST);
        } else {
            return entity.get();
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        if (id == null) {
            throw new Exception(ID_MUST_BE_PROVIDED);
        }
        repository.delete(id);
    }
}
