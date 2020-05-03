package api;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ActivityRecord {
	
	int id;
	String account;
	String activityName;
	String startTime;
	String endTime;
	String color;
	int noticeTime;
	
	
	public void setId(int id) {
		this.id = id;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setNoticeTime(int noticeTime) {
		this.noticeTime = noticeTime;
	}
	
	
	// get
	public int getId() {
		return id;
	}
	
	public String getAccount() {
		return account;
	}
	
	public String getActivityName() {
		return activityName;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getNoticeTime() {
		return noticeTime;
	}
	
	
	public static String convertToJson(ArrayList<ActivityRecord> allActivityData) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(allActivityData);
		System.out.println(jsonStr);
		return jsonStr;
	}

}
