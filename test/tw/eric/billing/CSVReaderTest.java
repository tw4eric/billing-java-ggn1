package tw.eric.billing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CSVReaderTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForEmptyString() {
		CSVReader.parse("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForNullString() {
		CSVReader.parse(null);
	}

	@Test
	public void shouldReturnASimpleNonCSVLineAsIs() {
		List<String> retval = CSVReader.parse("abc");
		assertEquals(1, retval.size());
		assertEquals("abc", retval.get(0));
	}
	
	@Test
	public void shouldParseAndReturnAListOfAppropriateSize() {
		List<String> retval = CSVReader.parse("abc,def");
		assertEquals(2, retval.size());
		retval = CSVReader.parse("abc, def,  ghi  ,jkl,xyz");
		assertEquals(5, retval.size());
	}
	
	@Test
	public void shouldReturnCorrectValuesOnParse() {
		List<String> retval = CSVReader.parse("abc, def,  ghi  ,jkl,xyz");
		assertEquals("abc", retval.get(0));
		assertEquals(" def", retval.get(1));
		assertEquals("  ghi  ", retval.get(2));
		assertEquals("jkl", retval.get(3));
		assertEquals("xyz", retval.get(4));
	}
	
}
