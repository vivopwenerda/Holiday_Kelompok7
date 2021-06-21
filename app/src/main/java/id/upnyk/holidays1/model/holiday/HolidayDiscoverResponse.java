package id.upnyk.holidays1.model.holiday;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class HolidayDiscoverResponse{

	@SerializedName("holidays")
	private ArrayList<HolidaysItem> holidays;

	@SerializedName("warning")
	private String warning;

	@SerializedName("requests")
	private Requests requests;

	@SerializedName("status")
	private int status;

	public void setHolidays(ArrayList<HolidaysItem> holidays){
		this.holidays = holidays;
	}

	public ArrayList<HolidaysItem> getHolidays(){
		return holidays;
	}

	public void setWarning(String warning){
		this.warning = warning;
	}

	public String getWarning(){
		return warning;
	}

	public void setRequests(Requests requests){
		this.requests = requests;
	}

	public Requests getRequests(){
		return requests;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"HolidayDiscoverResponse{" + 
			"holidays = '" + holidays + '\'' + 
			",warning = '" + warning + '\'' + 
			",requests = '" + requests + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}