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

public class CalculateServlet extends HttpServlet {
    private final TemplateEngine engine;

    public CalculateServlet(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Calculate doGet");
        HashMap<String, Object> data = new HashMap<>();
        engine.render("calc_Logged.ftl", data, resp);

        Path path = Paths.get("./content/template/calc_Logged.ftl");
        ServletOutputStream os = resp.getOutputStream();
        Files.copy(path, os);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Calculate doPost");
    }
}