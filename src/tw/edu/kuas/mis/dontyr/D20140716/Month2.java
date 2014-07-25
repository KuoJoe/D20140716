package tw.edu.kuas.mis.dontyr.D20140716;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Month2
 */
@WebServlet("/Month2")
public class Month2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Month2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();
		
		out.print("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'>"
				+ "<title>Insert title here</title></head><body>");
		
		int md[]={31,28,31,30,31,30,31,31,30,31,30,31};
		int c[]={5,1,1,4,6,2,4,0,3,5,1,3};
		int y= Integer.parseInt(request.getParameter("year"));
		int m= Integer.parseInt(request.getParameter("month"));
		int d=15;
		int w;
		w=(2+(y-1900)+((y-1900)/4)+c[m-1]+d)%7;
		int r=(y-1900)%4;
		
		out.print(String.format("%s年%s月",y,m));
		out.print("<table border=1>");
		out.print("<tr>");
		out.print("<td>日</td><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td>");
		out.print("</tr>");
		out.print("<tr>");
		int a=1;
		int b=0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(i==3 && j==6 && a<md[m-1])
				{
					i=i-1;
				}
				if(b<w)
				{
					out.print("<td>");
					out.print("</td>");
					b++;
				}
				

				
				else if(b>=w && a<=md[m-1] && m!=2)
				{
				out.print("<td>");
				out.print(a);
				out.print("</td>");
				a++;
				b++;
				}
				
				else if(a>md[m-1] && m!=2)
				{
					out.print("<td>");
					out.print("</td>");
					b++;
				}
				
				else if(b>=w && a<=md[1] && m==2 && r!=0)
				{
				out.print("<td>");
				out.print(a);
				out.print("</td>");
				a++;
				b++;
				}
				else if(a>md[1] && m==2 && r!=0)
				{
					out.print("<td>");
					out.print("</td>");
					b++;
				}
				
				else if(b>=w && a<=md[1]+1 && m==2 && r==0)
				{
				out.print("<td>");
				out.print(a);
				out.print("</td>");
				a++;
				b++;
				}
				else if(a>md[1]+1 && m==2 && r==0)
				{
					out.print("<td>");
					out.print("</td>");
					b++;
				}
				
				
				
			}
			out.print("</tr>");
		}
		out.print("</table");

		
		out.print("</body></html>");
	}

}
