package projects.chesspairer.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fidemember_rating")
public class FidememberRating implements Serializable
{
	private static final long serialVersionUID = -8755769040678702667L;
	
	@Id
	@Column(name = "fidemember_id", updatable = false)
	private int fidememberId;
	
	@Column(name = "standard_rating", columnDefinition = "smallint", nullable = false)
	private int standardRating;
	
	@Column(name = "rapid_rating", columnDefinition = "smallint", nullable = false)
	private int rapidRating;
	
	@Column(name = "blitz_rating", columnDefinition = "smallint", nullable = false)
	private int blitzRating;
	
	public FidememberRating(int fidememberId, int standardRating, int rapidRating, int blitzRating)
	{
		this.fidememberId = fidememberId;
		this.standardRating = standardRating;
		this.rapidRating = rapidRating;
		this.blitzRating = blitzRating;
	}
	
	public int getFidememberId()
	{
		return fidememberId;
	}
	
	public void setFidememberId(int fidememberId)
	{
		this.fidememberId = fidememberId;
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
		return Objects.hash(blitzRating, fidememberId, rapidRating, standardRating);
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
		FidememberRating other = (FidememberRating) obj;
		return blitzRating == other.blitzRating && fidememberId == other.fidememberId
				&& rapidRating == other.rapidRating && standardRating == other.standardRating;
	}
}
