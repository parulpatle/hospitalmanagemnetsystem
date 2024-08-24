package service;

import dao.factory.AdminDAOFactory;
import dao.intf.AdminDAO;
import models.Admin;

public class AdminService {

    private AdminDAO adminDAO;

    public AdminService() {
        this.adminDAO = AdminDAOFactory.getInstance().getAdminDAO();
    }

    public Admin getAdmin() {
        return adminDAO.getAdmin();
    }

    // Additional methods related to Admin if needed
}
