/**
 * 
 */
package org.edu.xyinc.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 *         16/01/2018 09:06:04
 */
@Entity
@Table(name="adress")
@SuppressWarnings( "serial" )
public class Adress implements Serializable{

    @Id
    @Column( name = "id" )
    private Long id;

    private String street;

    private String neighborhood;

    private String number;

    private String city;

    private String state;

    private String country;

    public Long getId() {

        return id;
    }

    public void setId( Long id ) {

        this.id = id;
    }

    public String getStreet() {

        return street;
    }

    public void setStreet( String street ) {

        this.street = street;
    }

    public String getNeighborhood() {

        return neighborhood;
    }

    public void setNeighborhood( String neighborhood ) {

        this.neighborhood = neighborhood;
    }

    public String getNumber() {

        return number;
    }

    public void setNumber( String number ) {

        this.number = number;
    }

    public String getCity() {

        return city;
    }

    public void setCity( String city ) {

        this.city = city;
    }

    public String getState() {

        return state;
    }

    public void setState( String state ) {

        this.state = state;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry( String country ) {

        this.country = country;
    }

}
