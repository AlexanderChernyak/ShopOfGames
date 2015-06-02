/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "game")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findByIdGame", query = "SELECT g FROM Game g WHERE g.idGame = :idGame"),
    @NamedQuery(name = "Game.findByName", query = "SELECT g FROM Game g WHERE g.name = :name"),
    @NamedQuery(name = "Game.findByYearOfManufacture", query = "SELECT g FROM Game g WHERE g.yearOfManufacture = :yearOfManufacture"),
    @NamedQuery(name = "Game.findByDescription", query = "SELECT g FROM Game g WHERE g.description = :description"),
    @NamedQuery(name = "Game.findByPrice", query = "SELECT g FROM Game g WHERE g.price = :price"),
    @NamedQuery(name = "Game.findBySystemrequirements", query = "SELECT g FROM Game g WHERE g.systemrequirements = :systemrequirements"),
    @NamedQuery(name = "Game.findByAmount", query = "SELECT g FROM Game g WHERE g.amount = :amount"),
    @NamedQuery(name = "Game.findByPublicherhouse", query = "SELECT g FROM Game g WHERE g.publicherhouse = :publicherhouse")})
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_game")
    private Integer idGame;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "year_of_manufacture")
    @Temporal(TemporalType.DATE)
    private Date yearOfManufacture;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @Column(name = "systemrequirements")
    private String systemrequirements;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @Column(name = "publicherhouse")
    private String publicherhouse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGame")
    private Collection<Basket> basketCollection;
    @JoinColumn(name = "id_num", referencedColumnName = "id_num")
    @ManyToOne(optional = false)
    private NumOfPlayers idNum;
    @JoinColumn(name = "id_platform", referencedColumnName = "id_platform")
    @ManyToOne(optional = false)
    private GamePlatform idPlatform;
    @JoinColumn(name = "id_genre", referencedColumnName = "id_genre")
    @ManyToOne(optional = false)
    private GameGenre idGenre;
    @Column(name = "url")
    private String url ;
    
    

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Game() {
    }

    public Game(Integer idGame) {
        this.idGame = idGame;
    }

    public Game(Integer idGame, String name, Date yearOfManufacture, String description, double price, String systemrequirements, int amount, String publicherhouse) {
        this.idGame = idGame;
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.description = description;
        this.price = price;
        this.systemrequirements = systemrequirements;
        this.amount = amount;
        this.publicherhouse = publicherhouse;
    }

    public Integer getIdGame() {
        return idGame;
    }

    public void setIdGame(Integer idGame) {
        this.idGame = idGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Date yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSystemrequirements() {
        return systemrequirements;
    }

    public void setSystemrequirements(String systemrequirements) {
        this.systemrequirements = systemrequirements;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPublicherhouse() {
        return publicherhouse;
    }

    public void setPublicherhouse(String publicherhouse) {
        this.publicherhouse = publicherhouse;
    }


    @XmlTransient
    public Collection<Basket> getBasketCollection() {
        return basketCollection;
    }

    public void setBasketCollection(Collection<Basket> basketCollection) {
        this.basketCollection = basketCollection;
    }

    public NumOfPlayers getIdNum() {
        return idNum;
    }

    public void setIdNum(NumOfPlayers idNum) {
        this.idNum = idNum;
    }

    public GamePlatform getIdPlatform() {
        return idPlatform;
    }

    public void setIdPlatform(GamePlatform idPlatform) {
        this.idPlatform = idPlatform;
    }
    
    public GameGenre getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(GameGenre idGenre) {
        this.idGenre = idGenre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGame != null ? idGame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.idGame == null && other.idGame != null) || (this.idGame != null && !this.idGame.equals(other.idGame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.Game[ idGame=" + idGame + " ]";
    }
    
}
