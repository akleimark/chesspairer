package projects.chesspairer.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chessclub_id", referencedColumnName = "chessclub_id", foreignKey = @ForeignKey(name = "FK_CHESSPLAYER_CHESSCLUB"))
	private Chessclub chessclub;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_CHESSPLAYER_TITLE"))
	private Set<Chesstitle> chesstitles;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_CHESSPLAYER_RATING"))
	private ChessplayerRating rating;
	
	public Chessplayer()
	{
		this.chessplayerId = -1;
	}
	
	public Chessplayer(int chessplayerId, String firstname, String lastname, String biologicalSex, LocalDate birthdate,
			Chessclub chessclub)
	{		
		this.chessplayerId = chessplayerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.biologicalSex = biologicalSex;
		this.birthdate = birthdate;
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

	
	
	
	
	public int getEloRating(String ratingType) throws Exception
	{
		if(rating == null)
		{
			return 0;
		}
		
		if(ratingType.equals("standard"))
		{
			return this.rating.getStandardRating();
		}
		if(ratingType.equals("rapid"))
		{
			return this.rating.getRapidRating();
		}
		if(ratingType.equals("blitz"))
		{
			return this.rating.getBlitzRating();
		}
		
		throw new Exception("Illegal rating type.");
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(biologicalSex, birthdate, chessclub, chessplayerId, firstname, lastname);
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
				&& Objects.equals(chessclub, other.chessclub) && chessplayerId == other.chessplayerId
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname);
	}
}
