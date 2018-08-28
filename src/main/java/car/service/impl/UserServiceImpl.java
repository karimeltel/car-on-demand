package car.service.impl;

import car.domain.DemandEntity;
import car.domain.UserEntity;
import car.repository.DemandRepository;
import car.repository.UserRepository;
import car.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    private static final String ID_DOES_NOT_EXIST = "ID does not exist ";
    private static final String ID_MUST_BE_PROVIDED = "ID must be provided";
    private static final String CAN_NOT_DELETE_USER = "Can not delete; user has at least one booking!";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DemandRepository demandRepository;

    @Override
    public UserEntity create(UserEntity user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public UserEntity update(UserEntity user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public Collection<UserEntity> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public UserEntity findById(Integer id) throws Exception {
        if (id == null) {
            throw new Exception(ID_MUST_BE_PROVIDED);
        }

        Optional<UserEntity> entity = Optional.ofNullable(userRepository.findOne(id));
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
        }else{
            if(demandRepository.findTopByUser_UserId(id) == null){
                userRepository.delete(id);
            } else {
                throw new Exception(CAN_NOT_DELETE_USER);
            }
        }

    }
}