package dao.factory;

import dao.intf.UserDAO;
import dao.impl.UserDAOImpl;

public class UserDAOFactory {

    public UserDAO createUserDAO() {
        return new UserDAOImpl();
    }
}
