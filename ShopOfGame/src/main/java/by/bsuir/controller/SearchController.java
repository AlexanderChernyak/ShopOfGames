package by.bsuir.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.entity.Game;
import by.bsuir.service.Factory;


@Controller
@RequestMapping(value = "/search")
public class SearchController {
	
	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView forwardSearch(@PathVariable("id") String id
	
	) throws SQLException {
		ModelAndView model = new ModelAndView("search");
		List<Game> games = Factory.getInstance().gameDAO()
				.getAll();
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return model;
	}
	
	public List<Game> searchByName(List<Game> games, String name) {
		List<Game> result = new ArrayList<Game>();
		if (name.equals("")) {
			return games;
		} else {
			for (Game game : games) {
				if (game.getName().equals(name))
					result.add(game);
			}
			return result;
		}
	}
	
	
	@RequestMapping(value = "/search_results/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView forwardSearch(@PathVariable("id") String id,
			@RequestParam("name") String name) throws SQLException {
		ModelAndView model = new ModelAndView("search");
		List<Game> resGAmes =  Factory.getInstance().gameDAO().getAll();
		List<Game> games =searchByName(resGAmes,name);
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		model.addObject("games", games);
		return model;
	}

}
