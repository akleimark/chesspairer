package projects.chesspairer.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@Column(name = "chesstitle_id", nullable = false, columnDefinition = "varchar(128)")
	private String chesstitleId;
	
	@Column(name = "chesstitle_order", nullable = false, unique = true)
	private int chesstitleOrder;
	
	public Chesstitle()
	{
		chesstitleId = "";
		chesstitleOrder = -1;
	}
	
	public Chesstitle(String pChesstitleId, int pChesstitleOrder)
	{
		chesstitleId = pChesstitleId;
		chesstitleOrder = pChesstitleOrder;
	}

	public String getChesstitleId()
	{
		return chesstitleId;
	}

	public void setChesstitleId(String chesstitleId)
	{
		this.chesstitleId = chesstitleId;
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
		return Objects.hash(chesstitleId, chesstitleOrder);
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
		return Objects.equals(chesstitleId, other.chesstitleId) && chesstitleOrder == other.chesstitleOrder;
	}	
	
	
}
