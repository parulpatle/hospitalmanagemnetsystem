package dao.intf;

import models.MedicalTest;

import java.util.List;

public interface MedicalTestDAO {
    void addMedicalTest(MedicalTest medicalTest);
    void updateMedicalTest(MedicalTest medicalTest);
    void deleteMedicalTest(int id);
    MedicalTest getMedicalTestById(int id);
    List<MedicalTest> getAllMedicalTests();
}
