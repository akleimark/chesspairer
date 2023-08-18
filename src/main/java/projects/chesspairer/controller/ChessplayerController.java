package projects.chesspairer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/add")
	public ResponseEntity<Chessplayer> addChessplayer(@RequestBody Chessplayer chessplayer)
	{
		Chessplayer newChessplayer = chessplayerService.addChessplayer(chessplayer);
		return new ResponseEntity<>(newChessplayer,  HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Chessplayer> updateChessplayer(@RequestBody Chessplayer chessplayer)
	{
		Chessplayer aChessplayer = chessplayerService.updateChessplayer(chessplayer);
		return new ResponseEntity<>(aChessplayer,  HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Chessplayer> findChessplayer(@PathVariable int id)
	{
		Chessplayer chessplayer = chessplayerService.findChessplayerById(id);
		return new ResponseEntity<>(chessplayer,  HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteChessplayer(@PathVariable int id)
	{
		chessplayerService.deleteChessplayerById(id);
		return "redirect:/utilities/players";
	}
}
