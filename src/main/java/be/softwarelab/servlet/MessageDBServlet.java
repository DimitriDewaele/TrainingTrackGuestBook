package be.softwarelab.servlet;

import be.softwarelab.dao.MessagesDao;
import be.softwarelab.dao.UsersDao;
import be.softwarelab.entity.Messages;
import be.softwarelab.entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dimitridw
 */
@WebServlet(urlPatterns = {"/MessageDBServlet"})
public class MessageDBServlet extends HttpServlet {

    // Injected DAO EJB:
    @EJB
    UsersDao usersDao;
    @EJB
    MessagesDao messagesDao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MessageDBServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MessageDBServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Display the list of guests:
        //request.setAttribute("users", usersDao.getAllUsers());
        request.setAttribute("messages", messagesDao.getAllMessages());
        request.getRequestDispatcher("/messageDBjpa.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle a new guest:
        //Long id = Long.valueOf(request.getParameter("id"));
        String user = request.getParameter("user");
        String message = request.getParameter("message");

        Users u = null;
        if (usersDao.getByName(user) != null) {
            u = usersDao.getByName(user);
        } else {
            Integer id = usersDao.getMaxId();
            if (id == null) {
                id = 1;
            }
            u = new Users(id + 1);
            u.setName(user);
            usersDao.persist(u);
        }

        Integer mId = messagesDao.getMaxId();
        if (mId == null) {
            mId = 1;
        }
        Messages m = new Messages(mId + 1);
        m.setMessage(message);
        m.setUserId(u);

        messagesDao.persist(m);

        // Display the list of guests:
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
