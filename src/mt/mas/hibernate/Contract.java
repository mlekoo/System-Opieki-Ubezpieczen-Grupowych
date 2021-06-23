package mt.mas.hibernate;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contract {
    private long contractId;
    private LocalDate startDate;
    private LocalDate endDate;
    private InsuranceAgent insuranceAgent;
    private List<Insured> insureds = new ArrayList<>();
    private InsuranceVariant insuranceVariant;
    private InsuredCompany insuredCompany;
    private GroupInsuranceSupervisor groupInsuranceSupervisor;

    public Contract(){}

    public Contract(LocalDate startDate, LocalDate endDate, InsuranceVariant insuranceVariant, InsuredCompany insuredCompany, GroupInsuranceSupervisor groupInsuranceSupervisor){
        this.startDate = startDate;
        this.endDate = endDate;
        this.insuranceVariant = insuranceVariant;
        this.insuredCompany = insuredCompany;
        setGroupInsuranceSupervisor(groupInsuranceSupervisor);
    }

    public Contract(LocalDate startDate, LocalDate endDate, InsuranceAgent insuranceAgent, InsuranceVariant insuranceVariant, InsuredCompany insuredCompany, GroupInsuranceSupervisor groupInsuranceSupervisor){
        this.startDate = startDate;
        this.endDate = endDate;
        this.insuranceAgent = insuranceAgent;
        this.insuranceVariant = insuranceVariant;
        this.insuredCompany = insuredCompany;
        setGroupInsuranceSupervisor(groupInsuranceSupervisor);
    }

    public void addInsured(Insured insured){
        if(!this.insureds.contains(insured)){
            this.insureds.add(insured);
            insured.setContract(this);
        }
    }
    public void removeInsured(Insured insured){
        if(this.insureds.contains(insured)){
            this.insureds.remove(insured);
            insured.setContract(null);
        }
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    @Basic
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Basic
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    //TODO Add implementation for get number of contracts
    public static long getNumberOfContracts(){
        return 0;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    public InsuranceAgent getInsuranceAgent() {
        return insuranceAgent;
    }

    public void setInsuranceAgent(InsuranceAgent insuranceAgent) {
        this.insuranceAgent = insuranceAgent;
    }

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    public List<Insured> getInsureds() {
        return insureds;
    }

    public void setInsureds(List<Insured> insureds) {
        this.insureds = insureds;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public InsuranceVariant getInsuranceVariant() {
        return insuranceVariant;
    }

    public void setInsuranceVariant(InsuranceVariant insuranceVariant) {
        this.insuranceVariant = insuranceVariant;
        insuranceVariant.setContract(this);
    }

    @OneToOne(cascade = CascadeType.ALL)
    public InsuredCompany getInsuredCompany() {
        return insuredCompany;
    }

    public void setInsuredCompany(InsuredCompany insuredCompany) {
        this.insuredCompany = insuredCompany;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public GroupInsuranceSupervisor getGroupInsuranceSupervisor() {
        return groupInsuranceSupervisor;
    }

    public void setGroupInsuranceSupervisor(GroupInsuranceSupervisor groupInsuranceSupervisor) {
        this.groupInsuranceSupervisor = groupInsuranceSupervisor;
        groupInsuranceSupervisor.addContract(this);
    }
    //TODO Connection OneToMany with InsuranceAgent
}
