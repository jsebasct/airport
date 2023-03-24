package org.plural.hibernatefundamentals.airport_two;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGERS")
@SecondaryTable(name = "ADDRESSES",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGERS_ID", referencedColumnName = "PASSENGERS_ID"))
public class Passengers {
    @Id
    @Column(name = "PASSENGERS_ID")
    private int id;
    @Column(name = "PASSENGERS_NAME", table = "PASSENGERS")
    private String name;

    @Column(name = "PASSENGERS_ADDRESS", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
    private String address;

    public Passengers() {
    }

    public Passengers(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
