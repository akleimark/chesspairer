package projects.chesspairer.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournament")
/**
 * This is the model class, that handles all the tournament data.
 */
public class Tournament implements Serializable
{
	private static final long serialVersionUID = -9210344309408506509L;
	
	@Id
	@Column(name = "tournament_id", updatable = false, nullable = false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int tournamentId;
	
	@Column(name = "tournament_name",  nullable = false, columnDefinition = "varchar(128)")
	private String tournamentName;
	
	@Column(name = "startdate", nullable = false)
	private LocalDate startdate;
	
	@Column(name = "enddate", nullable = false)
	private LocalDate enddate;
	
	@Column(name = "number_of_rounds", nullable = false, columnDefinition = "smallint")
	private int numberOfRounds;
	
	@Column(name = "tournament_type", nullable = false, columnDefinition = "varchar(32)")
	private int tournamentType;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pairingsystem_id", referencedColumnName = "pairingsystem_id", foreignKey = @ForeignKey(name = "FK_TOURNAMENT_PAIRINGSYSTEM"))
	private Pairingsystem pairingsystem;
	
	@OneToMany
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_TOURNAMENT_TOURNAMENTPLAYER"))
	private Set<TournamentPlayer> tournamentPlayers;	
	
	public Tournament(String tournamentName, LocalDate startdate, LocalDate enddate, int numberOfRounds,
			int tournamentType, Pairingsystem pairingsystem)
	{
		this.tournamentName = tournamentName;
		this.startdate = startdate;
		this.enddate = enddate;
		this.numberOfRounds = numberOfRounds;
		this.tournamentType = tournamentType;
		this.pairingsystem = pairingsystem;
	}

	public int getTournamentId()
	{
		return tournamentId;
	}

	public void setTournamentId(int tournamentId)
	{
		this.tournamentId = tournamentId;
	}
	
	public String getTournamentName()
	{
		return tournamentName;
	}

	public void setTournamentName(String tournamentName)
	{
		this.tournamentName = tournamentName;
	}
	
	public LocalDate getStartdate()
	{
		return startdate;
	}

	public void setStartdate(LocalDate startdate)
	{
		this.startdate = startdate;
	}

	public LocalDate getEnddate()
	{
		return enddate;
	}

	public void setEnddate(LocalDate enddate)
	{
		this.enddate = enddate;
	}

	public int getNumberOfRounds()
	{
		return numberOfRounds;
	}

	public void setNumberOfRounds(int numberOfRounds)
	{
		this.numberOfRounds = numberOfRounds;
	}

	public int getTournamentType()
	{
		return tournamentType;
	}

	public void setTournamentType(int tournamentType)
	{
		this.tournamentType = tournamentType;
	}

	public Pairingsystem getPairingsystem()
	{
		return pairingsystem;
	}

	public void setPairingsystem(Pairingsystem pairingsystem)
	{
		this.pairingsystem = pairingsystem;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(enddate, numberOfRounds, pairingsystem, startdate, tournamentId, tournamentName,
				tournamentPlayers, tournamentType);
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
		Tournament other = (Tournament) obj;
		return Objects.equals(enddate, other.enddate) && numberOfRounds == other.numberOfRounds
				&& Objects.equals(pairingsystem, other.pairingsystem) && Objects.equals(startdate, other.startdate)
				&& tournamentId == other.tournamentId && Objects.equals(tournamentName, other.tournamentName)
				&& Objects.equals(tournamentPlayers, other.tournamentPlayers) && tournamentType == other.tournamentType;
	}
		
}
