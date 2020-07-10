package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
import service.LoginService;
import service.impl.LoginServiceImpl;
import servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet/*")
public class LoginServlet extends BaseServlet {

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("访问到了LoginServlet");
        LoginService service = new LoginServiceImpl();

        String succeed="login Succeed!";
        String failed="login Failed";
        String reqUsername = request.getParameter("username");
        String reqPassword = request.getParameter("password");
        //System.out.println(reqUsername);
       // System.out.println(reqPassword);

        User foundUser = service.login(reqUsername, reqPassword);

        //System.out.println(foundUser.toString());
        //把foundUser对象转换称json数据(手动)
        String foundUserJson="{\"id\":\""+foundUser.getId()+"\",\"username\":\""+foundUser.getUsername()
                +"\",\"password\":\""+foundUser.getPassword()+"\",\"chatname\":\""+foundUser.getChatname()+"\"}";

        //System.out.println(foundUserJson);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),foundUserJson);

    }


    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService service = new LoginServiceImpl();
        System.out.println("访问到了register");
        String reqUsername = request.getParameter("username");
        String reqPassword = request.getParameter("password");
        String reChatname = request.getParameter("chatname");

        boolean registerSucceed = service.register(reqUsername, reqPassword, reChatname);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),registerSucceed);

    }
}
