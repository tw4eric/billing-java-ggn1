package tw.eric.billing;

import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	public static List<String> parse(String str)
	{
		if (str == null || str.equals(""))
			throw new IllegalArgumentException();
		
		List<String> retval = new ArrayList<String>();
		String[] values = str.split(",");
		for (String value : values) {
			retval.add(value);
		}
		return retval;
	}
}
