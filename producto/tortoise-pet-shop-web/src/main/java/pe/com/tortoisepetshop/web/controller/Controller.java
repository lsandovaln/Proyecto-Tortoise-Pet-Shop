package pe.com.tortoisepetshop.web.controller;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

public class Controller {
    
    public static void main(String[] args) {
        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
    }
    
}
