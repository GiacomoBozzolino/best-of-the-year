package org.java.spring.controller;

import java.util.ArrayList;

import java.util.List;

import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MainController {
//	pagina principale
	@GetMapping("/")
	public String home(Model model) {
		final String name= "Giacomo";
		
		model.addAttribute("name", name);
        return "home";
	}
//	metodi per songs
	 private List<Song> getBestSongs(){
	        
	        List<Song> songs = new ArrayList<>();
	        
	        Song m1 = new Song(1, "Don’t Hate Me");
	        songs.add(m1);
	        
	        Song m2 = new Song(2, "Lil Boo Thang");
	        songs.add(m2);
	        
	        Song m3 = new Song(3, "Jealousy");
	        songs.add(m3);
	        
	        Song m4 = new Song(4, "Sorry Not Sorry");
	        songs.add(m4);
	        
	        Song m5 = new Song(5, "Not Strong Enough");
	        songs.add(m5);
	        
	        return songs;
	    }
	 
	 
	 @GetMapping("/songs")
	    public String songs(Model model) {
	        List<Song> songs = getBestSongs();
	        model.addAttribute("songs", songs);
	        return "songs";
	    }
	 
	 
	 
//	 metodi per movies
	 private List<Movie> getBestMovies(){
	        
	        List<Movie> movies = new ArrayList<>();
	        
	        Movie m1 = new Movie(1, "The First Slam Dunk");
	        movies.add(m1);
	        
	        Movie m2 = new Movie(2, "Past Lives");
	        movies.add(m2);
	        
	        Movie m3 = new Movie(3, "BlackBerry");
	        movies.add(m3);
	        
	        Movie m4 = new Movie(4, "Rye Lane");
	        movies.add(m4);
	        
	        Movie m5 = new Movie(5, "JoyLand");
	        movies.add(m5);
	        
	        return movies;
	        
	        
	    }
	 @GetMapping("/movies")
	    public String movies(Model model) {
	        List<Movie> movies = getBestMovies();
	        model.addAttribute("movies", movies);
	        return "movies";
	    }
	 
	 
//	 @GetMapping("/movies")
//	    public String movies(Model model, String movies) {
//	        
//	        movies = "";
//	        
//	        for (Movie m : getBestMovies()) {
//	            
//	            if(m.getId() < getBestMovies().size()) {
//	                
//	                movies += m.getTitolo() + ", ";
//	                
//	            } else {
//	                movies += m.getTitolo();
//	            }
//	        }
//	        
//	        model.addAttribute("movies", movies);
//	        
//	        return "movies";
//	    }
	 
	 
	 
//	 metodi passaggio id movie
	 @GetMapping("/movies/{id}")
		
		public String showMovie(Model model,
			  @PathVariable int id) {
		 List<Movie> movies = getBestMovies();
	        for (Movie m : movies) {
	            if(m.getId() == id) {
	                model.addAttribute("id", id);
	                model.addAttribute("movie", m);

	                return "show-movie";
	            }
	        }
	        return "Film non trovato";
		}
	 

	 
//	 metodi passaggio id song
	 @GetMapping("/songs/{id}")
		
		public String showSong(Model model, 
			  @PathVariable int id) {
		 for (Song s : getBestSongs()) {
	            
	            if(s.getId() == id) {
	            	model.addAttribute("id", id);
	            	model.addAttribute("song",s);
	            	return "show-song";
	            }
	            
	                     
	        }return "Canzone non trovata";
			
			
			
			
		}
	 
	 
	 

}
