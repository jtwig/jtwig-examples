package org.jtwig.example;

import com.google.common.collect.ImmutableMap;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorldServlet extends HttpServlet {
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("variable", "Hello");

        renderer.dispatcherFor("/WEB-INF/templates/index.twig.html")
                .with("name", "Jtwig")
                .render(request, response);
    }
}
