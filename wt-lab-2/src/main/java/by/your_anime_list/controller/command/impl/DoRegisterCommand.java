package by.your_anime_list.controller.command.impl;

import by.your_anime_list.bean.User;
import by.your_anime_list.controller.JspPage;
import by.your_anime_list.controller.RedirectAddress;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import by.your_anime_list.service.UserService;
import by.your_anime_list.service.exception.ServiceException;
import by.your_anime_list.service.factory.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class DoRegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirmedPassword = request.getParameter("confirmedPassword");
        UserService userService = ServiceFactory.getInstance().getUserService();
        try {
            user = userService.register(login, password, confirmedPassword);
        } catch (ServiceException e) {
            System.out.println("Exception here:(");
            System.out.println(e.getMessage());
            throw new CommandException(e.getMessage());
        }
        if (user == null) {
            return RedirectAddress.REGISTRATION_FAILED.getAddress();
        }
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user", user);
        return RedirectAddress.REGISTRATION_SUCCESS.getAddress();
    }
}
