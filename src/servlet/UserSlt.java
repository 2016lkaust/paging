package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.UserService;
import bean.Page;
import dao.UserDao;

/**
 * Servlet implementation class UserSlt
 */
@WebServlet("/UserSlt")
public class UserSlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSlt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		UserService userService=new UserService();
		Page page=new Page(pageSize,pageNumber-1);
		List<Map<String, Object>>list=userService.queryUsers(page);
		System.out.println(list);
		Gson gson=new Gson();
		String lists=gson.toJson(list);
		out.print(lists);
	}

}
