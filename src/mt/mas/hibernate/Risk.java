package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Risk {
    private long riskId;
    private String name;
    private String description;
    private double value;
    private InsuranceVariant insuranceVariant;

    public Risk(){}
    public Risk(String name, String description, double value){
        this.name = name;
        this.description = description;
        this.value = value;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getRiskId() {
        return riskId;
    }

    public void setRiskId(long riskId) {
        this.riskId = riskId;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public InsuranceVariant getInsuranceVariant() {
        return insuranceVariant;
    }

    public void setInsuranceVariant(InsuranceVariant insuranceVariant) {
        this.insuranceVariant = insuranceVariant;
        insuranceVariant.addRisk(this);
    }

    @Override
    public String toString() {
        return "Risk{" +
                "riskId=" + riskId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }

    //TODO Implement connections
}
