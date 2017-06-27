package cn.baisee.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor {

	/**
	 * 在调用指定Controller之前调用
	 * 
	 * 返回值：如果为turn则继续往下执行，如果为false就不往下执行 如果访问非注册，登录
	 * 这两个用户操作的方法，那么我们就进行权限认证（用户是否已经登录）
	 */

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object arg2) throws Exception {
//		System.out.println("到我这里preHandle");
		Object loginUser = request.getSession().getAttribute("loginUser");
		// 判断用户对象是否存入sessiion中
		if (loginUser == null) {
			// 页面跳转
			response.sendRedirect("/project_01/login.jsp");
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 该方法会在Controller之后，在渲染视图之前执行，所以我们 可以对ModelAndView进行操作
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 该方法在Controller之后，在视图渲染完成后执行，所以我们可以在此处清理渲染资源，
	 * 或者捕获系统当中发生的异常
	 * 1、购物业务
	 * 		选择商品->购物车->填写配送信息->下单支付(保存订单信息)->支付回调结果->完成订单
	 * 自定义一个异常
	 *GoodsException("支付回调订单不存在！") 
	 * 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception exception)
			throws Exception {
		

	}

	

}
