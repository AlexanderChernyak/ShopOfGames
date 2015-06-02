/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "num_of_players")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumOfPlayers.findAll", query = "SELECT n FROM NumOfPlayers n"),
    @NamedQuery(name = "NumOfPlayers.findByIdNum", query = "SELECT n FROM NumOfPlayers n WHERE n.idNum = :idNum"),
    @NamedQuery(name = "NumOfPlayers.findByType", query = "SELECT n FROM NumOfPlayers n WHERE n.type = :type"),
    @NamedQuery(name = "NumOfPlayers.findByAmount", query = "SELECT n FROM NumOfPlayers n WHERE n.amount = :amount")})
public class NumOfPlayers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_num")
    private Integer idNum;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNum")
    private Collection<Game> gameCollection;

    public NumOfPlayers() {
    }

    public NumOfPlayers(Integer idNum) {
        this.idNum = idNum;
    }

    public NumOfPlayers(Integer idNum, String type, int amount) {
        this.idNum = idNum;
        this.type = type;
        this.amount = amount;
    }

    public Integer getIdNum() {
        return idNum;
    }

    public void setIdNum(Integer idNum) {
        this.idNum = idNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @XmlTransient
    public Collection<Game> getGameCollection() {
        return gameCollection;
    }

    public void setGameCollection(Collection<Game> gameCollection) {
        this.gameCollection = gameCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNum != null ? idNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumOfPlayers)) {
            return false;
        }
        NumOfPlayers other = (NumOfPlayers) object;
        if ((this.idNum == null && other.idNum != null) || (this.idNum != null && !this.idNum.equals(other.idNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.NumOfPlayers[ idNum=" + idNum + " ]";
    }
    
}
