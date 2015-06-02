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
@Table(name = "user_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInfo.findAll", query = "SELECT u FROM UserInfo u"),
    @NamedQuery(name = "UserInfo.findByIdInfo", query = "SELECT u FROM UserInfo u WHERE u.idInfo = :idInfo"),
    @NamedQuery(name = "UserInfo.findByLastname", query = "SELECT u FROM UserInfo u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "UserInfo.findByFirstname", query = "SELECT u FROM UserInfo u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "UserInfo.findByPatronymic", query = "SELECT u FROM UserInfo u WHERE u.patronymic = :patronymic"),
    @NamedQuery(name = "UserInfo.findByDateOfBirdth", query = "SELECT u FROM UserInfo u WHERE u.dateOfBirdth = :dateOfBirdth"),
    @NamedQuery(name = "UserInfo.findByPhone", query = "SELECT u FROM UserInfo u WHERE u.phone = :phone"),
    @NamedQuery(name = "UserInfo.findByNumOfCards", query = "SELECT u FROM UserInfo u WHERE u.numOfCards = :numOfCards")})
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_info")
    private Integer idInfo;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "patronymic")
    private String patronymic;
    @Basic(optional = false)
    @Column(name = "date_of_birdth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirdth;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "num_of_cards")
    private String numOfCards;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInfoId")
    private Collection<User> userCollection;

    public UserInfo() {
    }

    public UserInfo(Integer idInfo) {
        this.idInfo = idInfo;
    }

    public UserInfo(Integer idInfo, String lastname, String firstname, String patronymic, Date dateOfBirdth) {
        this.idInfo = idInfo;
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.dateOfBirdth = dateOfBirdth;
    }

    public Integer getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(Integer idInfo) {
        this.idInfo = idInfo;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirdth() {
        return dateOfBirdth;
    }

    public void setDateOfBirdth(Date dateOfBirdth) {
        this.dateOfBirdth = dateOfBirdth;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getNumOfCards() {
        return numOfCards;
    }

    public void setNumOfCards(String numOfCards) {
        this.numOfCards = numOfCards;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfo != null ? idInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.idInfo == null && other.idInfo != null) || (this.idInfo != null && !this.idInfo.equals(other.idInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.UserInfo[ idInfo=" + idInfo + " ]";
    }
    
}
