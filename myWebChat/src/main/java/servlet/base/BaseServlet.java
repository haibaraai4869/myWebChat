package servlet.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("BaseService被执行了！！");
        //1,拿到请求的虚拟路径
        String uri = request.getRequestURI();
        //System.out.println(uri);
        //2,获取方法名称
        String MethodName = uri.substring(uri.lastIndexOf("/")+1);
        //System.out.println(MethodName);
        //3,通过反射获取方法对象Method
        //System.out.println(this);//谁调用了这个this就代表谁，此处显然代表TestServlet的对像
        try {
            //忽略访问修饰符获取方法
            Method method = this.getClass().getDeclaredMethod(MethodName, HttpServletRequest.class, HttpServletResponse.class);
            //暴力反射
            method.setAccessible(true);
            //执行该方法
            method.invoke(this,request,response);

            }
        catch (Exception e) {
                e.printStackTrace();
        }
    }


}
