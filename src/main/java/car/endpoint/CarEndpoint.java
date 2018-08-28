package car.endpoint;

import car.domain.CarEntity;
import car.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Api("Operation for Cars")
@RestController
@RequestMapping("/car")
public class CarEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarEndpoint.class);

    @Autowired
    private CarService carService;


    @ApiOperation("Create a car")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarEntity create(@RequestBody @Valid CarEntity entity) throws Exception {
        CarEntity car = carService.create(entity);
        return car;
    }

    @ApiOperation("Find all cars")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CarEntity> findAll() {
        Collection<CarEntity> cars = carService.findAll();
        return cars;
    }

    @ApiOperation("Update a car")
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CarEntity update(@RequestBody @Valid CarEntity entity) throws Exception {
        return carService.update(entity);
    }

    @ApiOperation("Find a car by an Id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarEntity findOne(@PathVariable Integer id) throws Exception {
        CarEntity car = carService.findById(id);
        return car;
    }

    @ApiOperation("Delete a car by an Id")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        carService.deleteById(id);
    }


}