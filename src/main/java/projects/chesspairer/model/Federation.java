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
@Table(name = "federation")
public class Federation implements Serializable
{
	private static final long serialVersionUID = -8875159908859164501L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "federation_id", updatable = false)
	private int federationId;
	
	@Column(name = "federation_name",  unique = true)
	private String federationName;
		
	public Federation(String federationName)
	{
		this.federationName = federationName;
	}

	public int getFederationId()
	{
		return federationId;
	}

	public void setFederationId(int federationId)
	{
		this.federationId = federationId;
	}

	public String getFederationName()
	{
		return federationName;
	}

	public void setFederationName(String federationName)
	{
		this.federationName = federationName;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(federationId, federationName);
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
		Federation other = (Federation) obj;
		return federationId == other.federationId && Objects.equals(federationName, other.federationName);
	}

	@Override
	public String toString()
	{
		return federationName;
	}
	
}
