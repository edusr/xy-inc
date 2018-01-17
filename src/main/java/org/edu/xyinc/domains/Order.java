/**
 * 
 */
package org.edu.xyinc.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 *         16/01/2018 08:43:10
 */
@Entity
@Table( name = "torder" )
@SuppressWarnings( "serial" )
public class Order implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @NotNull( message = "Client can not be null" )
    private Client client;

    @OneToMany( cascade = CascadeType.ALL )
    @NotNull( message = "Itens can not be null" )
    private List< OrderItem > itens;

    public Long getId() {

        return id;
    }

    public void setId( Long id ) {

        this.id = id;
    }

    public Client getClient() {

        return client;
    }

    public void setClient( Client client ) {

        this.client = client;
    }

    public List< OrderItem > getItens() {

        return itens;
    }

    public void setItens( List< OrderItem > itens ) {

        this.itens = itens;
    }

    @Transient
    public void addItem( OrderItem item ) {

        if ( this.getItens() == null ) {
            this.itens = new ArrayList<>();
        }
        this.itens.add( item );
    }

}
