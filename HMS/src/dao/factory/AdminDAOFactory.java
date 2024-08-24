package dao.factory;

import dao.intf.AdminDAO;
import dao.impl.AdminDAOImpl;

public class AdminDAOFactory {

    private static AdminDAOFactory instance;
    private AdminDAO adminDAO;

    private AdminDAOFactory() {
        adminDAO = new AdminDAOImpl();
    }

    public static synchronized AdminDAOFactory getInstance() {
        if (instance == null) {
            instance = new AdminDAOFactory();
        }
        return instance;
    }

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }
}
