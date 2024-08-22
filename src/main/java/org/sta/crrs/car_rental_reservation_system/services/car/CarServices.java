package org.sta.crrs.car_rental_reservation_system.services.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sta.crrs.car_rental_reservation_system.models.car.*;
import org.sta.crrs.car_rental_reservation_system.repositories.car.*;

import java.util.List;
import java.util.Optional;


@Service
public class CarServices {

    private final CarRepository carRepository;
    private final CarModelRepository carModelRepository;
    private final BrandRepository brandRepository;
    private final BodyTypeRepository bodyTypeRepository;
    private final ColorRepository colorRepository;

    @Autowired
    public CarServices(CarRepository carRepository, BrandRepository brandRepository, CarModelRepository carModelRepository, BodyTypeRepository bodyTypeRepository, ColorRepository colorRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.carModelRepository = carModelRepository;
        this.bodyTypeRepository = bodyTypeRepository;
        this.colorRepository = colorRepository;
    }

    public List<Car> findAvailableCars() {
        return this.carRepository.findAllByStatus(Status.AVAILABLE);//findByAvailable

    }

    public void createCar(Car car) {//throws Exception
        //car details init//Fetch related entities or create new related entity first
        Optional<BodyType> bodyTypeOpt = addBodyType(car.getBodyType().getName());
        Optional<Brand> brandOpt = addBrand(car.getBrand().getName());
        Optional<CarModel> carModelOpt = addModel(car.getCarModel().getName());
        Optional<CarColor> carColorOpt = addCarColor(car.getCarColor().getName());
//can be replaced with isEmpty()
        if (!bodyTypeOpt.isPresent() || !brandOpt.isPresent() || !carModelOpt.isPresent() || !carColorOpt.isPresent()) {
            throw new IllegalArgumentException("One or more related entities not found.");
        }

        car.setBrand(brandOpt.get());
        car.setCarModel(carModelOpt.get());
        car.setBodyType(bodyTypeOpt.get());
        car.setCarColor(carColorOpt.get());

        // Add car to database
        this.carRepository.save(car);
    }

    public List<Car> findAllCars() {//throws Exception {
        return this.carRepository.findAll();
    }


    public Car findCarById(Long carId) {
        return this.carRepository.findById(carId).get(); //isPresent check
    }

    public Boolean existsCarById(Long carId) {//throws Exception
        return this.carRepository.existsById(carId);
    }

    public void updateCar(Car car) throws Exception {
        this.carRepository.save(car);
    }

    public void deleteCar(Long carId) throws Exception {
        carRepository.deleteById(carId);
    }

    //check and add car detailes if needed
    private Optional<Brand> addBrand(String brandName) {
        Brand brand = new Brand();
        brand.setName(brandName);
        return Optional.of(Optional.ofNullable(brandRepository.findBrandByName(brandName)).orElseGet(() -> brandRepository.save(brand)));

    }



    private Optional<CarModel> addModel(String modelName) {
        CarModel carModel = new CarModel();
        carModel.setName(modelName);
        return Optional.of(Optional.ofNullable(carModelRepository.findCarModelByName(modelName)).orElseGet(() -> carModelRepository.save(carModel)));
    }

    private Optional<BodyType> addBodyType(String bodyTypeName) {
        BodyType bodyType = new BodyType();
        bodyType.setName(bodyTypeName);
        return Optional.of(Optional.ofNullable(bodyTypeRepository.findBodyTypeByName(bodyTypeName)).orElseGet(() -> bodyTypeRepository.save(bodyType)));
    }

    private Optional<CarColor> addCarColor(String carColorName) {
        CarColor carColor = new CarColor();
        carColor.setName(carColorName);
        return Optional.of(Optional.ofNullable(colorRepository.findCarColorByName(carColorName)).orElseGet(() -> colorRepository.save(carColor)));
    }

}
