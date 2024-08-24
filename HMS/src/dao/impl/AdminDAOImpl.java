package dao.impl;

import dao.intf.AdminDAO;
import models.Admin;

public class AdminDAOImpl implements AdminDAO {

    private static final Admin ADMIN_INSTANCE = new Admin(1, "admin", "adminpassword"); // Use a secure password

    @Override
    public Admin getAdmin() {
        return ADMIN_INSTANCE;
    }
}
