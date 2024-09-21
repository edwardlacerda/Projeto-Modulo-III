
package com.project.DevHotel.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservaViewController {

    @GetMapping("/devhotel")
    public String exibirIndexHtml() {
        return "index"; 
    }

    @GetMapping("/view")
    public String exibirReservasHtml() {
        return "reservas"; 
    }
}
