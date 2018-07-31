/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.kriss.afp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kriss
 */
public class LoginVerifyServlet extends HttpServlet {

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

        // Variable contenant le chemin vers la vue
        String view;

        // Récuperation des parametres de la requete
        String nameParameterValue = request.getParameter("name");
        String passwordParameterValue = request.getParameter("password");

        if ("kriss".equals(nameParameterValue) && "kriss".equals(passwordParameterValue)) {
            // Les IDs de connexion sont OK
            view = "/WEB-INF/jsp/bienvenue.jsp";

            // Stocker les infos de login dans la session utilisateur
            HttpSession session = request.getSession();
            session.setAttribute("loginName", nameParameterValue);
            
            

        } else {
            // Ajout du message d'erreur
            request.setAttribute("error_message", "Identifiants incorrects !!!");
            view = "/WEB-INF/jsp/login.jsp";
        }

        // Redirection vers la vue
        ServletContext context = this.getServletContext();
        RequestDispatcher req = context.getRequestDispatcher(view);
        req.forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
