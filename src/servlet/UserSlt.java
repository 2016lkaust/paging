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

import service.UserService;
import bean.PageObject;

import com.google.gson.Gson;

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
		UserService userService=new UserService();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		//获取参数
		String page = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		
		PageObject pageObj = new PageObject(page,pageSize);
		
		List<Map<String, Object>>list=userService.queryUsers(pageObj);
		Gson gson=new Gson();
		String lists=gson.toJson(list);
		out.print(lists);
	}

}
