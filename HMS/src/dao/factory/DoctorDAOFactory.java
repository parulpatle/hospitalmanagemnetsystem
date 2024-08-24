package dao.factory;

import dao.intf.DoctorDAO;
import dao.impl.DoctorDAOImpl;

public class DoctorDAOFactory {

    public DoctorDAO createDoctorDAO() {
        return new DoctorDAOImpl();
    }
}
