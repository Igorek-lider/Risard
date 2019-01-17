package com.htp.rentcar.service.ipml;

import com.htp.rentcar.dao.UserDao;
import com.htp.rentcar.dao.factory.DaoFactory;
import com.htp.rentcar.doman.to.User;
import com.htp.rentcar.exception.DaoException;
import com.htp.rentcar.service.ServiceException;
import com.htp.rentcar.service.UserService;
import com.htp.rentcar.service.validator.LoginValidator;
import com.htp.rentcar.service.validator.ValidationException;
import com.htp.rentcar.service.validator.ValidatorInterface;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();
    private static final ValidatorInterface<User> VALIDATE = LoginValidator.getInstance();

    private UserServiceImpl(){}

    public static UserService getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public User authorization(User user) throws ServiceException {
        try {
            UserDao userDao = factory.getUserDao();

            if(VALIDATE.isValid(user)) {

                String password = user.getPassword();
                String passwordMD5 = DigestUtils.md5Hex(password);
                user.setPassword(passwordMD5);

                boolean check = userDao.checkUser(user.getUsername(), user.getPassword());
                if (!check) {
                    return null;
                } else {
                    return userDao.getUserNode(user.getUsername(), user.getPassword());
                }
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }

    private static class SingletonHolder {
        private static final UserServiceImpl instance = new UserServiceImpl();
    }


    public User create(User obj) throws ServiceException {
        throw new UnsupportedOperationException();
    }


    public List<User> viewAll() throws ServiceException {
        throw new UnsupportedOperationException();
    }
}
