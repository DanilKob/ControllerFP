package controller.command;

import controller.PagesName;
import controller.Parameters;
import controller.utility.InputAnalyse;
import controller.utility.Languages;
import controller.utility.RolesUtility;
import model.UserService;
import model.entity.RegistrationForm;
import model.entity.User;
import model.exception.LoginIsAlreadyExistException;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command{

    UserService userService = new UserService();
    InputAnalyse inputAnalyse = new InputAnalyse();
    RolesUtility rolesUtility = new RolesUtility();

    @Override
    public String execute(HttpServletRequest request) {

        // todo add logger
        System.out.println(Parameters.LANGUAGE+ " " + request.getSession().getAttribute(Parameters.LANGUAGE));

        //todo ask about cast to String
        String language = ((String)request.getSession().getAttribute(Parameters.LANGUAGE)).toUpperCase();
        Languages languageEnum = Languages.valueOf(language);

        String firstName = request.getParameter(Parameters.FIRST_NAME);
        String lastName = request.getParameter(Parameters.LAST_NAME);
        String middleName = request.getParameter(Parameters.MIDDLE_NAME);
        String login = request.getParameter(Parameters.LOGIN);

        boolean isFirstNameCorrect = true;
        boolean isLastNameCorrect = true;
        boolean isMiddleNameCorrect = true;
        boolean isLoginCorrect = true;
        // todo debug mode
        /*
        boolean isFirstNameCorrect = inputAnalyse.checkInputByRegex(firstName,RegexKeys.FIRST_NAME_REGEX,languageEnum);
        boolean isLastNameCorrect = inputAnalyse.checkInputByRegex(lastName,RegexKeys.LAST_NAME_REGEX,languageEnum);
        boolean isMiddleNameCorrect = inputAnalyse.checkInputByRegex(middleName,RegexKeys.MIDDLE_NAME_REGEX,languageEnum);
        boolean isLoginCorrect = inputAnalyse.checkInputByRegex(login,RegexKeys.LOGIN_REGEX,languageEnum);
        */
        if(isFirstNameCorrect && isLastNameCorrect && isMiddleNameCorrect && isLoginCorrect){

            RegistrationForm registrationForm = new RegistrationForm(firstName,lastName,middleName,language,login);
            try {
                userService.registerUser(registrationForm);
                rolesUtility.setUserRoleAndLogin(request,User.ROLE.USER,login);
                return CommandConstants.REDIRECT+PagesName.USER_HOME_PAGE;
            } catch (LoginIsAlreadyExistException e) {
                //todo refactor in separate method
                //set message
                return CommandConstants.REGISTRATION_COMMAND;
            }
        }else{
            return CommandConstants.REGISTRATION_COMMAND;
        }
        // todo return can be replace from catch. Catch block will only contains "setMessage" method

    }

    /*
    private boolean checkInputAndSetErrorMassage(String firstName, String lastName, String middleName,
                                                 String login,Languages language){
        boolean isInputCorrect = true;
        inputAnalyse.checkInputByRegex(firstName,RegexKeys.FIRST_NAME_REGEX,language);
        inputAnalyse.checkInputByRegex(lastName,RegexKeys.LAST_NAME_REGEX,language);
        inputAnalyse.checkInputByRegex(middleName,RegexKeys.MIDDLE_NAME_REGEX,language);
        inputAnalyse.checkInputByRegex(login,RegexKeys.LOGIN_REGEX,language);
    }
    */

     /*
        inputAnalyse.checkInputByRegex(firstName,RegexKeys.FIRST_NAME_REGEX,languageEnum);
        inputAnalyse.checkInputByRegex(lastName,RegexKeys.LAST_NAME_REGEX,languageEnum);
        inputAnalyse.checkInputByRegex(middleName,RegexKeys.MIDDLE_NAME_REGEX,languageEnum);
        inputAnalyse.checkInputByRegex(login,RegexKeys.LOGIN_REGEX,languageEnum);
        */
}
