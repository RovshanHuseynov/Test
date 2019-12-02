package web.cookie;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class HistoryServlet extends HttpServlet {
    private final TemplateEngine engine;

    public HistoryServlet(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("History doGet");
        HashMap<String, Object> data = new HashMap<>();
        engine.render("history_Logged.ftl", data, resp);

        Path path = Paths.get("./content/template/history_Logged.ftl");
        ServletOutputStream os = resp.getOutputStream();
        Files.copy(path, os);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("History doPost");
    }
}