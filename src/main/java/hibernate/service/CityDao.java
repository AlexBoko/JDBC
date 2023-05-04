package hibernate.service;

import hibernate.model.City;

import java.util.List;

public interface CityDao{

    City create(City city);

    City getCityById(int id);

    List <City> getAllCities();

    City updateCity(City city);

    void deletedCity(City city);

}
