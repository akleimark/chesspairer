package projects.chesspairer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.chesspairer.model.Chessclub;

public interface ChessclubRepository extends JpaRepository<Chessclub, String>
{
	
}
