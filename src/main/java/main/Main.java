package main;

import filedata.DefaultFileData;
import filedata.FileData;
import fileprocessor.DefaultFileProcessor;
import fileprocessor.FileProcessor;
import observer.LongestWordObserver;
import observer.Observer;
import observer.ReverseWordObserver;
import observer.WordCountObserver;

public class Main {
	public static void main(String[] args) {
		//Given
		String filePath = "SampleText.txt";
		Observer longestObserver = new LongestWordObserver();
		Observer reverseObserver = new ReverseWordObserver();
		Observer countObserver = new WordCountObserver();

		FileData fileData = new DefaultFileData();
		fileData.registerObserver(longestObserver);
		fileData.registerObserver(reverseObserver);
		fileData.registerObserver(countObserver);

		FileProcessor fileProcessor = new DefaultFileProcessor();
		fileProcessor.setFileData(fileData);

		//When
		fileProcessor.processFile(filePath);

		//Then
		//System.out.println(longestObserver.getResult());
		//System.out.println(reverseObserver.getResult());
		//System.out.println(countObserver.getResult());
	}
}
