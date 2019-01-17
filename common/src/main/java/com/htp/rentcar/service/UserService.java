package com.htp.rentcar.service;

import com.htp.rentcar.doman.to.User;

public interface UserService {

    User authorization(User user) throws ServiceException;


}
