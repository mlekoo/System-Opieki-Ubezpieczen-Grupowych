package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SystemAdministrator extends EmployeeOfTheGroupInsuranceDepartment {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    long adminId;
    public long getAdminId() { return adminId; }
}
