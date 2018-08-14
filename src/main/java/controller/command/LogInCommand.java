package controller.command;

import controller.PagesName;
import controller.Parameters;
import controller.utility.InputAnalyse;
import controller.utility.RolesUtility;
import model.entity.User;
import model.exception.LoginException;
import model.service.GuestService;

import javax.servlet.http.HttpServletRequest;

public class LogInCommand implements Command {
    // todo best place to keep this class
    GuestService guestService = new GuestService();
    InputAnalyse inputAnalyse = new InputAnalyse();
    RolesUtility rolesUtility = new RolesUtility();

    @Override
    public String execute(HttpServletRequest request) {

        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);

        if(isInputDataUncorrect(login,password)){
            return PagesName.LOGIN_PAGE;
        }
        if(rolesUtility.isUserAlreadyLogged(request,login)){
            // todo call log out command
            CommandManager.getInstance().getCommand(CommandConstants.LOGOUT_COMMAND).execute(request);
            return PagesName.LOGIN_PAGE;
        }
        try {
            User.ROLE role = guestService.login(new User(login,password));
            // todo add in Session and Contex scope
            rolesUtility.addLoginInServletContext(request,login);
            rolesUtility.setUserRoleAndLogin(request,role,login);
            return CommandConstants.REDIRECT+defineHomePageByRole(role);
        } catch (LoginException e) {
            return PagesName.LOGIN_PAGE;
        }
    }

    private boolean isInputDataUncorrect(String login, String password){
        if(login== null || password ==null || login.isEmpty() || password.isEmpty()){
            return true;
        }
        // todo Should it be simplify?
        /*
        return !inputAnalyse.checkInputByRegex(login,RegexKeys.LOGIN_REGEX,Languages.ENG) ||
                !inputAnalyse.checkInputByRegex(login,RegexKeys.PASSWORD_REGEX,Languages.ENG);
         */
        return false;
    }

    private String defineHomePageByRole(User.ROLE role){
        String page;
        switch (role){
            case ADMIN: page = PagesName.ADMIN_HOME_PAGE;
            break;
            case USER: page = PagesName.USER_HOME_PAGE;
            break;
            default: page = PagesName.LOGIN_PAGE;
        }
        return page;
    }
}
