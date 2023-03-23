package org.plural.hibernatefundamentals.airport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "AIRPORTS")
public class Airport {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "airport")
    private List<Passenger> passengers = new ArrayList<>();

    public Airport() {
    }

    public Airport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers) ;
    }

    public void addPassengers(Passenger passengers) {
        this.passengers.add(passengers);
    }
}
