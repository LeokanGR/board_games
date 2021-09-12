/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.ypaat.experimentsInZK.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "players_per_game")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayersPerGame.findAll", query = "SELECT p FROM PlayersPerGame p"),
    @NamedQuery(name = "PlayersPerGame.findById", query = "SELECT p FROM PlayersPerGame p WHERE p.id = :id"),
    @NamedQuery(name = "PlayersPerGame.findByPlayerId", query = "SELECT p FROM PlayersPerGame p WHERE p.playerId = :playerId"),
    @NamedQuery(name = "PlayersPerGame.findByGameId", query = "SELECT p FROM PlayersPerGame p WHERE p.gameId = :gameId")})
public class PlayersPerGame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "player_id")
    private int playerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_id")
    private int gameId;
    @OneToMany(mappedBy = "finishPlayerId")
    private Collection<Round> roundCollection;

    public PlayersPerGame() {
    }

    public PlayersPerGame(Integer id) {
        this.id = id;
    }

    public PlayersPerGame(Integer id, int playerId, int gameId) {
        this.id = id;
        this.playerId = playerId;
        this.gameId = gameId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @XmlTransient
    public Collection<Round> getRoundCollection() {
        return roundCollection;
    }

    public void setRoundCollection(Collection<Round> roundCollection) {
        this.roundCollection = roundCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayersPerGame)) {
            return false;
        }
        PlayersPerGame other = (PlayersPerGame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.ypaat.experimentsInZK.entities.PlayersPerGame[ id=" + id + " ]";
    }
    
}
