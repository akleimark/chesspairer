package projects.chesspairer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projects.chesspairer.model.Chessclub;
import projects.chesspairer.service.ChessplayerService;

@Controller
public class WebController
{
	@Autowired
	private ChessplayerService chessplayerService;
	
	@RequestMapping(value = "/index")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("utilities/players")
	public String players(Model model)
	{		
		model.addAttribute("chessplayers", chessplayerService.getAllChessplayers());
		return "utilities/players";
	}
}