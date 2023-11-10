package by.your_anime_list.controller;

import by.your_anime_list.bean.User;
import by.your_anime_list.bean.UserPrivilegeRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class RequestProcessor {
    private void setRole(HttpServletRequest req) {
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute(SessionAttribute.USER.getName());
        if (user == null) {
            req.setAttribute(RequestAttribute.PRIVILEGE_ROLE.getName(),
                    UserPrivilegeRole.VISITOR.getName());
        } else {
            req.setAttribute(RequestAttribute.PRIVILEGE_ROLE.getName(),
                    user.getUserPrivilegeRole().getName());
        }
    }

    private void setCurrPageName(HttpServletRequest req) {
        String currPageName = req.getRequestURL() + "?" + req.getQueryString();

        req.setAttribute(RequestParameter.CURR_PAGE_NAME.getName(), currPageName);
    }

    public void process(HttpServletRequest req) {
        setRole(req);
        setCurrPageName(req);
    }
}
