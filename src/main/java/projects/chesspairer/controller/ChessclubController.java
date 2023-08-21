package projects.chesspairer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import projects.chesspairer.model.Chessclub;
import projects.chesspairer.service.ChessclubService;


@Controller
@RequestMapping("/chessclub")
public class ChessclubController
{
	private final ChessclubService chessclubService;
	
	public ChessclubController(ChessclubService cService)
	{
		chessclubService = cService;
	}
		
	@GetMapping("/all")
	public ResponseEntity<List<Chessclub>>getAllChessclubs()
	{
		return new ResponseEntity<>(chessclubService.getAllChessclubs(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Chessclub> addChessclub(@RequestBody Chessclub chessclub)
	{
		Chessclub newChessclub = chessclubService.saveChessclub(chessclub);		
		return new ResponseEntity<>(newChessclub, HttpStatus.CREATED);
	}
	
	@PostMapping("/find/name")
	public ResponseEntity<Chessclub> findbyChessclubName(@RequestBody Chessclub chessclub)
	{
		Chessclub aChessclub = chessclubService.findChessclubByChessclubName(chessclub.getChessclubName());
		if(aChessclub == null)
		{
			return new ResponseEntity<>(new Chessclub(), HttpStatus.OK);
		}
		return new ResponseEntity<>(aChessclub, HttpStatus.OK);	
	}
	
	
}
