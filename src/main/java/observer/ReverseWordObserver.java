package observer;

import filedata.FileDataContainerDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReverseWordObserver implements Observer {

	private static final String OBSERVER_NAME = "Reverse word observer";

	private List<String> reverseWords = new ArrayList<>();

	@Override
	public void update(FileDataContainerDTO dto) {
		reverseWords.addAll(dto.getReverseWords());
	}

	public List<String> getReverseWords() {
		return reverseWords;
	}

	@Override
	public Object getResult() {
		return getReverseWords();
	}

	@Override
	public String getObserverName() {
		return OBSERVER_NAME;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ReverseWordObserver that = (ReverseWordObserver) o;
		return Objects.equals(reverseWords, that.reverseWords);
	}

	@Override
	public int hashCode() {
		return Objects.hash(reverseWords);
	}
}
