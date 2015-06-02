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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "game_genre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameGenre.findAll", query = "SELECT g FROM GameGenre g"),
    @NamedQuery(name = "GameGenre.findByIdGenre", query = "SELECT g FROM GameGenre g WHERE g.idGenre = :idGenre"),
    @NamedQuery(name = "GameGenre.findByType", query = "SELECT g FROM GameGenre g WHERE g.type = :type")})
public class GameGenre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_genre")
    private Integer idGenre;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    public GameGenre() {
    }

    public GameGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public GameGenre(Integer idGenre, String type) {
        this.idGenre = idGenre;
        this.type = type;
    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenre != null ? idGenre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameGenre)) {
            return false;
        }
        GameGenre other = (GameGenre) object;
        if ((this.idGenre == null && other.idGenre != null) || (this.idGenre != null && !this.idGenre.equals(other.idGenre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.GameGenre[ idGenre=" + idGenre + " ]";
    }
    
}
