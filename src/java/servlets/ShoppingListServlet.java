package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        
        //checks if action is logout and kills session
        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = req.getSession();
            req.setAttribute("action", null);
        }
        
        //checks if a username exists and forwards to shopping list if true
        //else loads the register page
        if (session.getAttribute("username") != null) {
            req.getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(req, resp);
        } else {
            req.setAttribute("action", "");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<String> items;
        String action = req.getParameter("action");
        
        //checks the action of the user and runs certain block of code depending
        //on the action.
        
        //action is register
        if (action != null && action.equals("Register")) {
            String username = req.getParameter("username");
            items = new ArrayList<>();
            session.setAttribute("username", username);
            session.setAttribute("items", items);
        }
        //action is add
        else if (action != null && action.equals("add")) {
            String itemToAdd = req.getParameter("item");
            items = (ArrayList<String>) session.getAttribute("items");
            items.add(itemToAdd);
            session.setAttribute("items", items);
        }
        //action is delete
        else if (action != null && action.equals("delete")){
            String itemToDelete = req.getParameter("item");
            items = (ArrayList<String>) session.getAttribute("items");
            items.remove(itemToDelete);
            session.setAttribute("items", items);
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(req, resp);
    }
}
