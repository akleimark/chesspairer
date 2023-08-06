package projects.chesspairer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.chesspairer.model.Chessplayer;

public interface ChessplayerRepository extends JpaRepository<Chessplayer, Integer>
{
	
}
