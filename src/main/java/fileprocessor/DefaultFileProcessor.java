package fileprocessor;

import filedata.DefaultFileData;
import filedata.FileData;
import filedata.FileDataContainerDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefaultFileProcessor implements FileProcessor {

	private FileData fileData = new DefaultFileData();

	@Override
	public void setFileData(FileData fileData) {
		this.fileData = fileData;
	}

	@Override
	public void processFile(String filePath) {
		Scanner scanner = null;
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			scanner = new Scanner(new File(classloader.getResource(filePath).getFile()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			processNextLine(nextLine);
		}
		scanner.close();
	}

	private void processNextLine(String line) {
		List<String> lineAsWords = new ArrayList<>();

		Scanner scanner = new Scanner(line);
		while (scanner.hasNext()) {
			String s = scanner.next();
			lineAsWords.add(s);
		}

		FileDataContainerDTO dto = createDto(lineAsWords);
		fileData.notifyObservers(dto);
	}

	private FileDataContainerDTO createDto(List<String> words) {
		FileDataContainerDTO dto = new FileDataContainerDTO();
		dto.setWordCount(words.size());
		dto.setLongestWord(defineLongestWord(words));
		dto.setReverseWords(reverseWords(words));
		return dto;
	}

	private String defineLongestWord(List<String> words) {
		String longestWord = "";
		for (String word : words) {
			if (word.length() > longestWord.length()) {
				longestWord = word;
			}
		}
		return longestWord;
	}

	private List<String> reverseWords(List<String> words) {
		List<String> reverseWords = new ArrayList<>();
		for (String word : words) {
			reverseWords.add(new StringBuilder(word).reverse().toString());
		}
		return reverseWords;
	}
}
