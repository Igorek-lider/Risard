package com.htp.rentcar.dao.factory;

import com.htp.rentcar.dao.UserDao;

public abstract class DaoFactory {
    public static DaoFactory getDaoFactory() {
        return SQLDaoFactory.getInstance();
    }

    public abstract UserDao getUserDao();
//  public abstract RoomDao getRoomDao();
//  public abstract ClientDao getClientDao();
//  public abstract ReservationDao getReservationDao();
//  public abstract ApplicationDao getApplicationDao();
//  public abstract PaymentDao getPaymentDao();
}
