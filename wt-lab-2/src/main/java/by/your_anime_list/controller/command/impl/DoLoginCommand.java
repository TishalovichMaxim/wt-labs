package by.your_anime_list.controller.command.impl;

import by.your_anime_list.bean.User;
import by.your_anime_list.controller.RedirectAddress;
import by.your_anime_list.controller.SessionAttribute;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import by.your_anime_list.service.UserService;
import by.your_anime_list.service.exception.ServiceException;
import by.your_anime_list.service.factory.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class DoLoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserService userService = ServiceFactory
                .getInstance().getUserService();
        User user;
        try {
            user = userService.login(login, password);
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }

        HttpSession httpSession = request.getSession();
        if (user != null) {
            httpSession.setAttribute(SessionAttribute.USER.getName(), user);
            return RedirectAddress.LOGIN_SUCCESS.getAddress();
        }

        return RedirectAddress.LOGIN_FAILED.getAddress();
    }
}
