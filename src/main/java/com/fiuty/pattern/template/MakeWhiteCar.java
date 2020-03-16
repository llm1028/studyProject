package com.fiuty.pattern.template;

import com.fiuty.domain.Car;
import com.fiuty.parcel.constants.ColorEnuum;

/**
 * @author Fiuty
 */
public class MakeWhiteCar extends CarTemplate{
    @Override
    void makeColor(Car car) {
        car.setColor(ColorEnuum.WHITE.getColor());
    }
}
