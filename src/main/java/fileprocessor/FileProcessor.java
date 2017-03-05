package fileprocessor;

import filedata.FileData;
import filedata.FileDataContainerDTO;

import java.io.File;

public interface FileProcessor {

	void setFileData(FileData fileData);

	void processFile(String filePath);
}
