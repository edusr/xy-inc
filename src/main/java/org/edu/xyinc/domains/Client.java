/**
 * 
 */
package org.edu.xyinc.domains;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 *         16/01/2018 08:43:28
 */
@Entity
@Table( name = "client" )
@SuppressWarnings( "serial" )
public class Client implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotNull( message = "Name can not be null" )
    @Size( min = 2, max = 200, message = "Size must be betwen 2 and 200" )
    private String name;

    @NotNull( message = "Document can not be null" )
    @Size( min = 2, max = 14, message = "Size must be betwen 2 and 14" )
    private String document;

    @Email( message = "Email must be email" )
    private String email;

    @Size( min = 8, max = 17, message = "Size must be betwen 2 and 17" )
    private String phone;

    @OneToOne(cascade=CascadeType.ALL)
    @NotNull( message = "Adress can not be null" )
    private Adress adress;

    public Long getId() {

        return id;
    }

    public void setId( Long id ) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName( String name ) {

        this.name = name;
    }

    public String getDocument() {

        return document;
    }

    public void setDocument( String document ) {

        this.document = document;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail( String email ) {

        this.email = email;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone( String phone ) {

        this.phone = phone;
    }

    public Adress getAdress() {

        return adress;
    }

    public void setAdress( Adress adress ) {

        this.adress = adress;
    }

}
