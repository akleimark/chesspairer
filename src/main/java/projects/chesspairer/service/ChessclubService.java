package projects.chesspairer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.chesspairer.model.Chessclub;
import projects.chesspairer.repository.ChessclubRepository;

@Service
public class ChessclubService
{
	private final ChessclubRepository repository;
	
	@Autowired
	public ChessclubService(ChessclubRepository cRepository)
	{
		repository = cRepository;
	}
	
	public List<Chessclub> getAllChessclubs()
	{
		return repository.findAll();
	}
	
	public Chessclub saveChessclub(Chessclub chessclub)
	{
		return repository.save(chessclub);
	}

	public Chessclub findChessclubByChessclubName(String name)
	{
		return repository.findChessclubByChessclubName(name);
	}
	
	
}
