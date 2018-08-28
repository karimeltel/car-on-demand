package car.service.impl;

import car.domain.DemandEntity;
import car.repository.DemandRepository;
import car.repository.UserRepository;
import car.service.DemandService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class DemandServiceImpl implements DemandService {

    private static final String ID_DOES_NOT_EXIST = "ID does not exist ";
    private static final String ID_MUST_BE_PROVIDED = "ID must be provided";
    private static final String NOT_A_VALID_USER = "Not a valid user id";

    @Autowired
    private DemandRepository demandRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public DemandEntity create(DemandEntity user) throws Exception {
        if (userRepository.findOne(user.getUser().getUserId())== null) {
            throw new Exception(NOT_A_VALID_USER);
        }
         return demandRepository.save(user);
    }

    @Override
    public DemandEntity update(DemandEntity user) throws Exception {
        if (userRepository.findOne(user.getUser().getUserId())== null) {
            throw new Exception(NOT_A_VALID_USER);
        }
        return demandRepository.save(user);
    }

    @Override
    public Collection<DemandEntity> findAll() {
        return Lists.newArrayList(demandRepository.findAll());
    }

    @Override
    public DemandEntity findById(Integer id) throws Exception {
        if (id == null) {
            throw new Exception(ID_MUST_BE_PROVIDED);
        }

        Optional<DemandEntity> entity = Optional.ofNullable(demandRepository.findOne(id));
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
        demandRepository.delete(id);
    }
}