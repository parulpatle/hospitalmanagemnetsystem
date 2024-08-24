package dao.intf;

import models.Schedule;

import java.util.List;

public interface ScheduleDAO {
    void addSchedule(Schedule schedule);
    void updateSchedule(Schedule schedule);
    void deleteSchedule(int id);
    Schedule getScheduleById(int id);
    List<Schedule> getSchedulesByDoctor(int doctorId);
}
