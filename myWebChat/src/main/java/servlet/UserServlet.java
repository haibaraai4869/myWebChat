package servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ChatRecord;
import domain.User;
import net.sf.json.JSONArray;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了UserServlet");
        UserService service = new UserServiceImpl();
        String username1 = request.getParameter("username");

        System.out.println(username1);
        List<ChatRecord> friendList = service.findAllRelation(username1);
        System.out.println(friendList);

        JSONArray jsonFriendList=JSONArray.fromObject(friendList);
        System.out.println(jsonFriendList.toString());

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),jsonFriendList.toString());
    }
}