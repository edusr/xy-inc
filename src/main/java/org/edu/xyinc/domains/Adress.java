/**
 * 
 */
package org.edu.xyinc.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 *         16/01/2018 09:06:04
 */
@Entity
@Table( name = "adress" )
@SuppressWarnings( "serial" )
public class Adress implements Serializable {

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @NotNull( message = "Street can not be null" )
    private String street;

    @NotNull( message = "Neighborhood can not be null" )
    private String neighborhood;

    @NotNull( message = "Number can not be null" )
    private String number;

    @NotNull( message = "City can not be null" )
    private String city;

    @NotNull( message = "State can not be null" )
    private String state;

    @NotNull( message = "Country can not be null" )
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
