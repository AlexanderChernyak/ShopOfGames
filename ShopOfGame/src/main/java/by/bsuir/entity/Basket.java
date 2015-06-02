/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "basket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Basket.findAll", query = "SELECT b FROM Basket b"),
    @NamedQuery(name = "Basket.findByIdBasket", query = "SELECT b FROM Basket b WHERE b.idBasket = :idBasket"),
    @NamedQuery(name = "Basket.findByPriceOrder", query = "SELECT b FROM Basket b WHERE b.priceOrder = :priceOrder")})
public class Basket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_basket")
    private Integer idBasket;
    @Basic(optional = false)
    @Column(name = "priceOrder")
    private double priceOrder;
    @JoinColumn(name = "id_game", referencedColumnName = "id_game")
    @ManyToOne(optional = false)
    private Game idGame;
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User userIdUser;

    public Basket() {
    }
    
    

    public Basket(double priceOrder, Game idGame, User userIdUser) {
		super();
		this.priceOrder = priceOrder;
		this.idGame = idGame;
		this.userIdUser = userIdUser;
	}



	public Basket(Integer idBasket) {
        this.idBasket = idBasket;
    }

    public Basket(Integer idBasket, double priceOrder) {
        this.idBasket = idBasket;
        this.priceOrder = priceOrder;
    }

    public Integer getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(Integer idBasket) {
        this.idBasket = idBasket;
    }

    public double getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(double priceOrder) {
        this.priceOrder = priceOrder;
    }

    public Game getIdGame() {
        return idGame;
    }

    public void setIdGame(Game idGame) {
        this.idGame = idGame;
    }

    public User getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(User userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBasket != null ? idBasket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Basket)) {
            return false;
        }
        Basket other = (Basket) object;
        if ((this.idBasket == null && other.idBasket != null) || (this.idBasket != null && !this.idBasket.equals(other.idBasket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.Basket[ idBasket=" + idBasket + " ]";
    }
    
}
