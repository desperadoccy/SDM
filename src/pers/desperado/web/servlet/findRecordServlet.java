package pers.desperado.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pers.desperado.domain.PatientRecord;
import pers.desperado.service.PatientService;
import pers.desperado.service.impl.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findRecordServlet")
public class findRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        PatientService service = new PatientServiceImpl();
        PatientRecord patientRecord = service.findRecord(name);

        //json数据
        ObjectMapper mapper1 = new ObjectMapper();
        String json = null;
        try {
            json = mapper1.writeValueAsString(patientRecord);
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
