package dao.intf;

import models.Report;

public interface ReportDAO {
    Report generateDoctorReport();
    Report generateAppointmentReport();
    Report generatePatientReport();
}
