package sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InsuranceAgent extends EmployeeOfTheGroupInsuranceDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long agentId;
    public long getAgentId() { return agentId; }

}
