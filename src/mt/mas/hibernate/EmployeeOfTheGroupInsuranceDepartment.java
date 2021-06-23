package mt.mas.hibernate;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EmployeeOfTheGroupInsuranceDepartment extends Person {
    @Basic
    String login;
    @Basic
    String password;
}
