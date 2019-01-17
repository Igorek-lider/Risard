package com.htp.rentcar.dao.impls;

import com.htp.rentcar.dao.UserDao;
import com.htp.rentcar.dao.connectionpool.ConnectionPool;
import com.htp.rentcar.dao.connectionpool.ConnectionPoolException;
import com.htp.rentcar.doman.to.User;
import com.htp.rentcar.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SQLUserDao implements UserDao {

    private static final String LOGIN = "username";
    private static final String PASSWORD = "password";
    private static final String ROLE = "idrole";
    private static final String PASSPORT = "passport";
    private static final String DRIVERSLICENCE = "driversLicense";
    private static final String EXPERIENCE = "experience";
    private static final String CLIENT_ID = "iduser";

    private static final String SELECT_BY_ID = "SELECT * FROM users WHERE iduser = ?";
    private static final String SELECT_BY_AUTHDATA = "SELECT * FROM users WHERE username = ? and password = ?";


    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private SQLUserDao(){}

    //Demand Holder Idiom1
    public static UserDao getInstance() {
        return SingletonHolder.instance;
    }

    public User getUserNode(String login, String password) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_AUTHDATA)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
                return getUserFromResultSet(set);
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    private User getUserFromResultSet(ResultSet set) throws DaoException{
        try {
            User user = new User();
            user.setIdUser(set.getLong(CLIENT_ID));
            user.setUsername(set.getString(LOGIN));
            user.setPassword(set.getString(PASSWORD));
            user.setIdRole(set.getInt(ROLE));
            user.setPassport(set.getString(PASSPORT));
            user.setDriversLicense(set.getString(DRIVERSLICENCE));
            user.setExperience(set.getInt(EXPERIENCE));
            return user;

        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }


    public boolean checkUser(String login, String password) throws DaoException {

        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_AUTHDATA)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    public List<User> findAll() throws DaoException {
        return null;
    }

    public User findById(Long id) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
                return getUserFromResultSet(set);
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    public boolean delete(Long id) throws DaoException {
        return false;
    }

    public int create(User entity) throws DaoException {
        return 0;
    }

    public Long update(User entity) throws DaoException {
        return null;
    }

    private static class SingletonHolder {
        private static final UserDao instance = new SQLUserDao();
    }
}
