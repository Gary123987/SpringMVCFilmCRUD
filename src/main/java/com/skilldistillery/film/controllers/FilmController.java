package com.skilldistillery.film.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.DatabaseAccessor;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private DatabaseAccessor dao;
	
	
	@RequestMapping(path = {"/", "home.do"})
	public String home(Model model) {
		return "WEB-INF/home.jsp";
	}
	
	@RequestMapping(path="FilmLookup.do")
	public ModelAndView lookUp(@RequestParam("FilmID") int id) {
		ModelAndView mv = new ModelAndView();
		Film film = dao.findFilmById(id);
		if(film != null) {
			String lang = dao.getFilmLang(film);
			film.setLanguage(lang);			
			String category = dao.getFilmCategory(film);
			film.setCategory(category);
			List<Actor> actors = film.getActors();
			film.setActors(actors);
			mv.addObject(film);
		}
		mv.setViewName("FilmViewer.jsp");
		return mv;
	}
	@RequestMapping(path="FilmLookup2.do")
	public ModelAndView lookUpByKeyword(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		String[] splited = keyword.split("\\s+");
		List<Film> films = new ArrayList<>(); 
		for (String splitKeyword : splited) {
		films.addAll(dao.findFilmByKeyword(splitKeyword));
		}
		for (Film film : films) {
			String lang = dao.getFilmLang(film);
			film.setLanguage(lang);		
			String category = dao.getFilmCategory(film);
			film.setCategory(category);
			int id = film.getFilmId();
			List<Actor> actors = dao.findActorsByFilmId(id);
			film.setActors(actors);
		}
		mv.setViewName("FilmViewer.jsp");
		mv.addObject("films", films);				
		return mv;
	}
	
	@RequestMapping(path="AddFilm.do")
	public ModelAndView adder(@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("releaseYear") int year,
			@RequestParam("rentalDuration") int rentalDuration,
			@RequestParam("rentalRate") double rentalRate,
			@RequestParam("length")int length,
			@RequestParam("replacementCost") double replacementCost,
			@RequestParam("rating")String rating) {
		ModelAndView mv = new ModelAndView();
		Film film = new Film(title, description, year, 1, rentalDuration, rentalRate, length, replacementCost, rating);
		film = dao.createFilm(film);
		if (film != null) {
		String lang = dao.getFilmLang(film);
		film.setLanguage(lang);
		List<Actor> actors = new ArrayList<>();
		film.setActors(actors);
		mv.setViewName("FilmViewer.jsp");
		mv.addObject(film);
		return mv;
		}
		return mv;
	}
	
	

}
