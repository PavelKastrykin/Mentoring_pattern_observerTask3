package filedata;

import observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class DefaultFileData implements FileData {

	private Set<Observer> observers= new HashSet<>();

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObservers(FileDataContainerDTO dto) {
		observers.forEach(observer -> observer.update(dto));
	}
}
