package Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了LoginServlet");
        String username="Haibaraai";
        String password="4869";

        String succeed="login Succeed!";
        String failed="login Failed";
        String reqUsername = request.getParameter("username");
        String reqPassword = request.getParameter("password");
        System.out.println(reqUsername);
        System.out.println(reqPassword);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        if(username.equals(reqUsername)&&password.equals(reqPassword)){
            mapper.writeValue(response.getOutputStream(),succeed);
        }
        else {
            mapper.writeValue(response.getOutputStream(),failed);
        }
    }
}
