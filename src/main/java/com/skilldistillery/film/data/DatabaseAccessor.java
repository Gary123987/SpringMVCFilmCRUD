package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId) throws SQLException;
  public Actor findActorById(int actorId) throws SQLException;
  public List<Film> findFilmsByActorId(int actorId)throws SQLException;
public List<Film> searchByKeyword(String string);
public String getFilmLang(Film findFilmById);
List<Actor> findActorsByFilmId(Film film);
public Film createFilm(Film newFilm);
  
  

}
