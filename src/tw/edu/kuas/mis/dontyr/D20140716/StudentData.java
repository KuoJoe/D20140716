package tw.edu.kuas.mis.dontyr.D20140716;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class StudentData {

	public static void main(String[] args) {
		//--------- µn¤J
		HTTPConnection con = new HTTPConnection();
		HTTPRequestTag request = new HTTPRequestTag("http://140.127.113.227/kuas/perchk.jsp", HTTPMethod.POST);
		request.pushAttributes("uid", "1101137215");
		request.pushAttributes("pwd", "2119");
						
						
		HTTPResponseTag response = con.getResult(request, "utf-8");
		System.out.println(response.getResponse());
					
		
		
		
		//--------- ¬d¸ß
		
		HTTPRequestTag requestData = new HTTPRequestTag("http://140.127.113.227/kuas/ag_pro/ag007_rpt.jsp HTTP/1.1",HTTPMethod.POST);
		requestData.setCookies(response.getCookies());
		requestData.pushAttributes("year", "102");
		requestData.pushAttributes("sms", "2");
		requestData.pushAttributes("std_id", "1101137243");
		
		
		
		HTTPResponseTag responseStudentData = con.getResult(requestData, "utf-8");
		String temp = responseStudentData.getResponse();
		System.out.println(temp);

	}

}
