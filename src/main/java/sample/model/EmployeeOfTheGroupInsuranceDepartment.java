package sample.model;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EmployeeOfTheGroupInsuranceDepartment extends PersonAbstract {
    @Basic
    String login;
    @Basic
    String password;
}
