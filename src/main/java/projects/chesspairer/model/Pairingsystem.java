package projects.chesspairer.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pairingsystem")

public class Pairingsystem implements Serializable
{	
	private static final long serialVersionUID = -3668833528375544402L;
	@Id
	@Column(name = "pairingsystem_id", nullable = false, columnDefinition = "varchar(128)")
	private final String pairingsystemId;
	
	public Pairingsystem(String pairingsystemId)
	{		
		this.pairingsystemId = pairingsystemId;
	}

	public String getPairingsystemId()
	{
		return pairingsystemId;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(pairingsystemId);
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
		Pairingsystem other = (Pairingsystem) obj;
		return Objects.equals(pairingsystemId, other.pairingsystemId);
	}
	
	
	
	
}
