package pe.isil.moduloseguridad.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){

        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);

        return "user/index";
    }

    @GetMapping("/create")
    public String createView(Model model){
        return "user/create";
    }

    @PostMapping ("/create")
    public String createUser(Model model, User user){
        userService.createUser(user);
        return "user/index";
    }



    public String updateUser(){
        return "user/update";
    }
}
