package sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SystemAdministrator extends EmployeeOfTheGroupInsuranceDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long adminId;
    public long getAdminId() { return adminId; }
}
