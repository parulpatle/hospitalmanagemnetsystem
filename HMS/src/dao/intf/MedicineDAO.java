package dao.intf;

import models.Medicine;

import java.util.List;

public interface MedicineDAO {
    void addMedicine(Medicine medicine);
    void updateMedicine(Medicine medicine);
    void deleteMedicine(int id);
    Medicine getMedicineById(int id);
    List<Medicine> getAllMedicines();
}
