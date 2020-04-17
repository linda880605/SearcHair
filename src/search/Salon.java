package search;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Salon {
	String name,address,phone,picture,businessTime;
	ArrayList<StylistInfo> stylist_info = new ArrayList<StylistInfo>(); 

    public void set_Name(String name) {
    	this.name = name;
	}
    
    public void set_Address(String address) {
    	this.address = address;
	}
    
    public void set_Phone(String phone) {
    	this.phone = phone;
	}
    public void set_Picture(String picture) {
    	this.picture = picture;
	}
    
    public void set_BusinessTime(String businessTime) {
    	this.businessTime = businessTime;
	}
    
    public void set_Stylist_info(ArrayList<StylistInfo> stylist_info) {
    	this.stylist_info = stylist_info;
	}  
    
    public static String convertToJson(Salon Item) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(Item);
		return jsonStr;
	}
}