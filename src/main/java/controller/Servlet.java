package controller;

import controller.command.Command;
import controller.command.CommandManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    private void processRequest(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        String commandName = req.getParameter(Parameters.ACTION_PARAM);
        //Command command = CommandManager.getInstance().getCommand(commandName);
        Command command = CommandManager.getInstance().getCommand(req);
        String page = command.execute(req);

        // todo Ask about method "isRedirected"

        if(page.contains("redirect")){
            page.replace("redirect","");
            resp.sendRedirect(page);
        }else{
            req.getRequestDispatcher(page).forward(req,resp);
        }
        /*
        if(commandName!=null){
            String pageResponse = CommandManager.getInstance().getCommand(commandName).execute(req);
            req.getRequestDispatcher(pageResponse).forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath());
        }*/
    }
}