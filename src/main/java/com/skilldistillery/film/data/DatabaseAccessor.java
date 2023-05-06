package com.skilldistillery.film.data;


import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Language;

public interface DatabaseAccessor {
	Film findFilmById(int fId);
	Actor findActorById(int aId);
	List<Actor> findActorsByFilmId(int filmId);
	List<Film> findFilmsByActorId(int actorId);
	List<Film> findFilmByKeyword(String word);
	Language findLanguage(int idFilm);
	Actor createActor(Actor actor);
	boolean updateActor(Actor actor);
	boolean deleteActor(Actor actor);
	Film createFilm(Film film);
	boolean deleteFilm(Film film);
	Film updateFilm(int filmId, Film film);
}
