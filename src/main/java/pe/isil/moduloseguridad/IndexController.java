package pe.isil.moduloseguridad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class IndexController {

    @GetMapping(value = {"/","/index","/login"})
    public String index(Model model){
        return "index";
    }


    @PostMapping("/login")
    public String login(Model model, @RequestParam String username,
                        @RequestParam String pass){

        UserDao userDao = new UserDao();
        try{
            List<User> userList = userDao.getall();
            model.addAttribute("listuser",userList);
            model.addAttribute("name",userDao.loginUser(username,pass));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "usuario";
    }



}
