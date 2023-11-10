package by.your_anime_list.controller;

import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.CommandHelper;
import by.your_anime_list.controller.command.exception.CommandException;
import by.your_anime_list.service.exception.ServiceException;
import by.your_anime_list.view.PageLocalizer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
@MultipartConfig
public class Controller extends HttpServlet {
    @Override
    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver class not found...");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName;
        try {
            pageName = processRequest(request, response);
        } catch ( Exception e ) {
            pageName = JspPage.ERROR_PAGE.getName();
        }

        RequestProcessor requestProcessor = new RequestProcessor();
        requestProcessor.process(request);

        PageLocalizer pageLocalizer = new PageLocalizer();
        try {
            pageLocalizer.localize(request);
        } catch (ServiceException e) {
            errorMessageDirectlyFromResponse(response);
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        } else {
            errorMessageDirectlyFromResponse(response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String redirectAddress;
        try {
            redirectAddress = processRequest(request, response);
        } catch ( Exception e ) {
            redirectAddress = RedirectAddress.ERROR.getAddress();
        }

        response.sendRedirect(redirectAddress);
    }

    private String processRequest(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String commandName =
                request.getParameter(RequestParameter.COMMAND_NAME.getName());
        System.out.println("Last command name = " + commandName);
        Command command = CommandHelper.getInstance().getCommand(commandName);
        return command.execute(request);
    }

    private void errorMessageDirectlyFromResponse(HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("E R R O R");
    }
}
