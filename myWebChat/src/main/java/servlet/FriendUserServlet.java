package servlet;

import com.alibaba.druid.sql.visitor.SQLASTOutputVisitorUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
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

@WebServlet("/FriendUserServlet/*")
public class FriendUserServlet extends BaseServlet {

    /**
     * 通过用户名查找用户
     */
    protected void checkByUsername(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("访问到了checkByUsername");
        String checkUsername = request.getParameter("checkUsername");
        UserService service = new UserServiceImpl();
        User foundUser = service.findUserByUsername(checkUsername);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),foundUser);
    }
    /**
     * 通过昵称模糊查找用户
     */
    protected void checkByChatName(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("访问到了addByChatNameServlet");
        String chatName = request.getParameter("checkChatName");
        UserService service = new UserServiceImpl();

        List<User> foundUsers = service.findByChatName(chatName);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),foundUsers);

    }

    /**
     * 通过用户名添加relation
     */
    protected void addByUsername(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("访问到了addByUsername");
        String username1 = request.getParameter("username1");
        String username2 = request.getParameter("username2");
        UserService service = new UserServiceImpl();
        boolean addSuccess = service.addUserByUsername(username1,username2);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),addSuccess);
    }

    /**
     * 通过用户名删除relation
     */
    protected void deleteByUsername(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("访问到了delByUsername");
        String username1 = request.getParameter("username1");
        String username2 = request.getParameter("username2");
        UserService service = new UserServiceImpl();
        boolean delSuccess = service.deleteUserByUsername(username1,username2);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),delSuccess);
    }

    /**
     * 通过用户名统计好有个数
     */
    protected void countFriend(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("访问到了countFriend");
        String username1 = request.getParameter("username1");

        UserService service = new UserServiceImpl();
        int friendNum = service.countFriendNum(username1);
        System.out.println(friendNum);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),friendNum);
    }

    protected void conformRelation(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("访问到了conformRelation");
        String username1 = request.getParameter("username1");
        String username2 = request.getParameter("username2");

        UserService service = new UserServiceImpl();
        service.addExchangeFriend(username1,username2);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),null);
    }
}
