package tw.edu.kuas.mis.dontyr.D20140716;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class FbInbox {

	public static void main(String[] args) {
		
		HTTPConnection con = new HTTPConnection();
		HTTPRequestTag request = new HTTPRequestTag("https://graph.facebook.com/me/inbox", HTTPMethod.GET);
		request.pushAttributes("access_token", "CAACEdEose0cBAJgMsNrCFbfnlEXy40G87rtLRCNk9eGo8ZAtSoVdmqKxEZAohVu8fpSqoDtJvaNLuUZCwZA7NdCpX9HSmQvvrUEYmg2r6bT4cZCEWAYcZC1QKqOT2aBnnrwU3oqW7EOtpZCggu5gQeJIWm7RZBQNNjJMFVDmAgaFcyyclooiTCaYNu7eIwCdYDBjL37lXZApvSfANyhCERChvPehWyleekcEZD");

		HTTPResponseTag response = con.getResult(request, "utf-8");
	
		
		//System.out.println(response.getResponse());
		
		try {
			
		JSONObject jo = new JSONObject(response.getResponse());
		System.out.println(jo.toString());
			
			
		JSONObject summary = jo.getJSONObject("summary");
			
		//System.out.println(summary.toString());
		
		JSONArray data = jo.getJSONArray("data");
		
		System.out.println(data.toString());
		
		JSONObject to = jo.getJSONObject("to");
		//System.out.println(to.toString());
		
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
