package tw.edu.kuas.mis.dontyr.D20140716;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class Main {

	public static void main(String[] args) {
		
		//--------- 登入
		HTTPConnection con = new HTTPConnection();
		HTTPRequestTag request = new HTTPRequestTag("http://140.127.113.227/kuas/perchk.jsp", HTTPMethod.POST);
		request.pushAttributes("uid", "1101137215");
		request.pushAttributes("pwd", "2119");
		
		
		HTTPResponseTag response = con.getResult(request, "utf-8");
		System.out.println(response.getResponse());
		
		
		//--------- 查詢
		HTTPRequestTag requestData = new HTTPRequestTag("http://140.127.113.227/kuas/ag_pro/ag003.jsp", HTTPMethod.POST);
		requestData.setCookies(response.getCookies());
		
		HTTPResponseTag responseStudentData = con.getResult(requestData, "utf-8");
		String temp = responseStudentData.getResponse();
		
		System.out.print("學　　制：");
		String a = temp.split("學　　制：")[1];
		a = a.split("</td>")[0];
		System.out.println(a);
		
		System.out.print("科　　系：");
		String b = temp.split("科　　系：")[1];
		b = b.split("</td>")[0];
		System.out.println(b);
		
		System.out.print("班　　級：");
		String c = temp.split("班　　級：")[1];
		c = c.split("</td>")[0];
		System.out.println(c);
		
		System.out.print("學　　號：");
		String d = temp.split("學　　號：")[1];
		d = d.split("</td>")[0];
		System.out.println(c);
		
		System.out.print("姓　　名：");
		String e = temp.split("姓　　名：")[1];
		e = e.split("</td>")[0];
		System.out.println(e);
		
		System.out.print("英文姓名：");
		String f = temp.split("英文姓名：")[1];
		f = f.split("</td>")[0];
		System.out.println(f);
		
		System.out.print("出生日期：");
		String g = temp.split("出生日期：")[1];
		g = g.split("</td>")[0];
		System.out.println(g);
		
		System.out.print("出生地：");
		String h = temp.split("出生地：")[1];
		h = h.split("</td>")[0];
		System.out.println(h);
		
		System.out.print("性　　別：");
		String i = temp.split("性　　別：")[1];
		i = i.split("</td>")[0];
		System.out.println(i);
		
		System.out.print("服役紀錄：");
		String j = temp.split("服役紀錄：")[1];
		j = j.split("</td>")[0];
		System.out.println(j);
		
		System.out.print("身分證字號：");
		String k = temp.split("身分證字號：")[1];
		k = k.split("</td>")[0];
		System.out.println(k);
		
		System.out.print("在學狀態：");
		String l = temp.split("在學狀態：")[1];
		l = l.split("</td>")[0];
		System.out.println(l);
		
		System.out.print("家長姓名：");
		String m = temp.split("家長姓名：")[1];
		m = m.split("</td>")[0];
		System.out.println(m);
		
		System.out.print("與家長關係：");
		String n = temp.split("與家長關係：")[1];
		n = n.split("</td>")[0];
		System.out.println(n);
		
		System.out.print("戶籍地址：");
		String o = temp.split("戶籍地址：")[1];
		o = o.split("</td>")[0];
		System.out.println(o);
		
		System.out.print("通訊地址：");
		String p = temp.split("通訊地址：")[1];
		p = p.split("</td>")[0];
		System.out.println(p);
		
		System.out.print("入學前學歷：");
		String q = temp.split("入學前學歷：")[1];
		q = q.split("</td>")[0];
		System.out.println(q);
		
		System.out.print("聯絡電話:");
		String r = temp.split("聯絡電話:")[1];
		r = r.split("</td>")[0];
		System.out.println(r);
		
		System.out.println();
		
		System.out.println("說明:");
		System.out.println("1.請核對上列基本資料是否正確，用藍或紅筆在錯誤處下方填上正確資料並於簽名處簽名。");
		System.out.println("2.核對者簽名 : ___________________________");
		
		//System.out.println(temp);
		/*
		System.out.print("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'>"
				+ "<title>Insert title here</title></head><body>");
		System.out.print("<img src='http://140.127.113.227/kuas/stdpics/1101137215_20140717110558.jpg' height=180 width=140>");
		System.out.print("</body></html>");
		*/
	}

}
