package tw.eric.billing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileRawRecordsReader implements RawRecordsReader {
	
	public FileRawRecordsReader(String filename) throws FileNotFoundException {
		File file = new File(filename);
		if (!file.exists())
			throw new FileNotFoundException();
	}
	
	public List<RawRecord> getRecords()
	{
		List<RawRecord> retVal = new ArrayList<RawRecord>();
		return retVal;
	}
}
