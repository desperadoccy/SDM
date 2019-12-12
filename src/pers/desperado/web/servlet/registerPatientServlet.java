package pers.desperado.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import pers.desperado.domain.Patient;
import pers.desperado.domain.PatientRecord;
import pers.desperado.service.ManagerService;
import pers.desperado.service.PatientService;
import pers.desperado.service.impl.ManagerServiceImpl;
import pers.desperado.service.impl.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerPatientServlet")
public class registerPatientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map = request.getParameterMap();

        PatientRecord patientRecord = new PatientRecord();
        try {
            BeanUtils.populate(patientRecord,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        ManagerService managerService = new ManagerServiceImpl();
        PatientRecord patientRecord1 = managerService.registRecord(patientRecord);

        //json数据
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(patientRecord1);
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
