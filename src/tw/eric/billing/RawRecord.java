package tw.eric.billing;

public class RawRecord {

	public enum CallType { Local, STD, ISD };
	public enum Period   { Start, Continuation, End };
	
	private final String mobileNumber;
	private final long callId;
	private final CallType callType;
	private final long startTime;
	private final long endTime;
	private final Period period;
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public long getCallId() {
		return callId;
	}

	public long getStartTime() {
		return startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public CallType getCallType() {
		return callType;
	}

	public Period getPeriod() {
		return period;
	}

	public RawRecord(String mobileNumber,
			String callId,
			String callType,
			String startTime,
			String endTime,
			String period)
	{
		this(mobileNumber, Long.parseLong(callId), CallType.valueOf(callType),
				Long.parseLong(startTime), Long.parseLong(endTime), Period.valueOf(period));
	}
	
	public RawRecord(String mobileNumber,
			long callId,
			CallType callType,
			long startTime,
			long endTime,
			Period period)
	{
		this.mobileNumber = mobileNumber;
		this.callId = callId;
		this.callType = callType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.period = period;
	}

}
