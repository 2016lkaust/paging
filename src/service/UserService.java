package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Page;
import dao.UserDao;

public class UserService {
	public List<Map<String, Object>> queryUsers(Page page) {
		List<Map<String, Object>> list = new ArrayList<>();
		UserDao userDao = new UserDao();
		userDao.getConn();
		list = userDao.queryForList(page);
		userDao.closeConn();
		return list;
	}
}
