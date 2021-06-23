package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class GroupInsuranceSupervisor extends EmployeeOfTheGroupInsuranceDepartment  {
    private long groupInsuranceSupervisorId;
    private List<Contract> contracts = new ArrayList<>();;

    public GroupInsuranceSupervisor() {}


    public void addContract(Contract contract){
        if(!contracts.contains(contract)){
            contracts.add(contract);
            contract.setGroupInsuranceSupervisor(this);
        }
    }

    public void removeContract(Contract contract){
        if(contracts.contains(contract)){
            contracts.remove(contract);
            contract.setGroupInsuranceSupervisor(null);
        }
    }
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getGroupInsuranceSupervisorId() {
        return groupInsuranceSupervisorId;
    }

    public void setGroupInsuranceSupervisorId(long groupInsuranceSupervisorId) {
        this.groupInsuranceSupervisorId = groupInsuranceSupervisorId;
    }

    @OneToMany(mappedBy = "groupInsuranceSupervisor", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
