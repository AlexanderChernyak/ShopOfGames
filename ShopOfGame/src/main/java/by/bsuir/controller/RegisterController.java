package by.bsuir.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.entity.Admin;
import by.bsuir.entity.User;
import by.bsuir.entity.UserInfo;
import by.bsuir.service.Factory;

@Controller
public class RegisterController {

	@RequestMapping(value = "/add_user", method = RequestMethod.GET)
	public @ResponseBody ModelAndView registration(
			@RequestParam("lastname") String lastname,
			@RequestParam("firstname") String firstname,
			@RequestParam("patronymic") String patronymic,
			@RequestParam("date_of_birdth") Date date_of_birdth,
			@RequestParam("phone") String phone,
			@RequestParam("num_of_cards") String num_of_cards,
			@RequestParam("e_mail") String e_mail,
			@RequestParam("password") String password) throws IOException {
		ModelAndView model = new ModelAndView("index");
		UserInfo userInfo = new UserInfo();
		User user = new User();
		try {
			userInfo.setLastname(lastname);
			userInfo.setFirstname(firstname);
			userInfo.setPatronymic(patronymic);
			userInfo.setDateOfBirdth(date_of_birdth);
			userInfo.setPhone(Integer.parseInt(phone));
			userInfo.setNumOfCards(num_of_cards);
			user.setEMail(e_mail);
			user.setPassword(password);
			user.setUserInfoId(userInfo);

			Factory.getInstance().getUserInfoDAO().add(userInfo);
			Factory.getInstance().getUserDAO().add(user);
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

	@RequestMapping(value = "/enter", method = RequestMethod.POST)
	public ModelAndView enter(HttpServletRequest request) throws SQLException {
		ModelAndView modelAndView = new ModelAndView();
		String login = request.getParameter("e_mail");
		String password = request.getParameter("password");
		Admin admin = Factory.getInstance().getAdminDAO().getById(2);
		if (admin != null) {
			if (login.equals(admin.getLogin())
					&& password.equals(admin.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("authorized", "admin");
				session.setAttribute("idUser", "admin");
				session.setAttribute("nameUser", "Администратор");
				modelAndView.setViewName("admin");
				return modelAndView;
			}
		}
		List<User> users = Factory.getInstance().getUserDAO().getAll();
		for (User user : users) {
			if (user.getEMail().equals(login)
					&& user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("authorized", "user");
				session.setAttribute("idUser", user.getIdUser().toString());
				session.setAttribute("nameUser", user.getUserInfoId()
						.getFirstname());
				modelAndView.setViewName("index");
				return modelAndView;
			}
		}
		modelAndView.setViewName("index");
		modelAndView.addObject("error", "Неверный логин или пароль");
		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) throws SQLException {
		ModelAndView modelAndView = new ModelAndView("enter");
		HttpSession session = request.getSession();
		session.setAttribute("authorized", "false");
		;
		return modelAndView;
	}

}
