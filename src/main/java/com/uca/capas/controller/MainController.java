package com.uca.capas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping("/inicio")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView init1(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("ingresarCategoria");
		}else {
			categoriaService.save(categoria);
			mav.addObject("listado");
			mav.addObject("categoria", categoria);
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView init2(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Categoria> categorias = null;
		
		try {
			categorias = categoriaService.findAll();
		}catch(Exception e) {e.printStackTrace();}
		
		if(result.hasErrors()) {
			mav.addObject("categorias", categorias);
			mav.setViewName("ingresarLibro");
		}else {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			Date fecha = new Date();
			Date fech;
			String fechadif = format.format(fecha);
			try {
				fech = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(fechadif);
				libro.setFechaIngreso(fech);
				libroService.createDate(libro);
				mav.addObject("success", true);
			}catch(Exception e) {e.printStackTrace();}
			
			libroService.save(libro);
			mav.addObject("listado");
			mav.addObject("libro", libro);
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView init3() {
		ModelAndView mav = new ModelAndView();
		List<Libro>libros = null;
		
		try {
			libros = libroService.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("libros", libros);
		mav.setViewName("listado");
		
		return mav;
	}

}
