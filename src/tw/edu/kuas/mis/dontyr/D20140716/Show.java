package tw.edu.kuas.mis.dontyr.D20140716;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class Show {

	public static void main(String[] args) {
		
		HTTPConnection con = new HTTPConnection();
		HTTPRequestTag request = new HTTPRequestTag("http://opendata.khcc.gov.tw/public/OD_art_program.ashx?SDate=2013/08/26&EDate=2014/02/26", HTTPMethod.POST);
		
		HTTPResponseTag responseShow = con.getResult(request, "utf-8");
		String temp = responseShow.getResponse();
		//System.out.println(temp);
		
		
		try {
			
			JSONArray jo = new JSONArray(responseShow.getResponse());
			System.out.print(jo.toString());
			
			
			for(int i=0;i<jo.length();i++)
			{
				JSONObject ot = jo.getJSONObject(i);
				System.out.print(ot.getString("PRGNAME"));
				System.out.print("  ");
				System.out.print(ot.getString("PRGACT"));
				System.out.print("  ");
				System.out.println(ot.getString("PRGPLACE"));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
