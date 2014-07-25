package tw.edu.kuas.mis.dontyr.D20140716;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class Main2 {

	public static void main(String[] args) {
		
		//--------- 登入
		HTTPConnection con = new HTTPConnection();
		HTTPRequestTag request = new HTTPRequestTag("http://140.127.113.227/kuas/perchk.jsp", HTTPMethod.POST);
		request.pushAttributes("uid", "1101137215");
		request.pushAttributes("pwd", "2119");
				
				
		HTTPResponseTag response = con.getResult(request, "utf-8");
		System.out.println(response.getResponse());
			
		
		//--------- 查詢
		
		HTTPRequestTag requestData = new HTTPRequestTag("http://140.127.113.227/kuas/system/sys001_00.jsp?spath=ag_pro/ag008.jsp?",HTTPMethod.POST);
		requestData.setCookies(response.getCookies());
		
		HTTPResponseTag responseStudentData = con.getResult(requestData, "utf-8");
		String temp = responseStudentData.getResponse();
		System.out.println(temp);
		
		
		
		
		HTTPRequestTag requestData2 = new HTTPRequestTag("http://140.127.113.227/kuas/ag_pro/ag008.jsp",HTTPMethod.POST);
		requestData2.setCookies(response.getCookies());
		requestData2.pushAttributes("yms", "102,2");
		requestData2.pushAttributes("spath", "ag_pro/ag008.jsp?");
		requestData2.pushAttributes("arg01", "102");
		requestData2.pushAttributes("arg02", "2");
		
		
		HTTPResponseTag responseStudentData2 = con.getResult(requestData2, "utf-8");
		String temp2 = responseStudentData2.getResponse();
		System.out.println(temp2);
		
		System.out.print("班級：");
		String a = temp2.split("班級：")[1];
		a = a.split("</td>")[0];
		System.out.println(a);
		
		System.out.print("英語聽講訓練(二)");
		String b = temp2.split("英語聽講訓練(二)")[1];
		b = b.split("</td>")[1];
		System.out.println(b);
		
		
		
		
		
		

	}

}
