package by.your_anime_list.controller;

import by.your_anime_list.bean.UserPrivilegeRole;
import by.your_anime_list.controller.command.CommandName;
import by.your_anime_list.view.Language;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@WebFilter( urlPatterns = {"/*"})
public class CommandFilter implements Filter {
    private static final HashMap<UserPrivilegeRole, Set<String>> possibleCommands = new HashMap<>();

    static {
        Set<String> visitorPossibleCommandNames = new HashSet<>();
        visitorPossibleCommandNames.add(CommandName.ANIME_LIST.name());
        visitorPossibleCommandNames.add(CommandName.ANIME.name());
        visitorPossibleCommandNames.add(CommandName.REGISTER.name());
        visitorPossibleCommandNames.add(CommandName.DO_REGISTER.name());
        visitorPossibleCommandNames.add(CommandName.LOGIN.name());
        visitorPossibleCommandNames.add(CommandName.DO_LOGIN.name());
        visitorPossibleCommandNames.add(CommandName.PROFILE.name());
        visitorPossibleCommandNames.add(CommandName.CHANGE_LANGUAGE.name());

        Set<String> userPossibleCommandNames = new HashSet<>();
        userPossibleCommandNames.add(CommandName.ANIME_LIST.name());
        userPossibleCommandNames.add(CommandName.ANIME.name());
        userPossibleCommandNames.add(CommandName.LOGOUT.name());
        userPossibleCommandNames.add(CommandName.ADD_REVIEW.name());
        userPossibleCommandNames.add(CommandName.PROFILE.name());
        userPossibleCommandNames.add(CommandName.CHANGE_LANGUAGE.name());

        Set<String> administratorPossibleCommandNames = new HashSet<>();
        administratorPossibleCommandNames.add(CommandName.ANIME_LIST.name());
        administratorPossibleCommandNames.add(CommandName.ANIME.name());
        administratorPossibleCommandNames.add(CommandName.LOGOUT.name());
        administratorPossibleCommandNames.add(CommandName.ADD_ANIME.name());
        administratorPossibleCommandNames.add(CommandName.DO_ADD_ANIME.name());
        administratorPossibleCommandNames.add(CommandName.ADD_REVIEW.name());
        administratorPossibleCommandNames.add(CommandName.PROFILE.name());
        administratorPossibleCommandNames.add(CommandName.CHANGE_LANGUAGE.name());

        possibleCommands.put(UserPrivilegeRole.VISITOR, visitorPossibleCommandNames);
        possibleCommands.put(UserPrivilegeRole.USER, userPossibleCommandNames);
        possibleCommands.put(UserPrivilegeRole.ADMINISTRATOR, administratorPossibleCommandNames);
    }

    private Language getLocale(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        Language language = (Language) httpSession.getAttribute(SessionAttribute.LANGUAGE.getName());
        if (language == null) {
            language = Language.ENGLISH;
            httpSession.setAttribute(SessionAttribute.LANGUAGE.getName(), Language.ENGLISH);
        }
        return language;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        Language language = getLocale(httpServletRequest);
        httpServletRequest.setAttribute(SessionAttribute.LANGUAGE.getName(), language.getName());
        //HttpSession httpSession = httpServletRequest.getSession();
        //User user = (User) httpSession.getAttribute("user");
        //UserPrivilegeRole userPrivilegeRole;

        //if (user == null) {
        //    userPrivilegeRole = UserPrivilegeRole.VISITOR;
        //} else {
        //    userPrivilegeRole = user.getUserPrivilegeRole();
        //}

        //String commandName = httpServletRequest.getParameter("command");
        //if (commandName == null) {
        //    ServletContext servletContext = httpServletRequest.getServletContext();
        //    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/controller?command=no_such_command");
        //    requestDispatcher.forward(httpServletRequest, httpServletResponse);
        //    return;
        //}

        //Set<String> possibleCommandNames = possibleCommands.get(userPrivilegeRole);
        //if (!possibleCommandNames.contains(commandName.toUpperCase())) {
        //    ServletContext servletContext = httpServletRequest.getServletContext();
        //    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/controller?command=no_such_command");
        //    requestDispatcher.forward(httpServletRequest, httpServletResponse);
        //    return;
        //}

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
