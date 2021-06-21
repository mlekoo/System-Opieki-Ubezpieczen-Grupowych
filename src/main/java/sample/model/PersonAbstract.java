package sample.model;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PersonAbstract {
    @Basic
    String imie;
    @Basic
    String nazwisko;
}
