package by.your_anime_list.controller.command;

import by.your_anime_list.controller.command.impl.*;
import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {
    private static final CommandHelper instance = new CommandHelper();
    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandHelper() {
        commands.put(CommandName.ANIME_LIST, new AnimeListCommand());
        commands.put(CommandName.ANIME, new ShowAnimeCommand());
        commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
        commands.put(CommandName.REGISTER, new RegisterCommand());
        commands.put(CommandName.LOGIN, new LoginCommand());
        commands.put(CommandName.DO_LOGIN, new DoLoginCommand());
        commands.put(CommandName.DO_REGISTER, new DoRegisterCommand());
        commands.put(CommandName.PROFILE, new ProfileCommand());
        commands.put(CommandName.LOGOUT, new LogoutCommand());
        commands.put(CommandName.ADD_REVIEW, new AddReviewCommand());
        commands.put(CommandName.ADD_ANIME, new AddAnimeCommand());
        commands.put(CommandName.DO_ADD_ANIME, new DoAddAnimeCommand());
        commands.put(CommandName.CHANGE_LANGUAGE, new ChangeLanguageCommand());
    }

    public static CommandHelper getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        Command command;
        CommandName name = null;
        try {
            name = CommandName.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (name != null) {
            command = commands.get(name);
        } else {
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        return command;
    }
}
