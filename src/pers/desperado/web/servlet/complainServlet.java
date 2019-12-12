package pers.desperado.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import pers.desperado.domain.Complaint;
import pers.desperado.domain.ResultInfo;
import pers.desperado.service.ComplainService;
import pers.desperado.service.impl.ComplainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/complainServlet")
public class complainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map = request.getParameterMap();
        Complaint complaint = new Complaint();
        try {
            BeanUtils.populate(complaint,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        ComplainService complainService = new ComplainServiceImpl();
        complainService.commitComlaint(complaint);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
