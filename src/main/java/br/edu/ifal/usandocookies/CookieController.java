package br.edu.ifal.usandocookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CookieController {

    @GetMapping("/")
    public String readCookie(@CookieValue(value = "username", defaultValue = "SEM") String username) {
        if (username.equals("SEM")){
            return "Faça seu cadastro!";
        }
        return "Olá! Seja bem vindo de volta: " + username;
    }
    @RequestMapping("/index")
    public ModelAndView cadastro(){
        return new ModelAndView("index");
    }

    @RequestMapping("/change-username")
    public String setCookie(HttpServletResponse response, String user) {
        // create a cookie
        Cookie cookie = new Cookie("username", user);
        // add cookie to response
        response.addCookie(cookie);
        return "Nome do usuário foi enviado no cookie!";
    }
}