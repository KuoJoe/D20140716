package tw.edu.kuas.mis.dontyr.D20140716;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class Bus {

	public static void main(String[] args) {
		HTTPConnection con = new HTTPConnection();
		HTTPRequestTag request = new HTTPRequestTag("http://122.146.229.210/xmlbus2/GetEstimateTime.xml?routeIds=0%E5%8C%97,1", HTTPMethod.POST);
		
		HTTPResponseTag responseBus = con.getResult(request, "utf-8");
		//String temp2 = responseBus.getResponse();
		//System.out.println(temp2);
		
		
		try {
			JSONObject jo =XML.toJSONObject(responseBus.getResponse());
			JSONObject BusDynInfo =jo.getJSONObject("BusDynInfo");
			JSONObject Route = BusDynInfo.getJSONObject("BusInfo");
			JSONObject EstimateTime = Route.getJSONObject("Route");
			JSONArray carArray = EstimateTime.getJSONArray("EstimateTime");
			
			System.out.println(carArray.toString());
			
			for(int i=0;i<carArray.length();i++)
			{
				JSONObject tamp = carArray.getJSONObject(i);
				System.out.print(tamp.getString("StopName"));
				System.out.println(tamp.getString("comeTime"));
				
			}
			
			
			
			
		} catch (Exception e) {
			
		}
		
		
		
		
		
		
		
		
		/*
		System.out.print("站牌名稱：");
		String a = temp.split("StopName=")[1];
		a = a.split("GoBack=")[0];
		System.out.print(a);

		System.out.print("站牌代碼：");
		String b = temp.split("StopID=")[1];
		b = b.split("StopName=")[0];
		System.out.print(b);
		
		System.out.print("預計到站時間：");
		String c = temp.split("comeTime=")[1];
		c = c.split("IVRNO=")[0];
		System.out.print(c);
		*/
	}

}
