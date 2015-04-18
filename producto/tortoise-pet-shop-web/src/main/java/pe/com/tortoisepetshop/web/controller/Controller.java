package pe.com.tortoisepetshop.web.controller;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

public class Controller {
    int b = 0;
    
    public static void main(String[] args) {
        get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");
            return new ModelAndView(attributes, "hello.ftl");
            int GGGG;
        }, new FreeMarkerEngine());
    }
    
}
