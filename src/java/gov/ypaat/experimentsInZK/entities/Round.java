/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.ypaat.experimentsInZK.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "round")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Round.findAll", query = "SELECT r FROM Round r"),
    @NamedQuery(name = "Round.findById", query = "SELECT r FROM Round r WHERE r.id = :id"),
    @NamedQuery(name = "Round.findByGameId", query = "SELECT r FROM Round r WHERE r.gameId = :gameId"),
    @NamedQuery(name = "Round.findByRound", query = "SELECT r FROM Round r WHERE r.round = :round"),
    @NamedQuery(name = "Round.findByPlayerId", query = "SELECT r FROM Round r WHERE r.playerId = :playerId"),
    @NamedQuery(name = "Round.findByRoundScore", query = "SELECT r FROM Round r WHERE r.roundScore = :roundScore"),
    @NamedQuery(name = "Round.findByIsFinalRound", query = "SELECT r FROM Round r WHERE r.isFinalRound = :isFinalRound"),
    @NamedQuery(name = "Round.findByUpdTimestamp", query = "SELECT r FROM Round r WHERE r.updTimestamp = :updTimestamp")})
public class Round implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_id")
    private int gameId;
    @Column(name = "round")
    private Short round;
    @Column(name = "player_id")
    private Integer playerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "round_score")
    private short roundScore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_final_round")
    private boolean isFinalRound;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upd_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updTimestamp;
    @JoinColumn(name = "finish_player_id", referencedColumnName = "player_id")
    @ManyToOne
    private PlayersPerGame finishPlayerId;

    public Round() {
    }

    public Round(Integer id) {
        this.id = id;
    }

    public Round(Integer id, int gameId, short roundScore, boolean isFinalRound, Date updTimestamp) {
        this.id = id;
        this.gameId = gameId;
        this.roundScore = roundScore;
        this.isFinalRound = isFinalRound;
        this.updTimestamp = updTimestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Short getRound() {
        return round;
    }

    public void setRound(Short round) {
        this.round = round;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public short getRoundScore() {
        return roundScore;
    }

    public void setRoundScore(short roundScore) {
        this.roundScore = roundScore;
    }

    public boolean getIsFinalRound() {
        return isFinalRound;
    }

    public void setIsFinalRound(boolean isFinalRound) {
        this.isFinalRound = isFinalRound;
    }

    public Date getUpdTimestamp() {
        return updTimestamp;
    }

    public void setUpdTimestamp(Date updTimestamp) {
        this.updTimestamp = updTimestamp;
    }

    public PlayersPerGame getFinishPlayerId() {
        return finishPlayerId;
    }

    public void setFinishPlayerId(PlayersPerGame finishPlayerId) {
        this.finishPlayerId = finishPlayerId;
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
        if (!(object instanceof Round)) {
            return false;
        }
        Round other = (Round) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.ypaat.experimentsInZK.entities.Round[ id=" + id + " ]";
    }
    
}
