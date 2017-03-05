package observer;

import filedata.FileDataContainerDTO;

public interface Observer {

	String getObserverName();

	void update(FileDataContainerDTO dto);

	Object getResult();
}
