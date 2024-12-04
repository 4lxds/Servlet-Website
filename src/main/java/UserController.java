import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        try {
            if (action.equals("list")) {
                List<User> users = UserDao.getAllUsers();
                request.setAttribute("users", users);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("edit")) {
                int userId = Integer.parseInt(request.getParameter("id"));
                User user = UserDao.getUserById(userId);
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editUser.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("delete")) {
                int userId = Integer.parseInt(request.getParameter("id"));
                UserDao.deleteUser(userId);
                response.sendRedirect("users?action=list");
            } else if (action.equals("add")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("add")) {
                String userName = request.getParameter("userName");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                User user = new User(0, userName, email, password); // ID is auto-generated
                UserDao.addUser(user);
                response.sendRedirect("users?action=list");
            } else if (action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String userName = request.getParameter("userName");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                User user = new User(id, userName, email, password);
                UserDao.updateUser(user);
                response.sendRedirect("users?action=list");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}