package by.bsuir.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dropbox.core.DbxException;

import by.bsuir.entity.Basket;
import by.bsuir.entity.Game;
import by.bsuir.entity.GameGenre;
import by.bsuir.entity.User;
import by.bsuir.entity.UserInfo;
import by.bsuir.service.Dropbox;
import by.bsuir.service.Factory;

@Controller
@MultipartConfig
@RequestMapping(value = "/gameaddaddd")
public class GameController {

	@RequestMapping(value = "/delete_basket/{id}", method = RequestMethod.GET)
	public ModelAndView deleteBasket(@PathVariable("id") String id)
			throws SQLException {

		ModelAndView model = new ModelAndView("shoppingcart");
		Factory.getInstance()
				.basketDAO()
				.delete(Factory.getInstance().basketDAO()
						.getById(new Integer(id)));
		model.addObject("baskets", Factory.getInstance().basketDAO().getAll());
		return model;
	}
	
	@RequestMapping(value = "/show_genre/{id}", method = RequestMethod.GET)
	public ModelAndView showGenre(@PathVariable("id") String id)
			throws SQLException {

		ModelAndView model = new ModelAndView("index");
		List<Game> games = Factory.getInstance().gameDAO().getAll();
		GameGenre genre = Factory.getInstance().gameGenreDAO().getById(new Integer(id));
		List<Game> result = new ArrayList<Game>();
		for (Game game : games) {
			if (game.getIdGenre().equals(genre))
				result.add(game);
		}
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		model.addObject("games", result);
		return model;
	}

	@RequestMapping(value = "/add_to_cart", method = RequestMethod.POST)
	public ModelAndView addToCart(HttpServletRequest request)
			throws SQLException {
		
		ModelAndView model = new ModelAndView("shoppingcart");
		HttpSession session = request.getSession();
		Game game = Factory.getInstance().gameDAO()
				.getById(new Integer(request.getParameter("game")));
		User user = Factory.getInstance().getUserDAO()
				.getById(new Integer((String) session.getAttribute("idUser")));
		Basket basket = new Basket(game.getPrice(), game, user);
		Factory.getInstance().basketDAO().add(basket);
		List<Basket> baskets = Factory.getInstance().basketDAO().getAll();
		List<Basket> result = new ArrayList<Basket>();
		for (Basket b : baskets) {
			if (b.getUserIdUser().equals(user)) {
				result.add(b);
			}
		}
		model.addObject("baskets", result);
		return model;
	}

	@RequestMapping(value = "/add_game_page", method = RequestMethod.GET)
	public ModelAndView gameaddPage() throws SQLException {

		ModelAndView model = new ModelAndView("add");
		model.addObject("platforms", Factory.getInstance().gamePlatformDAO()
				.getAll());
		model.addObject("numplayers", Factory.getInstance().numOfPlayersDAO()
				.getAll());
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		
		return model;
	}

	@RequestMapping(value = "/delete_game", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value = "game", defaultValue = "0") String id)
			throws SQLException {

		ModelAndView model = new ModelAndView("admin");
		if (id.equals("0")){
			model.setViewName("enter");
			model.addObject("error", "Ошибка доступа, авторизируйтесь!");
			return model;
		}
		Factory.getInstance()
				.gameDAO()
				.delete(Factory.getInstance().gameDAO()
						.getById(new Integer(id)));
		return model;
	}

	@RequestMapping(value = "/edit", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView edit(@RequestParam(value = "game", defaultValue = "0" ) String id)
			throws SQLException {
		ModelAndView model = new ModelAndView("edit");
		if (id.equals("0")){
			model.setViewName("enter");
			model.addObject("error", "Ошибка доступа, авторизируйтесь!");
			return model;
		}
		
		model.addObject("game",
				Factory.getInstance().gameDAO().getById(new Integer(id)));
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		model.addObject("platforms", Factory.getInstance().gamePlatformDAO()
				.getAll());
		model.addObject("numplayers", Factory.getInstance().numOfPlayersDAO()
				.getAll());

		return model;
	}

	@RequestMapping(value = "/edit_game", method ={RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody ModelAndView editGame(@RequestParam("game") String id,
			@RequestParam("name") String name,
			@RequestParam("numplayer") String numplayer,
			@RequestParam("platform") String platform,
			@RequestParam("year_of_manufacture") Date year_of_manufacture,
			@RequestParam("description") String description,
			@RequestParam("price") String price,
			@RequestParam("systemrequirements") String systemrequirements,
			@RequestParam("amount") String amount,
			@RequestParam("publicherhouse") String publicherhouse,
			@RequestParam("genr") String genr,
			@RequestParam("file") MultipartFile file) throws IOException,
			DbxException, NumberFormatException, SQLException {
		ModelAndView model = new ModelAndView("admin");
		Game game = Factory.getInstance().gameDAO().getById(new Integer(id));
		try {
			model.addObject("platforms", Factory.getInstance()
					.gamePlatformDAO().getAll());
			model.addObject("numplayers", Factory.getInstance()
					.numOfPlayersDAO().getAll());
			model.addObject("genres", Factory.getInstance().gameGenreDAO()
					.getAll());
			game.setName(name);
			game.setIdNum(Factory.getInstance().numOfPlayersDAO()
					.getById(new Integer(numplayer)));
			game.setIdPlatform(Factory.getInstance().gamePlatformDAO()
					.getById(new Integer(platform)));
			game.setYearOfManufacture(year_of_manufacture);
			game.setDescription(description);
			game.setPrice(Double.parseDouble(price));
			game.setSystemrequirements(systemrequirements);
			game.setAmount(Integer.parseInt(amount));
			game.setPublicherhouse(publicherhouse);
			game.setIdGenre(Factory.getInstance().gameGenreDAO()
					.getById(new Integer(genr)));
			Dropbox dropbox = new Dropbox();
			game.setUrl(dropbox.UploadingFile(file));
			Factory.getInstance().gameDAO().update(game);
			model.addObject("success", "Изменение прошло успешно");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			model.addObject("error", "Регистрация не удалась");
			return model;
		}
		return model;
	}

	@RequestMapping(value = "/add_game", method = RequestMethod.POST)
	public @ResponseBody ModelAndView addGame(
			@RequestParam("name") String name,
			@RequestParam("numplayer") String numplayer,
			@RequestParam("platform") String platform,
			@RequestParam("year_of_manufacture") Date year_of_manufacture,
			@RequestParam("description") String description,
			@RequestParam("price") String price,
			@RequestParam("systemrequirements") String systemrequirements,
			@RequestParam("amount") String amount,
			@RequestParam("publicherhouse") String publicherhouse,
			@RequestParam("genr") String genr,
			@RequestParam("file") MultipartFile file) throws IOException,
			DbxException {
		ModelAndView model = new ModelAndView("index");
		Game game = new Game();
		try {
			model.addObject("platforms", Factory.getInstance()
					.gamePlatformDAO().getAll());
			model.addObject("numplayers", Factory.getInstance()
					.numOfPlayersDAO().getAll());
			model.addObject("genres", Factory.getInstance().gameGenreDAO()
					.getAll());
			game.setName(name);
			game.setIdNum(Factory.getInstance().numOfPlayersDAO()
					.getById(new Integer(numplayer)));
			game.setIdPlatform(Factory.getInstance().gamePlatformDAO()
					.getById(new Integer(platform)));
			game.setYearOfManufacture(year_of_manufacture);
			game.setDescription(description);
			game.setPrice(Double.parseDouble(price));
			game.setSystemrequirements(systemrequirements);
			game.setAmount(Integer.parseInt(amount));
			game.setPublicherhouse(publicherhouse);
			game.setIdGenre(Factory.getInstance().gameGenreDAO()
					.getById(new Integer(genr)));
			Dropbox dropbox = new Dropbox();
			game.setUrl(dropbox.UploadingFile(file));
			Factory.getInstance().gameDAO().add(game);
			model.addObject("success", "Регистрация прошла успешно");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			model.addObject("error", "Регистрация не удалась");
			return model;
		}
		return model;
	}

	@RequestMapping(value = "/productdetail/{id}", method = RequestMethod.GET)
	ModelAndView showGame(@PathVariable("id") String id)
			throws NumberFormatException, SQLException {
		ModelAndView modelAndView = new ModelAndView("productdetail");
		modelAndView.addObject("game",
				Factory.getInstance().gameDAO().getById(new Integer(id)));
		modelAndView.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return modelAndView;
	}

}
