package web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.User;
import web.Service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(ModelMap model) {
        if(userService.getAllUsers().isEmpty()) {
            return "zeroPage";
        } else {
            List<User> users = new ArrayList<>();
            for(User user: userService.getAllUsers()) {
                users.add(user);
            }
            model.addAttribute("users", users);
            return "UsersView";
        }
    }

    @GetMapping("add")
    public String addUser() {
        return "addUser";
    }

    @PostMapping("save")
    public String saveNewUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("age") String age) {
        userService.addUser(name, email, Integer.parseInt(age));
        return "redirect:/";
    }

    @PostMapping("delete")
    public String deleteUser(@RequestParam("Id") String id) {
        userService.deleteUserById(Integer.parseInt(id));
        return "redirect:/";
    }

    @PostMapping("update")
    public String updateUser(@RequestParam("user") String Id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(Integer.parseInt(Id)));
        return "updateUser";
    }

    @PostMapping("updating")
    public String updatingUser(@RequestParam("Id") Integer id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("age") Integer age) {
        userService.updateUser(id, name, email, age);
        return "redirect:/";
    }
}
