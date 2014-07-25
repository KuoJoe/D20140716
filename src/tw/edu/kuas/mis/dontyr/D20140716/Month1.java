package tw.edu.kuas.mis.dontyr.D20140716;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Month1
 */
@WebServlet("/Month1")
public class Month1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Month1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();
		
		String idd = request.getSession().getAttribute("id").toString();
		out.print(idd);
		
		if(idd.equals("123") )
		{
		
		out.print("<form action=Month2 method=post>");
		out.print("請輸入年分<input type=text name=year></br>");
		out.print("請輸入月分<input type=text name=month>");
		out.print("<input type=submit value=送出>");
		out.print("</form>");
		
		}
		else
		{
			out.print("給我回去登入");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();
		
	}

}
