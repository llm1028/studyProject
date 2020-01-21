package com.fiuty.pattern.service;

import com.fiuty.domain.Animal;
import com.fiuty.domain.People;
import com.fiuty.domain.RequestDTO;

/**
 * @author Fiuty
 */
public class SimpleFactoryAdvanceServiceImpl implements SimpleFactoryAdvanceService {

    @Override
    public RequestDTO<People> createPeople(String name) {
        return new RequestDTO<>(new People(name));
    }

    @Override
    public RequestDTO<Animal> createAnimal(String name) {
        return new RequestDTO<>(new Animal(name));
    }
}
