package projects.chesspairer.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournament_player")
/**
 * This is the model class, that handles all the tournament players.
 */
public class TournamentPlayer implements Serializable
{
	private static final long serialVersionUID = 4385712748721827421L;

	@Id
    @Column(name = "tournamentplayer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tournamentPlayerId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chessplayer_id", foreignKey = @ForeignKey(name = "FK_TOURNAMENTPLAYER_CHESSPLAYER"))	 	
    private Chessplayer chessplayer;

    @Column(name ="player_number")    
    private int playerNumber;

	public TournamentPlayer(long tournamentPlayerId, Chessplayer chessplayer, int playerNumber)
	{
		this.tournamentPlayerId = tournamentPlayerId;
		this.chessplayer = chessplayer;
		this.playerNumber = playerNumber;
	}

	public long getTournamentPlayerId()
	{
		return tournamentPlayerId;
	}

	public void setTournamentPlayerId(long tournamentPlayerId)
	{
		this.tournamentPlayerId = tournamentPlayerId;
	}

	public Chessplayer getChessplayer()
	{
		return chessplayer;
	}

	public void setChessplayer(Chessplayer chessplayer)
	{
		this.chessplayer = chessplayer;
	}

	public int getPlayerNumber()
	{
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber)
	{
		this.playerNumber = playerNumber;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(chessplayer, playerNumber, tournamentPlayerId);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		TournamentPlayer other = (TournamentPlayer) obj;
		return Objects.equals(chessplayer, other.chessplayer) && playerNumber == other.playerNumber
				&& tournamentPlayerId == other.tournamentPlayerId;
	}
}
