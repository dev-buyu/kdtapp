/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.kdt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 * 测试登录Servlet
 *
 * @author Implementist
 */
public class InformationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置响应内容类型  
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {

            //获得请求中传来各项数据
            String accountNumber = request.getParameter("username").trim();
            String receiver = request.getParameter("name").trim();
            String code  = request.getParameter("number").trim();
            String phone = request.getParameter("tel").trim();
            String address =request.getParameter("address").trim();
            String way = request.getParameter("way").trim();
            String size = request.getParameter("size").trim();
            String type = request.getParameter("type").trim();
            String cost = request.getParameter("money").trim();
            
            Boolean verifyResult = verifyLogin( receiver,code,phone,address,way,size,type,cost,accountNumber);

            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();

            if (verifyResult) {
                params.put("Result", "success");
            } else {
                params.put("Result", "failed");
            }

            jsonObject.put("params", params);
            out.write(jsonObject.toString());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 验证用户名密码是否正确
     *
     * @param userName
     * @param password
     */
    private Boolean verifyLogin(String receiver,String code,String phone,String address,String way,String size,String type,String cost,String userName) {
        Information information = InformationDAO.InsertInformation(receiver, code, phone, address, way, size, type, cost,userName);

        //账户密码验证
        return null != information;
    }
}

