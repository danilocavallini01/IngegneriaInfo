package media.filters;

import media.Media;

public class DurationFilter implements Filter{
	private int duration;
	
	public DurationFilter(int duration) {
		this.duration = duration;
	}
	
	public boolean filter(Media media) {
		if(media instanceof HasDuration) {
			HasDuration dr = (HasDuration) media; 
			return this.duration == 0 || dr.getDuration() <= this.duration;
		} 
		return false;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
