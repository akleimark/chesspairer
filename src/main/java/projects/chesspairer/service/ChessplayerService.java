package projects.chesspairer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		return repository.findAll(Sort.by(Sort.Direction.ASC, "chessplayerId"));
	}
	
	public Chessplayer addChessplayer(Chessplayer chessplayer)
	{
		return repository.save(chessplayer);
	}
	
	public Chessplayer updateChessplayer(Chessplayer chessplayer)
	{
		return repository.save(chessplayer);
	}
		
	public Chessplayer findChessplayerById(int id)
	{
		return repository.findChessplayerByChessplayerId(id);
	}
	
	
	public void deleteChessplayerById(int chessplayerId)
	{
		repository.deleteById(chessplayerId);
	}

	
	
	
}
