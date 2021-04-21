package media;

import media.filters.HasType;

public abstract class Media implements HasType{
	private String title = null;
	private int year = -1;
	
	public Media(String title, int year) {
		super();
		this.title = title;
		this.year = year;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public abstract Type getType();
	
	public void setTitle(String title)  {
		this.title = title;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Media [title=" + title + ", year=" + year + "]";
	}
	
	public boolean equals(Object o) {
		if(o instanceof Media) {
			Media m = (Media) o;
			return this.title == m.title && this.year == m.year;
		}
		return false;
	}
}
