package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RepresentativeOfTheCompany extends Person {
    private long representativeOfTheCompanyId;
    private String phoneNumber;
    private List<RepresentativeOfTheCompanyInsuredCompany> representativeOfTheCompanyInsuredCompanies = new ArrayList<>();;

    public RepresentativeOfTheCompany(){}
    public RepresentativeOfTheCompany(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getRepresentativeOfTheCompanyId() {
        return representativeOfTheCompanyId;
    }

    public void setRepresentativeOfTheCompanyId(long representativeOfTheCompanyId) {
        this.representativeOfTheCompanyId = representativeOfTheCompanyId;
    }

    public void addRepresentativeOfTheCompanyInsuredCompany(RepresentativeOfTheCompanyInsuredCompany representativeOfTheCompanyInsuredCompany){
        if(!this.representativeOfTheCompanyInsuredCompanies.contains(representativeOfTheCompanyInsuredCompany)){
            this.representativeOfTheCompanyInsuredCompanies.add(representativeOfTheCompanyInsuredCompany);
        }
    }
    public void removeRepresentativeOfTheCompanyInsuredCompany(RepresentativeOfTheCompanyInsuredCompany representativeOfTheCompanyInsuredCompany){
        if(this.representativeOfTheCompanyInsuredCompanies.contains(representativeOfTheCompanyInsuredCompany)){
            this.representativeOfTheCompanyInsuredCompanies.remove(representativeOfTheCompanyInsuredCompany);
            representativeOfTheCompanyInsuredCompany.remove();
        }
    }

    @Basic
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(mappedBy = "representativeOfTheCompany", cascade = CascadeType.ALL)
    public List<RepresentativeOfTheCompanyInsuredCompany> getRepresentativeOfTheCompanyInsuredCompanies() {
        return representativeOfTheCompanyInsuredCompanies;
    }

    public void setRepresentativeOfTheCompanyInsuredCompanies(List<RepresentativeOfTheCompanyInsuredCompany> representativeOfTheCompanyInsuredCompanies) {
        this.representativeOfTheCompanyInsuredCompanies = representativeOfTheCompanyInsuredCompanies;
    }
    //TODO Implement connections
}
