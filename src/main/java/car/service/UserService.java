package car.service;

import car.domain.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {

    UserEntity create(UserEntity user) throws Exception;

    UserEntity update(UserEntity user) throws Exception;

    Collection<UserEntity> findAll();

    UserEntity findById(Integer id) throws Exception;
   
    void deleteById(Integer id) throws Exception;
}