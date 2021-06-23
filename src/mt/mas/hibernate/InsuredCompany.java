package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class InsuredCompany {
    private long insuredCompanyId;
    private String name;
    private String nip;
    private String krsNumber;
    private List<Insured> employees = new ArrayList<>();;
    private Address address;
    private List<BusinessType> businessTypes = new ArrayList<>();;
    private List<RepresentativeOfTheCompanyInsuredCompany> representativeOfTheCompanyInsuredCompanies = new ArrayList<>();

    public InsuredCompany() {}

    public InsuredCompany(String name, String nip, String krsNumber, Address address) {
        this.name = name;
        this.nip = nip;
        this.krsNumber = krsNumber;
        this.address = address;
    }
    public void addBusinessType(BusinessType businessType){
        if(!this.businessTypes.contains(businessType)){
            this.businessTypes.add(businessType);
        }
    }
    public void removeBusinessType(BusinessType businessType){
        if(this.businessTypes.contains(businessType)){
            this.businessTypes.remove(businessType);
        }
    }

    public void addEmployee(Insured insured){
        if(!this.employees.contains(insured)){
            this.employees.add(insured);
        }
    }
    public void removeEmployee(Insured insured){
        if(this.employees.contains(insured)){
            this.employees.add(insured);
        }
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getInsuredCompanyId() {
        return insuredCompanyId;
    }

    public void setInsuredCompanyId(long insuredCompanyId) {
        this.insuredCompanyId = insuredCompanyId;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Basic
    public String getKrsNumber() {
        return krsNumber;
    }

    public void setKrsNumber(String krsNumber) {
        this.krsNumber = krsNumber;
    }

    @OneToMany(mappedBy = "insuredCompany", cascade = CascadeType.ALL)
    public List<Insured> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Insured> employees) {
        this.employees = employees;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "insuredCompany", cascade = CascadeType.ALL)
    public List<BusinessType> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<BusinessType> businessType) {
        this.businessTypes = businessType;
    }

    @OneToMany(mappedBy = "insuredCompany", cascade = CascadeType.ALL)
    public List<RepresentativeOfTheCompanyInsuredCompany> getRepresentativeOfTheCompanyInsuredCompanies() {
        return representativeOfTheCompanyInsuredCompanies;
    }

    public void setRepresentativeOfTheCompanyInsuredCompanies(List<RepresentativeOfTheCompanyInsuredCompany> representativeOfTheCompanyInsuredCompany) {
        this.representativeOfTheCompanyInsuredCompanies = representativeOfTheCompanyInsuredCompany;
    }

    //TODO implement connections
}
