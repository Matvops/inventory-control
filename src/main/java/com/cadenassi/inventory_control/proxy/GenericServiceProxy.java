package com.cadenassi.inventory_control.proxy;

import com.cadenassi.inventory_control.exceptions.InvalidArgumentException;
import com.cadenassi.inventory_control.exceptions.ObjectIsNullException;


public abstract class GenericServiceProxy {

    protected void verifyIsNumber(String number) {
        if (!number.matches("^\\\\d+$"))
            throw new InvalidArgumentException("Argument is not a number");
    }

    protected <T> void verifyIsNull(T object) {
        if (object == null)
            throw new ObjectIsNullException("Object is null!");

        if (object instanceof String) {
            var str = (String) object;

            if (str.isBlank())
                throw new InvalidArgumentException("String is blank!");
        }
    }

}
