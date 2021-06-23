package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RepresentativeOfTheCompanyInsuredCompany {
    private long RepresentativeOfTheCompanyInsuredCompanyId;
    private LocalDate startDate;
    private LocalDate endDate;
    private RepresentativeOfTheCompany representativeOfTheCompany;
    private InsuredCompany insuredCompany;

    public RepresentativeOfTheCompanyInsuredCompany() {}

    public RepresentativeOfTheCompanyInsuredCompany(LocalDate startDate, LocalDate endDate, RepresentativeOfTheCompany representativeOfTheCompany, InsuredCompany insuredCompany){
        this.startDate = startDate;
        this.endDate = endDate;
        this.representativeOfTheCompany = representativeOfTheCompany;
        this.representativeOfTheCompany.addRepresentativeOfTheCompanyInsuredCompany(this);
        this.insuredCompany = insuredCompany;
        this.insuredCompany.addRepresentativeOfTheCompanyInsuredCompany(this);
    }

    public void remove(){
        if(insuredCompany != null || representativeOfTheCompany != null){
            if(insuredCompany != null){
                insuredCompany.removeRepresentativeOfTheCompanyInsuredCompany(this);
                insuredCompany = null;
            }
            if(representativeOfTheCompany != null){
                representativeOfTheCompany.removeRepresentativeOfTheCompanyInsuredCompany(this);
                representativeOfTheCompany = null;
            }
        }
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getRepresentativeOfTheCompanyInsuredCompanyId() {
        return RepresentativeOfTheCompanyInsuredCompanyId;
    }

    public void setRepresentativeOfTheCompanyInsuredCompanyId(long representativeOfTheCompanyInsuredCompanyId) {
        RepresentativeOfTheCompanyInsuredCompanyId = representativeOfTheCompanyInsuredCompanyId;
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

    @ManyToOne(cascade = CascadeType.ALL)
    public RepresentativeOfTheCompany getRepresentativeOfTheCompany() {
        return representativeOfTheCompany;
    }

    public void setRepresentativeOfTheCompany(RepresentativeOfTheCompany representativeOfTheCompany) {
        this.representativeOfTheCompany = representativeOfTheCompany;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public InsuredCompany getInsuredCompany() {
        return insuredCompany;
    }

    public void setInsuredCompany(InsuredCompany insuredCompany) {
        this.insuredCompany = insuredCompany;
    }
}
