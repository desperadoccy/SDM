package pers.desperado.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pers.desperado.domain.Doctor;
import pers.desperado.domain.Outpatient_manager;
import pers.desperado.domain.User;
import pers.desperado.service.DoctorService;
import pers.desperado.service.ManagerService;
import pers.desperado.service.impl.DoctorServiceImpl;
import pers.desperado.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctorServlet")
public class doctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Object user = request.getSession().getAttribute("user");
        ObjectMapper mapper = new ObjectMapper();
        String jsoninfo = mapper.writeValueAsString(user);
        User user1 = mapper.readValue(jsoninfo,User.class);
        DoctorService service = new DoctorServiceImpl();
        Doctor doctor = service.findInfo(user1.getUsername());

        //json数据
        ObjectMapper mapper1 = new ObjectMapper();
        String json = null;
        try {
            json = mapper1.writeValueAsString(doctor);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //返回数据
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
