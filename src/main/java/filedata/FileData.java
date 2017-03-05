package filedata;

import observer.Observer;

public interface FileData {

	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers(FileDataContainerDTO dto);
}
