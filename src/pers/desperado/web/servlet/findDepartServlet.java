package pers.desperado.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pers.desperado.domain.Department;
import pers.desperado.service.DepartmentService;
import pers.desperado.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findDepartServlet")
public class findDepartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> cs = departmentService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(cs);
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
