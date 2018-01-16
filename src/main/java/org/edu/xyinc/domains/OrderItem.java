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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 *         16/01/2018 09:01:08
 */
@Entity
@Table( name = "orderItem" )
@SuppressWarnings( "serial" )
public class OrderItem implements Serializable {

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @OneToOne
    private Product product;

    private Long quantity;

    private BigDecimal unityPrice;

    @ManyToOne
    private Order order;

    public Long getId() {

        return id;
    }

    public void setId( Long id ) {

        this.id = id;
    }

    public Product getProduct() {

        return product;
    }

    public void setProduct( Product product ) {

        this.product = product;
    }

    public Long getQuantity() {

        return quantity;
    }

    public void setQuantity( Long quantity ) {

        this.quantity = quantity;
    }

    public BigDecimal getUnityPrice() {

        return unityPrice;
    }

    public void setUnityPrice( BigDecimal unityPrice ) {

        this.unityPrice = unityPrice;
    }

    public Order getOrder() {

        return order;
    }

    public void setOrder( Order order ) {

        this.order = order;
    }

}
