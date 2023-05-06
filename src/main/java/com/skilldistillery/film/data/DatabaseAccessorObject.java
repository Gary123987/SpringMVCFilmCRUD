package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
@Component
public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String USER = "student";
	private static final String PASSWORD = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int fId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT film.* FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, fId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				int filmId = filmResult.getInt("id");
				String title = filmResult.getString("title");
				String desc = filmResult.getString("description");
				int releaseYear = filmResult.getShort("release_year");
				int langId = filmResult.getInt("language_id");
				int rentDur = filmResult.getInt("rental_duration");
				double rate = filmResult.getDouble("rental_rate");
				int length = filmResult.getInt("length");
				double repCost = filmResult.getDouble("replacement_cost");
				String rating = filmResult.getString("rating");
				String features = filmResult.getString("special_features");
				film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				film.setActors(findActorsByFilmId(fId));
			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int aId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT actor.* FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, aId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				int id = actorResult.getInt("id");
				String fn = actorResult.getString("first_name");
				String ln = actorResult.getString("last_name");
				actor = new Actor(id, fn, ln);
				actor.setFilms(findFilmsByActorId(aId));
			}
			actorResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		try {
//			1) connect
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			2) formulate query
			String sql = "SELECT film.* FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE actor_id = ?";
//			3) prepare statement for database
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
//			4) run statement
			ResultSet rs = stmt.executeQuery();
//			5) iterate results
			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				int releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT actor.* FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int actorId = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Actor actor = new Actor(actorId, firstName, lastName);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public List<Film> findFilmByKeyword(String word) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT film.* FROM film WHERE film.title LIKE ? OR film.description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + word + "%");
			stmt.setString(2, "%" + word + "%");
			ResultSet filmResult = stmt.executeQuery();
			while (filmResult.next()) {
				int filmId = filmResult.getInt("id");
				String title = filmResult.getString("title");
				String desc = filmResult.getString("description");
				int releaseYear = filmResult.getShort("release_year");
				int langId = filmResult.getInt("language_id");
				int rentDur = filmResult.getInt("rental_duration");
				double rate = filmResult.getDouble("rental_rate");
				int length = filmResult.getInt("length");
				double repCost = filmResult.getDouble("replacement_cost");
				String rating = filmResult.getString("rating");
				String features = filmResult.getString("special_features");
				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				films.add(film);
			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public Actor createActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO actor (first_name, last_name) " + " VALUES (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newActorId = keys.getInt(1);
					actor.setId(newActorId);
					if (actor.getFilms() != null && actor.getFilms().size() > 0) {
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);
						for (Film film : actor.getFilms()) {
							stmt.setInt(1, film.getFilmId());
							stmt.setInt(2, newActorId);
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				actor = null;
			}
			conn.commit(); // COMMIT TRANSACTION
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
		}
		return actor;
	}

	@Override
	public boolean updateActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE actor SET first_name=?, last_name=? WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());
			stmt.setInt(3, actor.getId());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				// Replace actor's film list
				sql = "DELETE FROM film_actor WHERE actor_id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, actor.getId());
				updateCount = stmt.executeUpdate();
				sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
				stmt = conn.prepareStatement(sql);
				for (Film film : actor.getFilms()) {
					stmt.setInt(1, film.getFilmId());
					stmt.setInt(2, actor.getId());
					updateCount = stmt.executeUpdate();
				}
				conn.commit(); // COMMIT TRANSACTION
				conn.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
					conn.close();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film_actor WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actor.getId());
			int updateCount = stmt.executeUpdate();
			sql = "DELETE FROM actor WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actor.getId());
			updateCount = stmt.executeUpdate();
			conn.commit(); // COMMIT TRANSACTION
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}
	
	@Override
	public Film createFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating)"
					+ "VALUES (?, ?, ?, 1, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDesc());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getRentDur());
			stmt.setDouble(5, film.getRate());
			stmt.setInt(6, film.getLength());
			stmt.setDouble(7, film.getRepCost());
			stmt.setString(8, film.getRating());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					film.setFilmId(newFilmId);
					conn.commit(); // COMMIT TRANSACTION
					return film;
				}
			} 
			conn.commit(); // COMMIT TRANSACTION
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
		}
		return null;
	}
	
	@Override
	public boolean deleteFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film_actor WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getFilmId());
			int updateCount = stmt.executeUpdate();
			sql = "DELETE FROM film WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getFilmId());
			updateCount = stmt.executeUpdate();
			conn.commit(); // COMMIT TRANSACTION
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public Film updateFilm(int filmId, Film film) {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "UPDATE film "
					+ "SET title = ?, description = ?, release_year = ?, language_id = 1, rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ? "
					+ "WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDesc());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getRentDur());
			stmt.setDouble(5, film.getRate());
			stmt.setInt(6, film.getLength());
			stmt.setDouble(7, film.getRepCost());
			stmt.setString(8, film.getRating());
			stmt.setInt(9, filmId);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			film = null;
		}
		return findFilmById(filmId);
	}
	
	public String getFilmLang(Film film) {
		String title = null;
		String lang = null;
		try {
			title = film.getTitle();
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT language.name FROM language JOIN film ON language.id = film.language_id "
					+ "WHERE film.title = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			lang = rs.getString(1);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lang;
	}
}