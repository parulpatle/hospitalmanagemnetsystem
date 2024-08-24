package dao.factory;

import dao.intf.PatientDAO;
import dao.impl.PatientDAOImpl;

public class PatientDAOFactory {

    public PatientDAO createPatientDAO() {
        return new PatientDAOImpl();
    }
}
