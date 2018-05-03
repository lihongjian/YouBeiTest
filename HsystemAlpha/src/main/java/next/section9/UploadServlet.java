package next.section9;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = -1915463532411657451L;


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        request.getParameter("partblob");
       /* Map<String,String> condition = JSON.parseObject(conditionString,Map.class);
        Map<String,String> resultMap = getCalculateService().calculate(condition);
        String result = JSON.toJSONString(resultMap);
        PrintWriter out = response.getWriter();
        try {
            out.println(result);
        } finally {
            out.close();
        }*/
    }

}
