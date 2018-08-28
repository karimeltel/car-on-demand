package car.endpoint;

import car.domain.UserEntity;
import car.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Api("Operation for Users")
@RestController
@RequestMapping("/user")
public class UserEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEndpoint.class);

    @Autowired
    private UserService userService;


    @ApiOperation("Create a user")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity create(@RequestBody @Valid UserEntity entity) throws Exception {
        UserEntity user = userService.create(entity);
        return user;
    }

    @ApiOperation("Find all users")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<UserEntity> findAll() {
        Collection<UserEntity> user = userService.findAll();
        return user;
    }

    @ApiOperation("Update a user")
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity update(@RequestBody @Valid UserEntity entity) throws Exception {
        return userService.update(entity);
    }

    @ApiOperation("Find a user by an Id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity findOne(@PathVariable Integer id) throws Exception {
        UserEntity user = userService.findById(id);
        return user;
    }

    @ApiOperation("Delete a user by an Id")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        userService.deleteById(id);
    }


}