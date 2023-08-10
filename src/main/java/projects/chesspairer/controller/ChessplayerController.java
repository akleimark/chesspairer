package projects.chesspairer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import projects.chesspairer.model.Chessplayer;
import projects.chesspairer.service.ChessplayerService;

@Controller
@RequestMapping("/chessplayer")
public class ChessplayerController
{
	@Autowired
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
	
	@PutMapping("/save")
	public ResponseEntity<Chessplayer> saveChessplayer(@RequestBody Chessplayer chessplayer)
	{
		Chessplayer updatedChessplayer = chessplayerService.saveChessplayer(chessplayer);
		return new ResponseEntity<>(updatedChessplayer,  HttpStatus.OK);
	}

	
	
	
}
