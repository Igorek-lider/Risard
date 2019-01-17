package com.htp.rentcar.dao;

import com.htp.rentcar.dao.connectionpool.ConnectionPool;
import com.htp.rentcar.dao.connectionpool.ConnectionPoolException;
import com.htp.rentcar.dao.factory.DaoFactory;
import com.htp.rentcar.exception.DaoException;

public class Main {
    public static void main(String[] args) throws DaoException, ConnectionPoolException {
        ConnectionPool.getInstance().init();
        DaoFactory factory = DaoFactory.getDaoFactory();
        UserDao userDao = factory.getUserDao();

        try {
           //Object f = userDao.findById(3L);
           Object f1 = userDao.checkUser("ivanov", "1234");
            System.out.println(f1);
           Object f3 = userDao.checkUser("ivanov", "12345");
            System.out.println(f3);
           Object f2 = userDao.getUserNode("ivanov", "1234");
            //System.out.println(f);

            System.out.println(f2);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        //userDao.findById(10L);


    }
}
