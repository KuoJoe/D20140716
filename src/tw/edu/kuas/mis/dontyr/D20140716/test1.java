package tw.edu.kuas.mis.dontyr.D20140716;

import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.json.HTTP;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class test1 {

	public static void main(String[] args) throws JSONException {
		
		HTTPConnection con = new HTTPConnection();		
		HTTPRequestTag request = new HTTPRequestTag("https://graph.facebook.com/me/feed",HTTPMethod.GET); 
		request.pushAttributes("access_token", "CAACEdEose0cBAOhdjDaLr2Pc2ldqmF6zdqOYx7FUjjEmb5h4ZCN7x2fXaBgRobUZCQxA9QcZAGVrZBToqCCMKnEx42JdZBAgQm9eacoZAuLi2fZBCLhNa2MTZBJGlmQ34Aqi6x3ZCyNLfiiPxFTtwtQSks0QKxZATXkF2CutcRRmttqrXZCrQe7Ozb22Aoz9gmXZC0YcDW5o6oiZCf824cGVJzRgrXYAvZAhC5cNYZD");

		HTTPResponseTag response = con.getResult(request, "utf-8");
			
		
		JSONObject jo = new JSONObject(response.getResponse());
		JSONArray data = jo.getJSONArray("data");
		System.out.println(data.toString());
			
		
		try {
			
			for(int i=0;i<data.length();i++){
				
				JSONObject temp=data.getJSONObject(i);
					
				HTTPRequestTag requestm1 = new HTTPRequestTag(String.format("https://graph.facebook.com/%s", temp.getString("id")),HTTPMethod.GET); 
				requestm1.pushAttributes("access_token", "CAACEdEose0cBAOhdjDaLr2Pc2ldqmF6zdqOYx7FUjjEmb5h4ZCN7x2fXaBgRobUZCQxA9QcZAGVrZBToqCCMKnEx42JdZBAgQm9eacoZAuLi2fZBCLhNa2MTZBJGlmQ34Aqi6x3ZCyNLfiiPxFTtwtQSks0QKxZATXkF2CutcRRmttqrXZCrQe7Ozb22Aoz9gmXZC0YcDW5o6oiZCf824cGVJzRgrXYAvZAhC5cNYZD");
				
				HTTPResponseTag responsem1 = con.getResult(requestm1, "utf-8");
				
				
				JSONObject jo1 = new JSONObject(responsem1.getResponse());

				String area=jo1.getString("message");
				//System.out.println(area);
				area=area.substring(0,3);
				
				
				
				//System.out.println(jo1.getString("id"));
				//System.out.println(jo1.getString("message"));
				//System.out.println(area);
				
				
				//
				//  停課資料
				//
				
				
				HTTPRequestTag request2 = new HTTPRequestTag("http://www.dgpa.gov.tw/",HTTPMethod.GET); 
				HTTPResponseTag response2 = con.getResult(request2, "utf-8");
				JSONObject jo2 = HTTP.toJSONObject(response2.getResponse());
				
				
				
				String temp2= response2.getResponse();
				//System.out.println(temp2);
				
				temp2 = temp2.split(String.format("size=2>%s", area))[1];
				temp2 = temp2.split("<FONT color=#000080 size=2>")[1];
				temp2 = temp2.split("</FONT>")[0];
				
				System.out.println(temp2);
				
				//
				//  回覆留言
				//
				
				HTTPRequestTag reques3 = new HTTPRequestTag(String.format("https://graph.facebook.com/%s/comments", jo1.getString("id")),HTTPMethod.POST); 
				reques3.pushAttributes("access_token", "CAACEdEose0cBAOhdjDaLr2Pc2ldqmF6zdqOYx7FUjjEmb5h4ZCN7x2fXaBgRobUZCQxA9QcZAGVrZBToqCCMKnEx42JdZBAgQm9eacoZAuLi2fZBCLhNa2MTZBJGlmQ34Aqi6x3ZCyNLfiiPxFTtwtQSks0QKxZATXkF2CutcRRmttqrXZCrQe7Ozb22Aoz9gmXZC0YcDW5o6oiZCf824cGVJzRgrXYAvZAhC5cNYZD");
				reques3.pushAttributes("message",temp2.toString());
				HTTPResponseTag respons3 = con.getResult(reques3, "utf-8");
					
				System.out.println(respons3.getResponse());
				
				
				
				
				
			}

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
