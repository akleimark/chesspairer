package projects.chesspairer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import projects.chesspairer.model.Chessplayer;
import projects.chesspairer.service.ChessplayerService;

@Controller
@RequestMapping("/chessplayers")
public class ChessplayerController
{
	private final ChessplayerService chessplayerService;
	
	public ChessplayerController(ChessplayerService cService)
	{
		chessplayerService = cService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Chessplayer>> getAllChessplayers()
	{
		return new ResponseEntity<>(chessplayerService.getAllChessplayers(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Chessplayer>> getChessplayerById(@PathVariable("id") int id)
	{
		Optional<Chessplayer> chessplayer = chessplayerService.findChessplayerById(id);
		return new ResponseEntity<>(chessplayer, HttpStatus.OK);
	}
	
	
}
