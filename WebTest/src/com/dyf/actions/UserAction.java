package com.dyf.actions;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.dyf.biz.IUserServ;
import com.dyf.domain.PageBean;
import com.dyf.domain.UserBean;
import com.dyf.util.ServFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4023445682509909829L;
	private HttpServletRequest request;
	private HttpServletResponse response;

	private static IUserServ serv = ServFactory.getUserServ();
	UserBean userBean = new UserBean();
	private int page;
	private int id;
	private static int rowsPerPage = 3;
	private static int maxPage = 0;
	private String uname;

	public String checkUser() throws Exception {
		boolean bb = false;
		bb = serv.check(userBean);
		if (bb) {
			ActionContext.getContext().getSession().put("userBean",
					userBean.getUsername());
			return SUCCESS;
		} else {
			this.addActionError("登陆失败!!!");
			return INPUT;
		}
	}

	public void checkUserName() {
		String uname = request.getParameter("userBean.username");
		userBean.setUsername(uname);
		boolean tem=false;
		try {
			tem = serv.check(userBean);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		PrintWriter print;
		try {
			print = response.getWriter();
			print.print(tem);
			print.flush();
			print.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		serv=null;
		uname=null;
	}
	public String showUser() throws Exception {
		PageBean pageBean = new PageBean();
		pageBean.setPageNum(page);
		pageBean.setMaxPage(maxPage);
		pageBean.setRowsPerPage(rowsPerPage);
		List<UserBean> list = serv.getAllByPage(pageBean);
		maxPage = pageBean.getMaxPage();
		ServletActionContext.getRequest().setAttribute("list", list);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return SUCCESS;
	}

	public String userInsert() throws Exception {
		boolean bb = false;
		bb = serv.userInsert(userBean);
		if (bb) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	public String userDelete() throws Exception {
		PageBean pageBean = new PageBean();
		boolean bb = false;
		Integer uid = Integer.parseInt(request.getParameter("id").toString());
		bb = serv.userDelete(uid);
		if (bb) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public String userUpdate() throws Exception {
		boolean bb = false;
		bb = serv.userUpdate(userBean);
		if (bb) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public String loadById() throws Exception {
		Integer uid = Integer.parseInt(request.getParameter("id").toString());
		List<UserBean> list = serv.LoadById(uid);
		if (null != userBean) {
			request.setAttribute("list", list);
			request.setAttribute("id", uid);
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public static IUserServ getServ() {
		return serv;
	}

	public static void setServ(IUserServ serv) {
		UserAction.serv = serv;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public static int getRowsPerPage() {
		return rowsPerPage;
	}

	public static void setRowsPerPage(int rowsPerPage) {
		UserAction.rowsPerPage = rowsPerPage;
	}

	public static int getMaxPage() {
		return maxPage;
	}

	public static void setMaxPage(int maxPage) {
		UserAction.maxPage = maxPage;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;

	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}
}
