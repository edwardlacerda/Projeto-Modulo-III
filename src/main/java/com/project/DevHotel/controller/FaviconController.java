
package com.project.DevHotel.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FaviconController {
    @RequestMapping("favicon.ico")
    @ResponseBody
    void favicon() {
        // Não retorna nada para suprimir a busca por favicon
    }
}
