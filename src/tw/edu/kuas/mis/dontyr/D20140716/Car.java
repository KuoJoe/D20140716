package tw.edu.kuas.mis.dontyr.D20140716;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class Car {

	public static void main(String[] args) {
		
		HTTPConnection con = new HTTPConnection();
		HTTPRequestTag request = new HTTPRequestTag("http://xml11.kctmc.nat.gov.tw:8080/xmldata/Parking.xml", HTTPMethod.POST);
		
		HTTPResponseTag responseCar = con.getResult(request, "utf-8");
		//String temp = responseCar.getResponse();
		//System.out.println(temp);
		
		try {
			
			JSONObject jo =XML.toJSONObject(responseCar.getResponse());
			
			JSONObject NewDataSet = jo.getJSONObject("NewDataSet");
			JSONArray Data = NewDataSet.getJSONArray("Data");
			
			System.out.println(Data.toString());
			
			for(int i=0;i<Data.length();i++)
			{
				JSONObject ot = Data.getJSONObject(i);
				System.out.print(ot.getString("NAME"));
				System.out.print("  ");
				System.out.print(ot.getString("AREA"));
				System.out.print("  ");
				System.out.println(ot.getString("PRICE"));
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
