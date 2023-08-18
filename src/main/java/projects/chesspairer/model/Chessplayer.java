package projects.chesspairer.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "Chessplayer")
@Table(name = "chessplayer")

/**
 * This is the model class, that handles all the players.
 */

public class Chessplayer implements Serializable
{
	private static final long serialVersionUID = 2984470458571253314L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chessplayer_id", updatable = false)
	private final int chessplayerId;
	
	@Column(name = "firstname", nullable = false, columnDefinition = "varchar(128)")
	private String firstname;
	
	@Column(name = "lastname", nullable = false, columnDefinition = "varchar(128)")
	private String lastname;
	
	@Column(name = "biological_sex", nullable = false, columnDefinition = "varchar(32)")
	private String biologicalSex;
	
	@Column(name = "birthdate", nullable = false)
	private LocalDate birthdate;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "federation_id", referencedColumnName = "federation_id", foreignKey = @ForeignKey(name = "FK_CHESSPLAYER_FEDERATION"))
	private Federation federation;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "chessclub_id", nullable = false, referencedColumnName = "chessclub_id", foreignKey = @ForeignKey(name = "FK_CHESSPLAYER_CHESSCLUB"))
	private Chessclub chessclub;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Fidemember fidemember;
	
	public String getName()
	{
		return firstname + " " + lastname;
	}
	
	public Chessplayer()
	{
		this.chessplayerId = -1;
	}
	
	public Chessplayer(int chessplayerId, String firstname, String lastname, String biologicalSex, LocalDate birthdate,
			Federation federation, Chessclub chessclub)
	{
		this.chessplayerId = chessplayerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.biologicalSex = biologicalSex;
		this.birthdate = birthdate;
		this.federation = federation;
		this.chessclub = chessclub;
	}
	
	public int getChessplayerId()
	{
		return chessplayerId;
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	
	public String getLastname()
	{
		return lastname;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	
	public String getBiologicalSex()
	{
		return biologicalSex;
	}
	
	public void setBiologicalSex(String biologicalSex)
	{
		this.biologicalSex = biologicalSex;
	}
	
	public LocalDate getBirthdate()
	{
		return birthdate;
	}
	
	public void setBirthdate(LocalDate birthdate)
	{
		this.birthdate = birthdate;
	}
	
	public Chessclub getChessclub()
	{
		return chessclub;
	}
	
	public void setChessclub(Chessclub chessclub)
	{
		this.chessclub = chessclub;
	}
	
	public Federation getFederation()
	{
		return federation;
	}
	
	public void setFederation(Federation federation)
	{
		this.federation = federation;
	}
	
	public int getEloRating(String type)
	{
		if(fidemember == null)
		{
			return 0;
		}
		return fidemember.getRating(type);
		
	}
	
	public String getChesstitle()
	{
		if(fidemember == null)
		{
			return "";
		}
		
		return fidemember.getHighestTitle();
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(biologicalSex, birthdate, federation, chessclub, chessplayerId, firstname, lastname);
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
		Chessplayer other = (Chessplayer) obj;
		return Objects.equals(biologicalSex, other.biologicalSex) && Objects.equals(birthdate, other.birthdate)
				&& Objects.equals(chessclub, other.chessclub) && Objects.equals(federation, other.federation)
				&& chessplayerId == other.chessplayerId && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname);
	}
}
