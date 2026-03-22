package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.RequestToViewNameTranslator;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final RequestToViewNameTranslator requestToViewNameTranslator;

    public UserController(UserService service, RequestToViewNameTranslator requestToViewNameTranslator) {
        this.service = service;
        this.requestToViewNameTranslator = requestToViewNameTranslator;
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("users", service.getAll());
        return "users.html";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "create.html";
    }

    @PostMapping
    public String create(@ModelAttribute User user) {
        service.save(user);
        return "redirect:/users";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("user", service.getById(id));
        return "edit.html";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute User user) {
        service.update(user);
        return "redirect:/users";

    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/users";

    }
}
