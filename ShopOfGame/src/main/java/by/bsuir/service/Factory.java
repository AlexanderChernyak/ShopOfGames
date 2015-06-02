package by.bsuir.service;

import by.bsuir.dao.DAO;
import by.bsuir.dao.DAOImpl;
import by.bsuir.entity.UserInfo;
import by.bsuir.entity.Admin;
import by.bsuir.entity.Basket;
import by.bsuir.entity.Game;
import by.bsuir.entity.GameGenre;
import by.bsuir.entity.GamePlatform;
import by.bsuir.entity.NumOfPlayers;
import by.bsuir.entity.User;



public class Factory {

	private static Factory instance = null;
	private static DAO<UserInfo> userInfoDAO = null;
	private static DAO<Admin> adminDAO = null;
	private static DAO<Basket> basketDAO = null;
	private static DAO<Game> gameDAO = null;
	private static DAO<GameGenre> gameGenreDAO = null;
	private static DAO<GamePlatform> gamePlatformDAO = null;
	private static DAO<NumOfPlayers> numOfPlayersDAO = null;
	private static DAO<User> userDAO = null;

	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public static DAO<UserInfo> getUserInfoDAO() {
		if (userInfoDAO == null)
			userInfoDAO = new DAOImpl<UserInfo>(
					(Class<UserInfo>) (new UserInfo().getClass()));
		return userInfoDAO;
	}

	public static DAO<Admin> getAdminDAO() {
		if (adminDAO == null)
			adminDAO = new DAOImpl<Admin>(
					(Class<Admin>) (new Admin().getClass()));
		return adminDAO;
	}

	public static DAO<Basket> basketDAO() {
		if (basketDAO == null)
			basketDAO = new DAOImpl<Basket>(
					(Class<Basket>) (new Basket().getClass()));
		return basketDAO;
	}

	public static DAO<Game> gameDAO() {
		if (gameDAO == null)
			gameDAO = new DAOImpl<Game>(
					(Class<Game>) (new Game().getClass()));
		return gameDAO;
	}

	public static DAO<GameGenre> gameGenreDAO() {
		if (gameGenreDAO == null)
			gameGenreDAO = new DAOImpl<GameGenre>(
					(Class<GameGenre>) (new GameGenre()
							.getClass()));
		return gameGenreDAO;
	}

	public static DAO<GamePlatform> gamePlatformDAO() {
		if (gamePlatformDAO == null)
			gamePlatformDAO = new DAOImpl<GamePlatform>(
					(Class<GamePlatform>) (new GamePlatform()
							.getClass()));
		return gamePlatformDAO;
	}

	public static DAO<NumOfPlayers> numOfPlayersDAO() {
		if (numOfPlayersDAO == null)
			numOfPlayersDAO = new DAOImpl<NumOfPlayers>(
					(Class<NumOfPlayers>) (new NumOfPlayers().getClass()));
		return numOfPlayersDAO;
	}

	public static DAO<User> getUserDAO() {
		if (userDAO == null)
			userDAO = new DAOImpl<User>(
					(Class<User>) (new User().getClass()));
		return userDAO;
	}


}
