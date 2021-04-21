package media.filters;

import media.Media;

public class GenreFilter implements Filter{
	private String genre;
	
	public boolean filter(Media media) {
		if(media instanceof HasGenre) {
			HasGenre gr = (HasGenre) media; 
			return this.genre == " " || gr.getGenre().equals(this.genre);
		}
		return false;
	}

	public GenreFilter(String genre) {
		this.genre = genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
