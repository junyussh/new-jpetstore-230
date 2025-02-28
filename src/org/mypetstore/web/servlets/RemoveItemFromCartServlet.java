package org.mypetstore.web.servlets;

import org.mypetstore.domain.Cart;
import org.mypetstore.domain.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RemoveItemFromCartServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private String workingItemId;
    private Cart cart;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("post 请求");
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("get 请求");
        workingItemId = req.getParameter("workingItemId");
//        System.out.println("+++"+workingItemId);
        HttpSession session = req.getSession();
        Cart cart = (Cart)session.getAttribute("cart");

        Item item = cart.removeItemById(workingItemId);


        if(item == null){
            session.setAttribute("message", "Attempted to remove null CartItem from Cart.");
            req.getRequestDispatcher(ERROR).forward(req,resp);
        }else{
//            System.out.println("====="+item.getItemId());
            req.getRequestDispatcher(VIEW_CART).forward(req,resp);
        }

    }
}
