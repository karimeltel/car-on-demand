package car.service.impl;

import car.domain.BookingEntity;
import car.domain.CarEntity;
import car.domain.DemandEntity;
import car.repository.BookingRepository;
import car.repository.CarRepository;
import car.repository.DemandRepository;
import car.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class BookingServiceImpl implements BookingService {
    
    private static final String ID_HAS_NO_DEMAND = "User has no demands";
    private static final String ID_MUST_BE_PROVIDED = "ID must be provided";
    private static final String NO_AVAILABLE_CARS = "No cars available";

    @Autowired
    private DemandRepository demandRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private  BookingRepository bookingRepository;


    @Override
    public BookingEntity create(Integer demandId) throws Exception {
        if (demandId == null) {
            throw new Exception(ID_MUST_BE_PROVIDED);
        }

        Optional<DemandEntity> entity = Optional.ofNullable(demandRepository.findOne(demandId));
        if (!entity.isPresent()) {
            throw new Exception(ID_HAS_NO_DEMAND);
        }

        DemandEntity demand = entity.get();
        List<CarEntity> list = carRepository.findByEngineAndInfotainmentSystemAndInteriorDesignAndModel(
                demand.getEngine(),demand.getInfotainmentSystem(), demand.getInteriorDesign(), demand.getModel());
        AtomicReference<CarEntity> nearestCar = new AtomicReference<>(list.get(0));
        if (list.size() == 0) {
            throw new Exception(NO_AVAILABLE_CARS);
        } else {
            list.forEach((car) -> {
                if (Math.abs((car.getLocation() - demand.getPickUpLocation())) < Math.abs(nearestCar.get().getLocation() - demand.getPickUpLocation())) {
                    nearestCar.set(car);
                }
            });
        }

        BookingEntity booking = BookingEntity.builder().car(nearestCar.get()).demand(demand).build();

        return bookingRepository.save(booking);
    }
}