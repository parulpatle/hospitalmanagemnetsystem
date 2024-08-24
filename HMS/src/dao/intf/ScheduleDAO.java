package dao.intf;

import java.util.List;

public interface ScheduleDAO {
    void addSchedule(int doctorId, String schedule);
    void updateSchedule(int doctorId, String newSchedule);
    void removeSchedule(int doctorId);
    List<String> getSchedules(int doctorId);
}
