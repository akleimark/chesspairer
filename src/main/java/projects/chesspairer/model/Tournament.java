package projects.chesspairer.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournament")
public class Tournament implements Serializable
{
	private static final long serialVersionUID = -9210344309408506509L;
	
	@Id
	@Column(name = "tournament_id", updatable = false, nullable = false, columnDefinition = "varchar(128)")
	private String tournamentId;
	
	@Column(name = "startdate", nullable = false)
	private LocalDate startdate;
	
	@Column(name = "enddate", nullable = false)
	private LocalDate enddate;
	
	@Column(name = "number_of_rounds", nullable = false, columnDefinition = "smallint")
	private int numberOfRounds;
	
	@Column(name = "tournament_type", nullable = false, columnDefinition = "varchar(32)")
	private int tournamentType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pairingsystem_id", referencedColumnName = "pairingsystem_id")
	private Pairingsystem pairingsystem;
	
}
