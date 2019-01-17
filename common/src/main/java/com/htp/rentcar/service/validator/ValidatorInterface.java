package com.htp.rentcar.service.validator;

public interface ValidatorInterface<T> {
    /**
            * Validates the values in the fields of the object entity.
            * @param entity object type T which is need to validate.
     * @return true if parameters are valid, else return false.
            */
    boolean isValid(T entity);
}
