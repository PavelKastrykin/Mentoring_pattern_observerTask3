package observer;

import filedata.FileDataContainerDTO;

import java.util.Objects;

public class LongestWordObserver implements Observer {

	private static final String OBSERVER_NAME = "Longest word observer";

	private String longestWord = "";

	@Override
	public void update(FileDataContainerDTO dto) {
		String dtoWord = dto.getLongestWord();
		if (dtoWord.length() > longestWord.length()) {
			longestWord = dtoWord;
		}
	}

	@Override
	public Object getResult() {
		return getLongestWord();
	}

	public String getLongestWord() {
		return longestWord;
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
		LongestWordObserver that = (LongestWordObserver) o;
		return Objects.equals(longestWord, that.longestWord);
	}

	@Override
	public int hashCode() {
		return Objects.hash(longestWord);
	}
}
