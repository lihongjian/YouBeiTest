package servlet;

import Hsystem.base.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hongjian on 2015/11/22.
 */
public class AjaxServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doSomeThing(request, response, "POST");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doSomeThing(request, response, "GET");

    }

    String[] provinces = {"山东","北京","上海"};
    String[][] citiesAll = {{"青州","潍坊","青岛","威海","德州"},{"海淀","通州","昌平"},{"黄浦","青浦"}};

    public void doSomeThing(HttpServletRequest request, HttpServletResponse response, String type) throws ServletException, IOException {


        String method = request.getParameter("method");
        if(method == null) {

            String name = request.getParameter("name");
            String account = request.getParameter("account");
            String content_Type = request.getParameter("content_Type");
            String msg = "this is a ajax test and type is " + type + " ! name = " + name + " " + " and account = " + account + " and content_Type = " + content_Type;
            if (content_Type.equals("xml")) {
                response.setContentType("text/xml;charset=UTF-8");
                response.getWriter().write("<?xml version=\"1.0\" encoding=\"gb2312\"?> <result id=\"result\">" + msg + "</result>");
            } else if (content_Type.equals("json")) {
                response.setContentType("text/json;charset=UTF-8");
                response.getWriter().write("{msg : \"" + msg + "\" , code : \"1\" }");
            } else if (content_Type.equals("html")) {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<p>" + msg + "</p>");
            } else {
                response.getWriter().write(msg);
            }
        } else {
            response.setContentType("text/json;charset=UTF-8");
            if(method.equals("provices")){
                StringBuilder sb = new StringBuilder();
                sb.append("{ provinces : [");
                for(int i = 0 ; i < provinces.length ; i++){
                    String province = provinces[i];
                    sb.append("{province : '");
                    sb.append(province);
                    sb.append("',id : '");
                    sb.append(i);
                    sb.append("'}");
                    if(i != provinces.length-1){
                        sb.append(",");
                    }
                }
                sb.append("]}");
                response.getWriter().write( sb.toString() );
            } else if (method.equals("cities")){
                String id = request.getParameter("id");
                int index = Integer.parseInt(id);
                String[] cities = null;
                if(index<0 || index >= citiesAll.length){
                    cities = new String[]{};
                } else {
                    cities = citiesAll[index];
                }
                StringBuilder sb = new StringBuilder();
                sb.append("{ cities : [");
                for(int i = 0 ; i < cities.length ; i++){
                    String province = cities[i];
                    sb.append("{city : '");
                    sb.append(province);
                    sb.append("',id : '");
                    sb.append(i);
                    sb.append("'}");
                    if(i != cities.length-1){
                        sb.append(",");
                    }
                }
                sb.append("]}");
                response.getWriter().write(sb.toString());

            }
            System.out.println("abc");
        }
    }


}
