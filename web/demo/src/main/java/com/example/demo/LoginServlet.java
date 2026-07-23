package com.example.demo;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/login")

public class LoginServlet  extends  HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException,IOException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if("admin".equals(username) && "password".equals(password)){
            response.sendRedirect("dashboard.jsp");
        }
        else{
            response.sendRedirect("error.jsp");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws ServletException, IOException{
        request.getRequestDispatcher("/login.jsp")
                .forward(request,response);
    }
}
