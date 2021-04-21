package controller;

import media.Media;
import media.collection.MediaCollection;
import media.filters.Filter;

public class MediaController {
	private MediaCollection allMedias;

	public MediaController () {
		this.allMedias = new MediaCollection();
	}
	
	public MediaCollection getAll() {
		return this.allMedias;
	}
	
	public boolean add(Media m) {
		if(this.allMedias.indexOf(m) != -1) {
			return false;
		}
		this.allMedias.add(m);
		return true;
	}
	
	public boolean remove(Media m) {
		int index = this.allMedias.indexOf(m);
		if(index == -1) {
			return false;
		}
		this.allMedias.remove(index);
		return true;
	}
	
	public MediaCollection find(Filter f) {
		MediaCollection result = new MediaCollection();
		
		for(int i = 0; i< this.allMedias.size(); i++) {
			Media m = this.allMedias.get(i);
			if(f.filter(m)) {
				result.add(m);
			}
		}
		
		return result;
	}
}
