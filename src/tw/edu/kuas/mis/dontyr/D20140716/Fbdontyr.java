package tw.edu.kuas.mis.dontyr.D20140716;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class Fbdontyr {
	
	public static void main(String[] args) {

	HTTPConnection con = new HTTPConnection();
	HTTPRequestTag request = new HTTPRequestTag("https://graph.facebook.com/100000706989113_820604107973148/", HTTPMethod.GET);
	request.pushAttributes("access_token", "CAACEdEose0cBAGOxlbdhxGIWu65OS8mUhc2USZAhdvDNhAfqlDfX7f2ZAu5OgrdwTjbtvBTrj3RLsg0ioKcCd3LasZAL185ZCozj9cHCSNCL80GDsSwMGzDnZAeYEYkPibHudYqCOZB3I3nFCDBCyZBbg8F8WfaHhDrZAhtOzQ2bI8rqSgZA9TBbXQpy6v69pyPKJMNR1OM5SGvrpbtBcBeZBWEAgWlz7OYSYZD");
	
	HTTPResponseTag response = con.getResult(request, "utf-8");
	
	System.out.println(response.getResponse());
	try {
		
		JSONObject jo = new JSONObject(response.getResponse());
		System.out.println(jo.toString());
		
		JSONArray data = jo.getJSONArray("data");
		
		//System.out.println(data.toString());
		
		
		
		
		/*
		for(int i=0;i<data.length();i++)
		{
			JSONObject ot = data.getJSONObject(i);
			System.out.println(ot.getString("name"));
		}
		*/
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	
	}
}
