package tw.eric.billing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

public class FileRawRecordsReaderTest {

	@Test(expected = FileNotFoundException.class)
	public void shouldThrowFileNotFoundExceptionForNonExistentFile()
			throws FileNotFoundException {
		new FileRawRecordsReader("askdjkskjf;sdfdfjksdfj-we-  wjjksdsfj");
	}
	
	@Test
	public void shouldReturnEmptyRecordsListForEmptyFile() throws FileNotFoundException {
		FileRawRecordsReader rawRecordsReader = new FileRawRecordsReader("empty.csv");
		List<RawRecord> rawRecords = rawRecordsReader.getRecords();
		assertEquals(0, rawRecords.size());
	}
	
	@Test
	public void shouldReturnOneRecordForOneEntryInFile() throws FileNotFoundException {
		FileRawRecordsReader rawRecordsReader = new FileRawRecordsReader("oneentry.csv");
		List<RawRecord> rawRecords = rawRecordsReader.getRecords();
		assertEquals(1, rawRecords.size());
	}

}
