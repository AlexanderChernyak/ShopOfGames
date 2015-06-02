package by.bsuir.controller;

import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.entity.Basket;
import by.bsuir.entity.Game;
import by.bsuir.entity.User;
import by.bsuir.service.Factory;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		List<Game> games = Factory.getInstance().gameDAO().getAll() ;
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		model.addObject("games", games);
		return model;

	}
	
	@RequestMapping(value = { "/about_us" }, method = RequestMethod.GET)
	public ModelAndView aboutPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("about");
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return model;

	}
	
	
	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
	public ModelAndView contactPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("contact");
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return model;

	}
	
	@RequestMapping(value = { "/products" }, method = RequestMethod.GET)
	public ModelAndView productsPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("products");
		model.addObject("games",Factory.getInstance().gameDAO().getAll());
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return model;

	}
	
	@RequestMapping(value = { "/faqs" }, method = RequestMethod.GET)
	public ModelAndView faqsPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("faqs");
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return model;

	}
	
	@RequestMapping(value = { "/shoppingcart" }, method = RequestMethod.GET)
	public ModelAndView shoppingcartPage(HttpServletRequest request) throws SQLException {

		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		User user = Factory.getInstance().getUserDAO().getById(new Integer((String) session.getAttribute("idUser")));
		List<Basket> baskets = Factory.getInstance().basketDAO().getAll();
		List<Basket> result = new ArrayList<Basket>();
		for (Basket b : baskets){
			if ( b.getUserIdUser().equals(user)){
				result.add(b);
			}
		}
		model.addObject("baskets", result);
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		model.setViewName("shoppingcart");
		return model;

	}
	
	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public ModelAndView registrationPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("registration");
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return model;

	}
	
	@RequestMapping(value = { "/enter" }, method = RequestMethod.GET)
	public ModelAndView enterPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("enter");
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return model;

	}
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public ModelAndView indexPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		List<Game> games = Factory.getInstance().gameDAO().getAll() ;
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		model.addObject("games", games);
		return model;

	}
	
	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public ModelAndView adminPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
		model.addObject("games",Factory.getInstance().gameDAO().getAll());
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return model;

	}
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView addPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("add");
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return model;

	}
	
	@RequestMapping(value = { "/checkout" }, method = RequestMethod.GET)
	public ModelAndView checkoutPage() throws SQLException {

		ModelAndView model = new ModelAndView();
		model.setViewName("checkout");
		model.addObject("genres", Factory.getInstance().gameGenreDAO().getAll());
		return model;

	}
	
}
