package mt.mas.hibernate;

import com.sun.istack.NotNull;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
    @Basic
    String imie;
    @NotNull
    String nazwisko;
}
