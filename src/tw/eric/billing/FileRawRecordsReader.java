package tw.eric.billing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRawRecordsReader implements RawRecordsReader {

	private final String filename;

	public FileRawRecordsReader(String filename) throws FileNotFoundException {
		this.filename = filename;
		if (!(new File(filename)).exists())
			throw new FileNotFoundException();
	}

	public List<RawRecord> getRecords()
	{
		File file = new File(filename);
		FileReader fileReader = null;
		List<RawRecord> retVal = new ArrayList<RawRecord>();
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return retVal;
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				List<String> parsedLine = CSVReader.parse(line);
				RawRecord rawRecord =
						new RawRecord(parsedLine.get(0), parsedLine.get(1), parsedLine.get(2), parsedLine.get(3), parsedLine.get(4), parsedLine.get(5));
				retVal.add(rawRecord);
			}
		} catch (IOException ex) {
			// TODO
		}
		return retVal;
	}
}
