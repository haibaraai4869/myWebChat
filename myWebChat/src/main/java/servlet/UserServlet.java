package servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ChatRecord;
import domain.User;
import net.sf.json.JSONArray;
import service.UserService;
import service.impl.UserServiceImpl;
import servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserServlet/*")
public class UserServlet extends BaseServlet {

    protected void findAllRelations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void findPicPath(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("访问到了findPicPath");
        String username = request.getParameter("username");
        UserService service = new UserServiceImpl();
        String foundPath = service.findPicPathByUsername(username);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),foundPath);
    }

    protected void addPicPath(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("访问到了addPicPath");
        String username = request.getParameter("username");
        UserService service = new UserServiceImpl();
        service.addPicPathByUsername(username);

       ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),null);
    }

    protected void updatePicPath(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String rePicPath = request.getParameter("picPath");
        UserService service = new UserServiceImpl();
        service.updatePicPathByUsername(username,rePicPath);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),null);
    }

    protected void findUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        UserService service = new UserServiceImpl();
        User foundUser = service.findUserByUsername(username);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),foundUser);
    }

    protected void PersonInfoChange(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String reChatName = request.getParameter("chatName");
        String rePassword = request.getParameter("password");

        UserService service = new UserServiceImpl();
        service.updateUserInfo(username,reChatName,rePassword);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),null);
    }
}