/**
 * 
 */
package org.edu.xyinc.domains;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 *         16/01/2018 08:42:57
 */
@Entity
@Table( name = "product" )
@SuppressWarnings( "serial" )
public class Product implements Serializable {

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private String name;

    private String barcode;

    private BigDecimal price;

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

    public String getBarcode() {

        return barcode;
    }

    public void setBarcode( String barcode ) {

        this.barcode = barcode;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice( BigDecimal price ) {

        this.price = price;
    }

}
