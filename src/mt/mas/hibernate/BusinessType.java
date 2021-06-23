package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BusinessType {
    private long businessTypeId;
    private String sector;
    private LocalDate startDate;
    private LocalDate endDate;
    private double annualIncomePercent;
    private InsuredCompany insuredCompany;

    public BusinessType() {
    }

    public BusinessType(String sector, LocalDate startDate, LocalDate endDate, double annualIncomePercent, InsuredCompany insuredCompany) {
        this.sector = sector;
        this.startDate = startDate;
        this.endDate = endDate;
        this.annualIncomePercent = annualIncomePercent;
        setInsuredCompany(insuredCompany);
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(long businessTypeId) {
        this.businessTypeId = businessTypeId;
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

    @Basic
    public double getAnnualIncomePercent() {
        return annualIncomePercent;
    }

    public void setAnnualIncomePercent(double annualIncomePercent) {
        this.annualIncomePercent = annualIncomePercent;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public InsuredCompany getInsuredCompany() {
        return insuredCompany;
    }

    public void setInsuredCompany(InsuredCompany insuredCompany) {
        this.insuredCompany = insuredCompany;
        this.insuredCompany.addBusinessType(this);
    }

    @Basic
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    //TODO Connections
}
