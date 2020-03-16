package com.fiuty.pattern.template;

import com.fiuty.domain.Car;
import com.fiuty.parcel.constants.ColorEnuum;

/**
 * @author Fiuty
 */
public class MakeRedCar extends CarTemplate{
    @Override
    void makeColor(Car car) {
        car.setColor(ColorEnuum.RED.getColor());
    }
}
