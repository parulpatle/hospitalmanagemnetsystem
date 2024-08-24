package dao.factory;

import dao.intf.ScheduleDAO;
import dao.impl.ScheduleDAOImpl;

public class ScheduleDAOFactory {

    public ScheduleDAO createScheduleDAO() {
        return new ScheduleDAOImpl();
    }
}
