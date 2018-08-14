package controller.utility;

import controller.Parameters;
import model.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class RolesUtility {
    public void setUserRoleAndLogin(HttpServletRequest request,
                                    User.ROLE role, String login) {
        HttpSession session = request.getSession();
        session.setAttribute(Parameters.ROLE, role);
        session.setAttribute(Parameters.LOGIN,login);
        // todo add first name to session scope
    }

    public boolean isUserAlreadyLogged(HttpServletRequest request, String login){
        HashSet<String> loggedUsers = (HashSet<String>) request.getServletContext().getAttribute(Parameters.LOGGED_USERS);
        return loggedUsers.stream().anyMatch(login::equals);
    }

    public void addLoginInServletContext(HttpServletRequest request, String login){
        HashSet<String> loggedUsers = (HashSet<String>) request.getServletContext().getAttribute(Parameters.LOGGED_USERS);
        loggedUsers.add(login);
        request.getServletContext().setAttribute(Parameters.LOGGED_USERS,loggedUsers);
    }

    public void removeRoleAndLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        String login = (String)session.getAttribute(Parameters.LOGIN);

        HashSet<String> loggedUsers = (HashSet<String>) request.getServletContext().getAttribute(Parameters.LOGGED_USERS);
        loggedUsers.remove(login);
        // todo try to remove this string with setAttribute method
        request.getServletContext().setAttribute(Parameters.LOGGED_USERS,loggedUsers);


        session.setAttribute(Parameters.ROLE, User.ROLE.GUEST);
        session.removeAttribute(Parameters.LOGIN);
    }
    // todo refactor isUserAlreadyLogged
    /*
    public boolean isUserAlreadyLogged(HttpServletRequest request, String login){
        HashSet<String> loggedUsers = (HashSet<String>) request.getServletContext().getAttribute(Parameters.LOGGED_USERS);

        if(loggedUsers.stream().anyMatch(login::equals)){
            return true;
        }
        loggedUsers.add(login);
        request.getServletContext().setAttribute(Parameters.LOGGED_USERS,loggedUsers);
        return false;
    }
     */

}
