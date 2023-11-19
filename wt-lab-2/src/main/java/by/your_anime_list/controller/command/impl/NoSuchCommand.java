package by.your_anime_list.controller.command.impl;

import by.your_anime_list.controller.JspPage;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;

/**
 * The NoSuchCommand class is an implementation of the Command interface.
 * It handles the case when there is no corresponding command for a given request.
 */
public class NoSuchCommand implements Command {
    /**
     * Executes the command when there is no corresponding command for a given request.
     *
     * @param request the HttpServletRequest object
     * @return the name of the error JSP page
     * @throws CommandException if an error occurs while executing the command
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return JspPage.ERROR_PAGE.getName();
    }
}
