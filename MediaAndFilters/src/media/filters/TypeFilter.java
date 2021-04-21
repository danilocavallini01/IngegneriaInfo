package media.filters;

import media.Media;
import media.Type;

public class TypeFilter implements Filter{
	private Type typeToFind;

	public TypeFilter(Type typeToFind) {
		super();
		this.typeToFind = typeToFind;
	}

	public void setTypeToFind(Type typeToFind) {
		this.typeToFind = typeToFind;
	}
	
	public boolean filter(Media m) {
		if(m instanceof HasType) {
			HasType media = (HasType) m;
			return media.getType().equals(this.typeToFind);
		}
		return false;
	}
}
