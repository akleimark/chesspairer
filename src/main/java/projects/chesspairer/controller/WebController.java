package projects.chesspairer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projects.chesspairer.model.Chessplayer;
import projects.chesspairer.service.ChessclubService;
import projects.chesspairer.service.ChessplayerService;

@Controller
public class WebController
{
	@Autowired
	private ChessplayerService chessplayerService;
	@Autowired
	private ChessclubService chessclubService;
	
	@RequestMapping(value = "/index")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("utilities/players")
	public String players(Model model)
	{		
		model.addAttribute("chessplayer", new Chessplayer());
		model.addAttribute("chessplayers", chessplayerService.getAllChessplayers());
		model.addAttribute("chessclubs", chessclubService.getAllChessclubs());
		return "utilities/players";
	}
	
	@PostMapping("/add-chessplayer")
    public String addChessplayer(@ModelAttribute Chessplayer chessplayer) 
	{		       		
		chessplayerService.saveChessplayer(chessplayer);
        return "index";
    }
	
	
}