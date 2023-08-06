package projects.chesspairer.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fidemember")
public class Fidemember implements Serializable
{
	private static final long serialVersionUID = 4867943573222194622L;
	
	@Id
	@Column(name = "fidemember_id", nullable = false)
	private int fidemeberId;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chessplayer_id", referencedColumnName = "chessplayer_id")
	private Chessplayer chessplayer;


	public Fidemember(int fidemeberId, Chessplayer chessplayer)
	{		
		this.fidemeberId = fidemeberId;
		this.chessplayer = chessplayer;
	}


	@Override
	public int hashCode()
	{
		return Objects.hash(chessplayer, fidemeberId);
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
		Fidemember other = (Fidemember) obj;
		return Objects.equals(chessplayer, other.chessplayer) && fidemeberId == other.fidemeberId;
	}
	
	
	
	
}
