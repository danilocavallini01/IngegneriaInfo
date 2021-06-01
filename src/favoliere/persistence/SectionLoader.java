package favoliere.persistence;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public interface SectionLoader<E> {
	List<E> getItems();
	void loadAllItems(Reader baseReader) throws IOException, BadFileFormatException;
}
