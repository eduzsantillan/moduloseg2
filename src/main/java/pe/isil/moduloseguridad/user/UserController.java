package pe.isil.moduloseguridad.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        try{
            userService.createUser(user);
            Response response = Response.builder()
                    .code("200")
                    .message("Usuario creado correctamente")
                    .build();

            model.addAttribute("resp",response);
        }catch (Exception e){
            Response response = Response.builder()
                    .code("500")
                    .message("Error al crear usuario ".concat(e.getMessage()))
                    .build();
            model.addAttribute("resp",response);
        }

        return "redirect:/user/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/update";
    }

    @PostMapping("/update")
    public String updateUser(User userToUpdate, Model model){
        userService.updateUser(userToUpdate,userToUpdate.getId());
        return "redirect:/user/";
    }


    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id, Model model){
        userService.deleteUser(id);
        return "redirect:/user/";
    }



    @Data
    @Builder
    public static class Response {
        String code;
        String message;
    }






}
