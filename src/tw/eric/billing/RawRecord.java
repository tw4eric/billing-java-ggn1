package tw.eric.billing;

public class RawRecord {
	private String mobileNumber;
	private long callId;
	public enum CallType{Local,STD,ISD};
	private long startTime;
	private long endTime;
	public enum Period{Start,Continuation,End};
	
	public RawRecord(String mobileNumber,long callId,CallType callType,long startTime,long endTime,Period period)
	{
		
	}



}
