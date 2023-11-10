package by.your_anime_list.controller.command.impl;

import by.your_anime_list.controller.RequestParameter;
import by.your_anime_list.controller.SessionAttribute;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import by.your_anime_list.view.Language;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String languageName = request.getParameter(RequestParameter.LANGUAGE.getName());
        System.out.println(languageName);
        String pageName = request.getParameter(RequestParameter.CURR_PAGE_NAME.getName());
        System.out.println(pageName);
        if (languageName == null || pageName == null) {
            throw new CommandException("Change language parameters are incorrect!");
        }

        Language language = Language.valueOf(languageName.toUpperCase());
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(SessionAttribute.LANGUAGE.getName(), language);
        return pageName;
    }
}
