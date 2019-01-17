package com.htp.rentcar.dao.factory;

import com.htp.rentcar.dao.UserDao;
import com.htp.rentcar.dao.impls.SQLUserDao;

public class SQLDaoFactory extends DaoFactory {

    private static final SQLDaoFactory instance = new SQLDaoFactory();

    private SQLDaoFactory(){}

    public static SQLDaoFactory getInstance(){
        return instance;
    }

    @Override
    public UserDao getUserDao() {
        return SQLUserDao.getInstance();
    }
//
//    @Override
//    public RoomDao getRoomDao() {
//        return SQLRoomDao.getInstance();
//    }
//
//    @Override
//    public ClientDao getClientDao() {
//        return SQLClientDao.getInstance();
//    }
//
//    @Override
//    public ReservationDao getReservationDao() {
//        return SQLReservationDao.getInstance();
//    }
//
//    @Override
//    public ApplicationDao getApplicationDao() {
//        return SQLApplicationDao.getInstance();
//    }
//
//    @Override
//    public PaymentDao getPaymentDao() {
//        return SQLPaymentDao.getInstance();
//    }
}
