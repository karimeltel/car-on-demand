package car.service;

import car.domain.BookingEntity;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    BookingEntity create(Integer demandId) throws Exception;

}