package sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GroupInsuranceSupervisor extends EmployeeOfTheGroupInsuranceDepartment  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long groupInsuranceSupervisorId;
    public long getGroupInsuranceSupervisorId() { return groupInsuranceSupervisorId; }
}
