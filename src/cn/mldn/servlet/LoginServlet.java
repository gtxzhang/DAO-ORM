package cn.mldn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.service.LoginService;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		String url = "/login.jsp" ;	// 默认的跳转页面
		// 1、需要对请求参数进行接收控制，使用request对象即可完成
		String mid = request.getParameter("mid") ;
		String password = request.getParameter("password") ;
		// 2、需要对参数进行验证，必须保证参数的内容不为null
		List<String> errors = new ArrayList<String>() ;	// 保存所有相关的验证信息
		if (mid == null || "".equals(mid)) {
			errors.add("用户名不允许为空！") ;
		}    
		if (password == null || "".equals(password)) {
			errors.add("密码不允许为空！") ;
		}
		// 3、如果以上的验证通过了，则调用业务层来进行控制
		if (errors.size() == 0) {	// 如果没有错误信息保存，则表示数据验证通过
			LoginService service = new LoginService() ;
			if (service.login(mid, password)) {	// 登录合法
				request.getSession().setAttribute("mid", mid);	// 保存登录标记
				url = "/index.jsp" ;
			} else {	// 登录失败
				errors.add("登录失败，错误的用户名或密码！") ;
			}
		}
		// 4、实现页面跳转处理
		request.setAttribute("err", errors);	// 保存错误信息 
		request.getRequestDispatcher(url).forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
