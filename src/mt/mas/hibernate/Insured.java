package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Insured extends Person {
    private long insuredId;
    private LocalDate startDate;
    private LocalDate endDate;
    private InsuredStatus insuredStatus;
    private Contract contract;
    private InsuredCompany insuredCompany;
    private Address address;

    public Insured() {}

    public Insured(LocalDate startDate, LocalDate endDate, Contract contract, Address address, InsuredCompany insuredCompany) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.insuredStatus = InsuredStatus.AWAITING_DECISION;
        this.address = address;
        setContract(contract);
        setInsuredCompany(insuredCompany);
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
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

    @Enumerated(EnumType.STRING)
    public InsuredStatus getInsuredStatus() {
        return insuredStatus;
    }

    public void setInsuredStatus(InsuredStatus insuredStatus) {
        this.insuredStatus = insuredStatus;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
        this.contract.addInsured(this);
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public InsuredCompany getInsuredCompany() {
        return insuredCompany;
    }

    public void setInsuredCompany(InsuredCompany employer) {
        this.insuredCompany = employer;
        this.insuredCompany.addEmployee(this);
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    //TODO Correct enum handling
}
