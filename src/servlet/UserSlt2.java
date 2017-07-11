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
@WebServlet("/UserSlt2")
public class UserSlt2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSlt2() {
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
		String page = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		if (page == null || "".equals(page))
			page = "1";
		if (pageSize == null || "".equals(pageSize))
			pageSize = "10";
		int page1 = Integer.parseInt(page);
		int pageSize1 = Integer.parseInt(pageSize);
		PageObject pageObj = new PageObject();
		pageObj.setPage((page1-1)*pageSize1);
		pageObj.setPageSize(pageSize1);
		List<Map<String, Object>>list=userService.queryUsers(pageObj);
		Gson gson=new Gson();
		String lists=gson.toJson(list);
		System.out.println(lists);
		out.print(lists);
	}

}