package tw.edu.kuas.mis.dontyr.D20140716;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class Main {

	public static void main(String[] args) {
		
		//--------- �n�J
		HTTPConnection con = new HTTPConnection();
		HTTPRequestTag request = new HTTPRequestTag("http://140.127.113.227/kuas/perchk.jsp", HTTPMethod.POST);
		request.pushAttributes("uid", "1101137215");
		request.pushAttributes("pwd", "2119");
		
		
		HTTPResponseTag response = con.getResult(request, "utf-8");
		System.out.println(response.getResponse());
		
		
		//--------- �d��
		HTTPRequestTag requestData = new HTTPRequestTag("http://140.127.113.227/kuas/ag_pro/ag003.jsp", HTTPMethod.POST);
		requestData.setCookies(response.getCookies());
		
		HTTPResponseTag responseStudentData = con.getResult(requestData, "utf-8");
		String temp = responseStudentData.getResponse();
		
		System.out.print("�ǡ@�@��G");
		String a = temp.split("�ǡ@�@��G")[1];
		a = a.split("</td>")[0];
		System.out.println(a);
		
		System.out.print("��@�@�t�G");
		String b = temp.split("��@�@�t�G")[1];
		b = b.split("</td>")[0];
		System.out.println(b);
		
		System.out.print("�Z�@�@�šG");
		String c = temp.split("�Z�@�@�šG")[1];
		c = c.split("</td>")[0];
		System.out.println(c);
		
		System.out.print("�ǡ@�@���G");
		String d = temp.split("�ǡ@�@���G")[1];
		d = d.split("</td>")[0];
		System.out.println(c);
		
		System.out.print("�m�@�@�W�G");
		String e = temp.split("�m�@�@�W�G")[1];
		e = e.split("</td>")[0];
		System.out.println(e);
		
		System.out.print("�^��m�W�G");
		String f = temp.split("�^��m�W�G")[1];
		f = f.split("</td>")[0];
		System.out.println(f);
		
		System.out.print("�X�ͤ���G");
		String g = temp.split("�X�ͤ���G")[1];
		g = g.split("</td>")[0];
		System.out.println(g);
		
		System.out.print("�X�ͦa�G");
		String h = temp.split("�X�ͦa�G")[1];
		h = h.split("</td>")[0];
		System.out.println(h);
		
		System.out.print("�ʡ@�@�O�G");
		String i = temp.split("�ʡ@�@�O�G")[1];
		i = i.split("</td>")[0];
		System.out.println(i);
		
		System.out.print("�A�Ь����G");
		String j = temp.split("�A�Ь����G")[1];
		j = j.split("</td>")[0];
		System.out.println(j);
		
		System.out.print("�����Ҧr���G");
		String k = temp.split("�����Ҧr���G")[1];
		k = k.split("</td>")[0];
		System.out.println(k);
		
		System.out.print("�b�Ǫ��A�G");
		String l = temp.split("�b�Ǫ��A�G")[1];
		l = l.split("</td>")[0];
		System.out.println(l);
		
		System.out.print("�a���m�W�G");
		String m = temp.split("�a���m�W�G")[1];
		m = m.split("</td>")[0];
		System.out.println(m);
		
		System.out.print("�P�a�����Y�G");
		String n = temp.split("�P�a�����Y�G")[1];
		n = n.split("</td>")[0];
		System.out.println(n);
		
		System.out.print("���y�a�}�G");
		String o = temp.split("���y�a�}�G")[1];
		o = o.split("</td>")[0];
		System.out.println(o);
		
		System.out.print("�q�T�a�}�G");
		String p = temp.split("�q�T�a�}�G")[1];
		p = p.split("</td>")[0];
		System.out.println(p);
		
		System.out.print("�J�ǫe�Ǿ��G");
		String q = temp.split("�J�ǫe�Ǿ��G")[1];
		q = q.split("</td>")[0];
		System.out.println(q);
		
		System.out.print("�p���q��:");
		String r = temp.split("�p���q��:")[1];
		r = r.split("</td>")[0];
		System.out.println(r);
		
		System.out.println();
		
		System.out.println("����:");
		System.out.println("1.�Юֹ�W�C�򥻸�ƬO�_���T�A���ũά����b���~�B�U���W���T��ƨé�ñ�W�Bñ�W�C");
		System.out.println("2.�ֹ��ñ�W : ___________________________");
		
		//System.out.println(temp);
		/*
		System.out.print("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'>"
				+ "<title>Insert title here</title></head><body>");
		System.out.print("<img src='http://140.127.113.227/kuas/stdpics/1101137215_20140717110558.jpg' height=180 width=140>");
		System.out.print("</body></html>");
		*/
	}

}
