package filedata;

import java.util.List;

public class FileDataContainerDTO {

	private String longestWord;
	private int wordCount;
	private List<String> reverseWords;

	public String getLongestWord()
	{
		return longestWord;
	}

	public void setLongestWord(String longestWord)
	{
		this.longestWord = longestWord;
	}

	public int getWordCount()
	{
		return wordCount;
	}

	public void setWordCount(int wordCount)
	{
		this.wordCount = wordCount;
	}

	public List<String> getReverseWords()
	{
		return reverseWords;
	}

	public void setReverseWords(List<String> reverseWords)
	{
		this.reverseWords = reverseWords;
	}
}
