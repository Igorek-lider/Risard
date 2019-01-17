package com.htp.rentcar.service;

import java.util.List;


public interface GenericServiceInterface<T, V> {
    /**
            * Method adding object in database and creates the appropriate entry there
     *
             * @param entity object necessary to adding in database
     * @return {@link T} object, that method can create
     * @throws ServiceException
     */
    T create(V entity) throws ServiceException;

    /**
            * Method provides viewing all information and package this information in view object
     *
             * @return {@link T} object necessary for view all objects
     * @throws ServiceException
     */
    List<T> loadAll() throws ServiceException;
}
