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
@Table(name = "game_platform")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GamePlatform.findAll", query = "SELECT g FROM GamePlatform g"),
    @NamedQuery(name = "GamePlatform.findByIdPlatform", query = "SELECT g FROM GamePlatform g WHERE g.idPlatform = :idPlatform"),
    @NamedQuery(name = "GamePlatform.findByType", query = "SELECT g FROM GamePlatform g WHERE g.type = :type")})
public class GamePlatform implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_platform")
    private Integer idPlatform;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlatform")
    private Collection<Game> gameCollection;

    public GamePlatform() {
    }

    public GamePlatform(Integer idPlatform) {
        this.idPlatform = idPlatform;
    }

    public GamePlatform(Integer idPlatform, String type) {
        this.idPlatform = idPlatform;
        this.type = type;
    }

    public Integer getIdPlatform() {
        return idPlatform;
    }

    public void setIdPlatform(Integer idPlatform) {
        this.idPlatform = idPlatform;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (idPlatform != null ? idPlatform.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamePlatform)) {
            return false;
        }
        GamePlatform other = (GamePlatform) object;
        if ((this.idPlatform == null && other.idPlatform != null) || (this.idPlatform != null && !this.idPlatform.equals(other.idPlatform))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.GamePlatform[ idPlatform=" + idPlatform + " ]";
    }
    
}
