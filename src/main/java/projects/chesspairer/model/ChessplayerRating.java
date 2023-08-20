package projects.chesspairer.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chessplayer_rating")
public class ChessplayerRating implements Serializable
{
	private static final long serialVersionUID = 1679807544352689286L;
	
	@Id
	@Column(name = "chessplayer_id", updatable = false)
	private int chessplayerId;
	
	@Column(name = "standard_rating", columnDefinition = "smallint", nullable = false)
	private int standardRating;
	
	@Column(name = "rapid_rating", columnDefinition = "smallint", nullable = false)
	private int rapidRating;
	
	@Column(name = "blitz_rating", columnDefinition = "smallint", nullable = false)
	private int blitzRating;

	public ChessplayerRating(int chessplayerId, int standardRating, int rapidRating, int blitzRating)
	{
		this.chessplayerId = chessplayerId;
		this.standardRating = standardRating;
		this.rapidRating = rapidRating;
		this.blitzRating = blitzRating;
	}

	public int getChessplayerId()
	{
		return chessplayerId;
	}

	public void setChessplayerId(int chessplayerId)
	{
		this.chessplayerId = chessplayerId;
	}

	public int getStandardRating()
	{
		return standardRating;
	}

	public void setStandardRating(int standardRating)
	{
		this.standardRating = standardRating;
	}

	public int getRapidRating()
	{
		return rapidRating;
	}

	public void setRapidRating(int rapidRating)
	{
		this.rapidRating = rapidRating;
	}

	public int getBlitzRating()
	{
		return blitzRating;
	}

	public void setBlitzRating(int blitzRating)
	{
		this.blitzRating = blitzRating;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(blitzRating, chessplayerId, rapidRating, standardRating);
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
		ChessplayerRating other = (ChessplayerRating) obj;
		return blitzRating == other.blitzRating && chessplayerId == other.chessplayerId
				&& rapidRating == other.rapidRating && standardRating == other.standardRating;
	}
	
}
