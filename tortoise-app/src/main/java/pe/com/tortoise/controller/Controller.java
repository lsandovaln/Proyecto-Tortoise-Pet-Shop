package pe.com.tortoise.controller;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

public class Controller {
    
    public static void main(String[] args) {
        port(7777);
        get("/", (request, response) -> {
            response.redirect("Catalogo");
            return null;
        });
        
        get("/Catalogo", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Productos", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Categorias", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Productos/Registrar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Categorias/Registrar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        post("/Mantenimiento/Productos/Registrar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        post("/Mantenimiento/Categorias/Registrar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Productos/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Categorias/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        post("/Mantenimiento/Productos/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        post("/Mantenimiento/Categorias/Actualizar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Productos/Eliminar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
        
        get("/Mantenimiento/Categorias/Eliminar/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());
    }
    
}
