package observer;

import filedata.FileDataContainerDTO;

import java.util.Objects;

public class WordCountObserver implements Observer {

	private static final String OBSERVER_NAME = "Word count observer";

	private int wordCount;

	@Override
	public void update(FileDataContainerDTO dto) {
		wordCount = wordCount + dto.getWordCount();
	}

	@Override
	public Object getResult() {
		return getWordCount();
	}

	public int getWordCount() {
		return wordCount;
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
		WordCountObserver that = (WordCountObserver) o;
		return wordCount == that.wordCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(wordCount);
	}
}
