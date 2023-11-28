package org.java.spring.pojo;

public class Movie {
	private String titolo;
	private int id;
	
	
public Movie( int id, String titolo) {
	// TODO Auto-generated constructor stub
	setId(id);
	setTitolo(titolo);
}


public String getTitolo() {
	return titolo;
}


public void setTitolo(String titolo) {
	this.titolo = titolo;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}	

}
