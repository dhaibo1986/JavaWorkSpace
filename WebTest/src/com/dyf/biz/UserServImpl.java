package com.dyf.biz;

import java.util.ArrayList;
import java.util.List;

import com.dyf.dao.IUserDao;
import com.dyf.domain.PageBean;
import com.dyf.domain.UserBean;
import com.dyf.util.DaoFactory;

public class UserServImpl implements IUserServ {
	private IUserDao dao = DaoFactory.getUserDao();

	public boolean check(UserBean userBean) throws Exception {
		boolean res = false;
		res = dao.checkUser(userBean).size() > 0;
		return res;
	}

	public List<UserBean> getAllByPage(PageBean pageBean) throws Exception {
		UserBean userBean = new UserBean();
		List<UserBean> res = new ArrayList<UserBean>();
		if (pageBean.getPageNum() < 1) {
			pageBean.setPageNum(1);
		}
		if (pageBean.getMaxPage() < 1) {
			int allRows = dao.getAllRowsNum(userBean);
			int maxPage = (allRows + pageBean.getRowsPerPage() - 1)
					/ pageBean.getRowsPerPage();
			if (maxPage < 1) {
				return res;
			}
			pageBean.setMaxPage(maxPage);
		}
		if (pageBean.getPageNum() > pageBean.getMaxPage()) {
			pageBean.setPageNum(pageBean.getMaxPage());
		}
		int begin = (pageBean.getPageNum() - 1) * pageBean.getRowsPerPage() + 1;
		res
				.addAll(dao.getByExample(userBean, begin, pageBean
						.getRowsPerPage()));
		if (pageBean.getPageNum() > 1) {
			pageBean.setLastPage(pageBean.getPageNum() - 1);
		}
		if (pageBean.getPageNum() < pageBean.getMaxPage()) {
			pageBean.setNextPage(pageBean.getPageNum() + 1);
		}
		return res;
	}

	public List<UserBean> LoadById(int id) throws Exception {
		return dao.LoadById(id);
	}

	public boolean userDelete(int id) throws Exception {
		return dao.userDelete(id);
	}

	public boolean userInsert(UserBean userBean) throws Exception {
		return dao.userInsert(userBean);
	}

	public boolean userUpdate(UserBean userBean) throws Exception {
		return dao.userUpdate(userBean);
	}

}
