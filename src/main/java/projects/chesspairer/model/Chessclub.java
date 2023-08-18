package projects.chesspairer.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chessclub_id")
	private int chessclubId;
	
	@Column(name = "chessclub_name", columnDefinition = "varchar(128)", unique = true)
	private String chessclubName;
	
	public Chessclub()
	{
		chessclubName = "";
	}
	
	public Chessclub(String chessclubName)
	{
		this.chessclubName = chessclubName;
	}
	
	public int getChessclubId()
	{
		return chessclubId;
	}
	
	public String getChessclubName()
	{
		return chessclubName;
	}
	
	public void setChessclubName(String chessclubName)
	{
		this.chessclubName = chessclubName;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(chessclubId, chessclubName);
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
		return chessclubId == other.chessclubId && Objects.equals(chessclubName, other.chessclubName);
	}
	
	@Override
	public String toString()
	{
		return "Chessclub: " + this.chessclubName;
	}
}
