package car.endpoint;

import car.domain.BookingEntity;
import car.service.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("Operation for Booking")
@RestController
@RequestMapping("/book")
public class BookingEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingEndpoint.class);

    @Autowired
    private BookingService bookingService;


    @ApiOperation("Create a booking")
    @RequestMapping(method = RequestMethod.POST, value = "/{demandId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingEntity create(@PathVariable Integer demandId) throws Exception {
        return bookingService.create(demandId);
    }

}