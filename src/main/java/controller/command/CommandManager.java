package controller.command;

import controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class CommandManager {
    private static CommandManager instance = new CommandManager();
    private Map<String,Command> commandMap;

    public static CommandManager getInstance(){
        return instance;
    }

    public Command getCommand(String commandName){

        return commandMap.get(commandName);
    }

    public Command getCommand(HttpServletRequest request){
        String commandName = request.getParameter(Parameters.ACTION_PARAM);
        return commandMap.getOrDefault(commandName,commandMap.get(CommandNames.DEFAULT));
    }

    private void init(){
        commandMap.put(CommandNames.LOGIN, new LogInCommand());
        commandMap.put(CommandNames.LOGOUT,new LogOutCommand());
        commandMap.put(CommandNames.REGISTRATION,new RegistrationCommand());
    }
}
