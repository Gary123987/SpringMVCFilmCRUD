package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.DatabaseAccessor;
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
		mv.setViewName("FilmViewer.jsp");
		mv.addObject(film);
		return mv;
	}
	@RequestMapping(path="FilmLookup2.do")
	public ModelAndView lookUpByKeyword(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = dao.findFilmByKeyword(keyword);
		mv.setViewName("FilmViewer.jsp");
		mv.addObject(films);
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
		Film film = new Film(0, title, description, year, 1, rentalDuration, rentalRate, length, replacementCost, rating);
		film = dao.createFilm(film);
		mv.setViewName("FilmViewer.jsp");
		mv.addObject(film);
		return mv;
	}
	
	

}
