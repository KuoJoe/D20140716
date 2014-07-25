package tw.edu.kuas.mis.dontyr.D20140716;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class FbRE {

	public static void main(String[] args) {
		
		HTTPConnection con = new HTTPConnection();
		HTTPRequestTag request = new HTTPRequestTag("https://graph.facebook.com/100000706989113_822674524432773/comments", HTTPMethod.POST);
		request.pushAttributes("access_token", "CAACEdEose0cBAHd6nkxEhqfEGbztyogI2kOvHd6Uk2JjSZAb546NFwfOVCddi3nKdmZAj3BCkSF0jMem7b78xMrCqTGC1O0LZB7r2asH3zGsKKzlcISP4LEpjboZADjL1qoahraIV5sjjgZAXi2uMgR9MJgVuPVVHISvzeGYq9R3vAQZCTSxcDFbyUGjH1NDp4q6SBumvpVpNvW0VG5GLRYnurme7VKPUZD");
		request.pushAttributes("message", "test");
		HTTPResponseTag response = con.getResult(request, "utf-8");
	
		
		//System.out.println(response.getResponse());
		
		try {
			
		JSONObject jo = new JSONObject(response.getResponse());
		System.out.println(jo.toString());
			
		
		
		
		
		
		
		//JSONObject to = jo.getJSONObject("to");
		//System.out.println(to.toString());
		
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
