package tw.edu.kuas.mis.dontyr.D20140716;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class FbHello {

	public static void main(String[] args) {
		
		HTTPConnection con = new HTTPConnection();
		HTTPRequestTag request = new HTTPRequestTag("https://graph.facebook.com/me/feed", HTTPMethod.GET);
		request.pushAttributes("access_token", "CAACEdEose0cBAHZCx2Y58IT16ENGw381ZAQ1ERxq4CC3QgZBzD3ZAJM1BATrKr8eOAzBL8nvoKO2tmFQBbGyqSE6JHrdbwDtYCg7QpMS2z5BVPoOE0nSlZBxs0B5MCCR2PiD3Kh12ZBSUZCtOMT0d8mDJH9U6Ib7AZAwv9Te1zjASdcS6nnGWzT4ZAOdzqkJNRaNZCHIYRm5aLJhpT7XuBqBtWvQNhlcBsxSEZD");

		
		
		
		HTTPResponseTag response = con.getResult(request, "utf-8");
	
		
		//System.out.println(response.getResponse());
		
		try {
			
		JSONObject jo = new JSONObject(response.getResponse());
		System.out.println(jo.toString());
			
		
		JSONArray data = jo.getJSONArray("data");
		System.out.println(data.toString());
		
		for(int i=0;i<data.length();i++)
		{
			JSONObject ot = data.getJSONObject(i);
			if(ot.getString("message").equals("FF"))
				System.out.println(ot.getString("id"));
			
			if(ot.getString("message").equals("°ª¶¯"))
			{
				HTTPRequestTag request2 = new HTTPRequestTag(String.format("https://graph.facebook.com/%s/comments", ot.getString("id")), HTTPMethod.POST);
				request2.pushAttributes("access_token", "CAACEdEose0cBAHZCx2Y58IT16ENGw381ZAQ1ERxq4CC3QgZBzD3ZAJM1BATrKr8eOAzBL8nvoKO2tmFQBbGyqSE6JHrdbwDtYCg7QpMS2z5BVPoOE0nSlZBxs0B5MCCR2PiD3Kh12ZBSUZCtOMT0d8mDJH9U6Ib7AZAwv9Te1zjASdcS6nnGWzT4ZAOdzqkJNRaNZCHIYRm5aLJhpT7XuBqBtWvQNhlcBsxSEZD");
				request2.pushAttributes("message", "test");
				HTTPResponseTag response2 = con.getResult(request2, "utf-8");

			}
			
		}
		
		
		
		//JSONObject to = jo.getJSONObject("to");
		//System.out.println(to.toString());
		
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
