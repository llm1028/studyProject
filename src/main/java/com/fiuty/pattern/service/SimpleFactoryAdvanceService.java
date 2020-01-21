package com.fiuty.pattern.service;

import com.fiuty.domain.Animal;
import com.fiuty.domain.People;
import com.fiuty.domain.RequestDTO;

/**
 * @author Fiuty
 */
public interface SimpleFactoryAdvanceService {

    RequestDTO<People> createPeople(String name);

    RequestDTO<Animal> createAnimal(String name);
}
