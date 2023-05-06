package com.skilldistillery.film.controllers;

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
	
	@RequestMapping(path="/FilmLookup.do")
	public ModelAndView lookUp(@RequestParam("FilmID") int id) {
		ModelAndView mv = new ModelAndView();
		Film film = dao.findFilmById(id);
		mv.setViewName("FilmViewer.jsp");
		mv.addObject(film);
		return mv;
	}
		
	

}
