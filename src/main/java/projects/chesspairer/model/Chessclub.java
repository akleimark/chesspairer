package projects.chesspairer.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chessclub")
/**
 * This is the model class, that handles all the clubs.
 */
public class Chessclub implements Serializable
{
	private static final long serialVersionUID = -5499983697978265977L;
	
	@Id
	@Column(name = "chessclub_id", nullable = false, columnDefinition = "varchar(128)")
	private final String chessclubId;
	
	
	public Chessclub()
	{
		chessclubId = "";
	}
	
	public Chessclub(String chessclubId)
	{
		super();
		this.chessclubId = chessclubId;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(chessclubId);
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
		Chessclub other = (Chessclub) obj;
		return Objects.equals(chessclubId, other.chessclubId);
	}

	public String getChessclubId()
	{
		return chessclubId;
	}
	
	@Override
	public String toString()
	{
		return "Chessclub: " + this.chessclubId;
	}
}
