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
@Table(name = "pairingsystem")
/**
 * This is the model class, that handles all the pairing systems; i.e Monrad, Berger.
 */
public class Pairingsystem implements Serializable
{	
	private static final long serialVersionUID = -3668833528375544402L;
	
	@Id
	@Column(name = "pairingsystem_id", nullable = false, columnDefinition = "smallint")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int pairingsystemId;
	
	@Column(name = "pairingsystem_name", nullable = false, columnDefinition = "varchar(128)", unique = true)
	private String pairingsystemName;
	
	public Pairingsystem(String pairingsystemName)
	{		
		this.pairingsystemName = pairingsystemName;
	}

	public int getPairingsystemId()
	{
		return pairingsystemId;
	}
		
	public String getPairingsystemName()
	{
		return pairingsystemName;
	}
	
	public void setPairingsystemName(String pairingsystemName)
	{
		this.pairingsystemName = pairingsystemName;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(pairingsystemId, pairingsystemName);
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
		return pairingsystemId == other.pairingsystemId && Objects.equals(pairingsystemName, other.pairingsystemName);
	}
	
	
}
