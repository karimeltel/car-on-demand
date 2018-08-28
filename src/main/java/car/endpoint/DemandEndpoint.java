package car.endpoint;

import car.domain.DemandEntity;
import car.service.DemandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Api("Operation for demands")
@RestController
@RequestMapping("/demand")
public class DemandEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemandEndpoint.class);

    @Autowired
    private DemandService demandService;


    @ApiOperation("Create a demand")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DemandEntity create(@RequestBody @Valid DemandEntity entity) throws Exception {
        DemandEntity car = demandService.create(entity);
        return car;
    }

    @ApiOperation("Find all demands")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<DemandEntity> findAll() {
        Collection<DemandEntity> demand = demandService.findAll();
        return demand;
    }

    @ApiOperation("Update a demand")
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DemandEntity update(@RequestBody @Valid DemandEntity entity) throws Exception {
        return demandService.update(entity);
    }

    @ApiOperation("Find a demand by an Id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DemandEntity findOne(@PathVariable Integer id) throws Exception {
        DemandEntity demand = demandService.findById(id);
        return demand;
    }

    @ApiOperation("Delete a demand by Id")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        demandService.deleteById(id);
    }


}