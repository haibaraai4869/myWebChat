package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ChatRecord;
import domain.CorrespondRecord;
import service.CorrespService;
import service.impl.CorrespServiceImpl;
import servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CorrespServlet/*")
public class CorrespServlet extends BaseServlet {
    protected void checkChatRecords(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("访问到了checkChatRecords");

        String username1 = request.getParameter("username1");
        String username2 = request.getParameter("username2");
        CorrespService service = new CorrespServiceImpl();
        List<CorrespondRecord> allChatRecordList = service.getAllChatRecord(username1, username2);
        System.out.println(allChatRecordList);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),allChatRecordList);
    }

    protected void addChatRecords(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("访问到了addChatRecords");

        String senduser = request.getParameter("senduser");
        String acceptuser = request.getParameter("acceptuser");
        String chatTime = request.getParameter("chatTime");
        String chatRecord = request.getParameter("chatRecord");

        CorrespService service = new CorrespServiceImpl();
        service.addChatRecords(senduser,acceptuser,chatTime,chatRecord);


        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),null);
    }

    protected void checkFriendRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("访问到了checkFriendRequest");
        String username2 = request.getParameter("username");

        CorrespService service = new CorrespServiceImpl();
        List<ChatRecord> allFriendRequest = service.getAllFriendRequest(username2);
        System.out.println(allFriendRequest);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),allFriendRequest);
    }
}
