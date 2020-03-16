package com.fiuty.pattern.template;

import com.fiuty.domain.Car;
import com.fiuty.parcel.constants.ColorEnuum;

/**
 * @author Fiuty
 */
public class MakeBlackCar extends CarTemplate {
    @Override
    void makeColor(Car car) {
        car.setColor(ColorEnuum.BLACK.getColor());
    }
}
