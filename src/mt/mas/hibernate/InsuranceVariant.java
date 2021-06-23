package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class InsuranceVariant {
    private long insuranceVariantId;
    private String name;
    private LocalDate creationDate;
    private List<Risk> risks = new ArrayList<>();
    private Contract contract;

    public InsuranceVariant() {}

    public InsuranceVariant(String name, LocalDate creationDate, List<Risk> risks) throws Exception{
        this.name = name;
        this.creationDate = creationDate;
        setRisks(risks);
    }

    public void addRisk(Risk risk){
        if(!this.risks.contains(risk)){
            risks.add(risk);
            risk.setInsuranceVariant(this);
        }
    }
    public void removeRisk(Risk risk)
    {
        if(this.risks.contains(risk)){
            risks.remove(risk);
            risk.setInsuranceVariant(null);
        }
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getInsuranceVariantId() {
        return insuranceVariantId;
    }

    public void setInsuranceVariantId(long insuranceVariantId) {
        this.insuranceVariantId = insuranceVariantId;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


    @OneToMany(mappedBy = "insuranceVariant", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Risk> getRisks() {
        return risks;
    }

    public void setRisks(List<Risk> risks) throws Exception {
        if(risks.size() <= 1){
            throw new Exception("Insurance variant need to have at least one risk!");
        }
        this.risks = risks;
        for(Risk r : risks){
            r.setInsuranceVariant(this);
        }
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
    //TODO Implement insurance sum method
    //TODO Implement connections


    @Override
    public String toString() {
        return "InsuranceVariant{" +
                "insuranceVariantId=" + insuranceVariantId +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", risks=" + risks +
                ", contract=" + contract +
                '}';
    }
}
