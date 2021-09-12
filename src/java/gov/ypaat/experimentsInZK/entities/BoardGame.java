/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.ypaat.experimentsInZK.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "board_game")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoardGame.findAll", query = "SELECT b FROM BoardGame b"),
    @NamedQuery(name = "BoardGame.findById", query = "SELECT b FROM BoardGame b WHERE b.id = :id"),
    @NamedQuery(name = "BoardGame.findByName", query = "SELECT b FROM BoardGame b WHERE b.name = :name"),
    @NamedQuery(name = "BoardGame.findByDescription", query = "SELECT b FROM BoardGame b WHERE b.description = :description"),
    @NamedQuery(name = "BoardGame.findByMinPlayers", query = "SELECT b FROM BoardGame b WHERE b.minPlayers = :minPlayers"),
    @NamedQuery(name = "BoardGame.findByMaxPlayers", query = "SELECT b FROM BoardGame b WHERE b.maxPlayers = :maxPlayers"),
    @NamedQuery(name = "BoardGame.findByPlayingInRounds", query = "SELECT b FROM BoardGame b WHERE b.playingInRounds = :playingInRounds"),
    @NamedQuery(name = "BoardGame.findByUpdTimestamp", query = "SELECT b FROM BoardGame b WHERE b.updTimestamp = :updTimestamp")})
public class BoardGame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_players")
    private boolean minPlayers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_players")
    private short maxPlayers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "playing_in_rounds")
    private boolean playingInRounds;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upd_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updTimestamp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boardGameId")
    private Collection<Game> gameCollection;

    public BoardGame() {
    }

    public BoardGame(Integer id) {
        this.id = id;
    }

    public BoardGame(Integer id, String name, boolean minPlayers, short maxPlayers, boolean playingInRounds, Date updTimestamp) {
        this.id = id;
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playingInRounds = playingInRounds;
        this.updTimestamp = updTimestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(boolean minPlayers) {
        this.minPlayers = minPlayers;
    }

    public short getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(short maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public boolean getPlayingInRounds() {
        return playingInRounds;
    }

    public void setPlayingInRounds(boolean playingInRounds) {
        this.playingInRounds = playingInRounds;
    }

    public Date getUpdTimestamp() {
        return updTimestamp;
    }

    public void setUpdTimestamp(Date updTimestamp) {
        this.updTimestamp = updTimestamp;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BoardGame)) {
            return false;
        }
        BoardGame other = (BoardGame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.ypaat.experimentsInZK.entities.BoardGame[ id=" + id + " ]";
    }
    
}
