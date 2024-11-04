package com.myconstruction.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.myconstruction.Login; 

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Lógica de autenticación delegada a la clase Login
        Login login = new Login();
        if (login.validarUsuario(username, password)) {
            // Crea una nueva sesión y almacena el nombre de usuario
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("Home.jsp"); // Redirige a la página de éxito
        } else {
            // Direcciona al login con un mensaje de error
            response.sendRedirect("Login.jsp?error=Usuario o contraseña no válidos");
        }
    }
}
