package projects.chesspairer.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chesstitle")
/**
 * This is the model class, that handles all the chess titles; i.e GM, IM, FM.
 */
public class Chesstitle
{
	@Id
	@Column(name = "chesstitle_id", nullable = false, columnDefinition = "smallint")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int chesstitleId;
	
	@Column(name = "chessclub_name", columnDefinition = "varchar(128)", unique = true, nullable = false)
	private String chesstitleName;
	
	@Column(name = "chesstitle_order", nullable = false, unique = true)
	private int chesstitleOrder;
	
	public Chesstitle()
	{
		chesstitleName = "";
		chesstitleOrder = -1;
	}
	
	public Chesstitle(String chesstitleName, int chesstitleOrder)
	{
		this.chesstitleName = chesstitleName;
		this.chesstitleOrder = chesstitleOrder;
	}

	public int getChesstitleId()
	{
		return chesstitleId;
	}

	public void setChesstitleId(int chesstitleId)
	{
		this.chesstitleId = chesstitleId;
	}
	
	public String getChesstitleName()
	{
		return chesstitleName;
	}
	
	public void setChesstitleName(String chesstitleName)
	{
		this.chesstitleName = chesstitleName;
	}
	
	public int getChesstitleOrder()
	{
		return chesstitleOrder;
	}

	public void setChesstitleOrder(int chesstitleOrder)
	{
		this.chesstitleOrder = chesstitleOrder;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(chesstitleId, chesstitleName, chesstitleOrder);
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
		Chesstitle other = (Chesstitle) obj;
		return chesstitleId == other.chesstitleId && Objects.equals(chesstitleName, other.chesstitleName)
				&& chesstitleOrder == other.chesstitleOrder;
	}	
}
