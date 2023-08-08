package projects.chesspairer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.chesspairer.model.Chessplayer;
import projects.chesspairer.repository.ChessplayerRepository;

@Service
public class ChessplayerService
{
	private final ChessplayerRepository repository;
	
	@Autowired
	public ChessplayerService(ChessplayerRepository cRepository)
	{
		repository = cRepository;
	}
			
	public List<Chessplayer> getAllChessplayers()
	{
		return repository.findAll();
	}
	
	public void saveChessplayer(Chessplayer chessplayer)
	{
		repository.save(chessplayer);
	}
	
	public void deleteChessplayerById(int chessplayerId)
	{
		repository.deleteById(chessplayerId);
	}
	
	public Optional<Chessplayer> findChessplayerById(int chessplayerId)
	{
		return repository.findById(chessplayerId); 		 
	}
	
	
	
}
