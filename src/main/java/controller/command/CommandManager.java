package controller.command;

import controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private static CommandManager instance = new CommandManager();
    private Map<String,Command> commandMap = new HashMap<>();

    {
        init();
    }

    public static CommandManager getInstance(){
        return instance;
    }

    public Command getCommand(String commandName){

        return commandMap.get(commandName);
    }

    public Command getCommand(HttpServletRequest request){
        String commandName = request.getParameter(Parameters.ACTION_PARAM);
        System.out.println(commandName);
        if(commandName == null) return getDefaultCommand();
        return commandMap.getOrDefault(commandName,getDefaultCommand());
    }

    private Command getDefaultCommand(){
        return commandMap.get(CommandNames.DEFAULT);
    }

    private void init(){
        commandMap.put(CommandNames.LOGIN, new LogInCommand());
        commandMap.put(CommandNames.LOGOUT,new LogOutCommand());
        commandMap.put(CommandNames.REGISTRATION,new RegistrationCommand());
        commandMap.put(CommandNames.DEFAULT,new DefaultCommand());
    }
}
