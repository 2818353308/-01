package cn.baisee.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor {

	/**
	 * �ڵ���ָ��Controller֮ǰ����
	 * 
	 * ����ֵ�����Ϊturn���������ִ�У����Ϊfalse�Ͳ�����ִ�� ������ʷ�ע�ᣬ��¼
	 * �������û������ķ�������ô���Ǿͽ���Ȩ����֤���û��Ƿ��Ѿ���¼��
	 */

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object arg2) throws Exception {
//		System.out.println("��������preHandle");
		Object loginUser = request.getSession().getAttribute("loginUser");
		// �ж��û������Ƿ����sessiion��
		if (loginUser == null) {
			// ҳ����ת
			response.sendRedirect("/project_01/login.jsp");
			return false;
		} else {
			return true;
		}

	}

	/**
	 * �÷�������Controller֮������Ⱦ��ͼ֮ǰִ�У��������� ���Զ�ModelAndView���в���
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * �÷�����Controller֮������ͼ��Ⱦ��ɺ�ִ�У��������ǿ����ڴ˴�������Ⱦ��Դ��
	 * ���߲���ϵͳ���з������쳣
	 * 1������ҵ��
	 * 		ѡ����Ʒ->���ﳵ->��д������Ϣ->�µ�֧��(���涩����Ϣ)->֧���ص����->��ɶ���
	 * �Զ���һ���쳣
	 *GoodsException("֧���ص����������ڣ�") 
	 * 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception exception)
			throws Exception {
		

	}

	

}
