package by.your_anime_list.controller.command.impl;

import by.your_anime_list.bean.User;
import by.your_anime_list.controller.JspPage;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import by.your_anime_list.service.UserService;
import by.your_anime_list.service.exception.ServiceException;
import by.your_anime_list.service.factory.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ProfileCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user;
        String userId = request.getParameter("id");
        if (userId != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            UserService userService = ServiceFactory.getInstance().getUserService();
            try {
                user = userService.getUser(id);
            } catch (ServiceException e) {
                throw new CommandException(e.getMessage());
            }
        } else {
            HttpSession httpSession = request.getSession();
            user = (User) httpSession.getAttribute("user");
        }

        request.setAttribute("LOGIN", user.getLogin());
        request.setAttribute("STATUS_VALUE", user.getStatusValue());
        return JspPage.PROFILE.getName();
    }
}
