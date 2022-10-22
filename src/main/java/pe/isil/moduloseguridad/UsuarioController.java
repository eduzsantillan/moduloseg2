package pe.isil.moduloseguridad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioController {

    @GetMapping("/getall")
    public String getall(Model model){;


        UserDao dao = new UserDao();

        try{
            List<User> userList = dao.getall();
            model.addAttribute("listuser",userList);
            return "usuario";
        }catch (Exception e)
        {
            model.addAttribute("response",e.toString());
            return "response";
        }






    }
}
