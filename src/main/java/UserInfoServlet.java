import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vladyslav Vlasov on 14.01.2018.
 */
public class UserInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        printWriter.println("Your first name entered is" + firstName);
        printWriter.println("Your last name entered is " + lastName);
        printWriter.println("<h3> List of params and values: </h3>");
        Enumeration<String> paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = req.getParameter(paramName);
            printWriter.println("<p>" + paramName + " : " + paramValue + "</p>");
        }

        Map<String, String[]> paramMap = req.getParameterMap();
        Set<String> paramNamesSet = paramMap.keySet();
        for (String paramName : paramNamesSet) {
            String[] paramValues = paramMap.get(paramName);
            printWriter.println("<p>" + paramName + " : ");
            for (int i = 0; i < paramValues.length; i++) {
                printWriter.println(paramValues[i]);
            }
            printWriter.println("</p>");
        }
    }
}

