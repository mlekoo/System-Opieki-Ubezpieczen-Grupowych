package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Insurance_Agent")
public class InsuranceAgent extends EmployeeOfTheGroupInsuranceDepartment {

    private long agentId;
    private Address address;
    private List<Contract> concludedContracts = new ArrayList<>();

    public InsuranceAgent(){}

    public InsuranceAgent(Address address){
        this.address = address;
    }
    public InsuranceAgent(Address address, List<Contract> concludedContracts){
        this.address = address;
        this.concludedContracts.addAll(concludedContracts);
        for (Contract c : this.concludedContracts) {
            c.setInsuranceAgent(this);
        }
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "insuranceAgent", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Contract> getConcludedContracts() {
        return concludedContracts;
    }

    public void setConcludedContracts(List<Contract> concludedContracts) {
        this.concludedContracts = concludedContracts;
        for (Contract c : this.concludedContracts) {
            c.setInsuranceAgent(this);
        }
    }
}
