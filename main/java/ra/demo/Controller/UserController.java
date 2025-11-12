package ra.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.demo.Model.dto.UserLoginDTO;
import ra.demo.Model.dto.UserRegisterDTO;
import ra.demo.Model.entity.User;
import ra.demo.Model.entity.UserLogin;
import ra.demo.Service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userLogin", new UserLogin());
        return "auth/login";
    }

    @PostMapping("/login")
    public String handleLogin(HttpServletResponse response, @Valid @ModelAttribute UserLoginDTO userLogin, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userLogin", userLogin);
            return "auth/login";
        }
        User user = userService.login(userLogin);
        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/";
        } else {
            model.addAttribute("userLogin", userLogin);
            model.addAttribute("error", "Invalid username or password");
            return "auth/login";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userRegisterDTO", new UserRegisterDTO());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute UserRegisterDTO userRegisterDTO, BindingResult bindingResult, Model model) {
        if (userRegisterDTO.getAvatar() == null || userRegisterDTO.getAvatar().isEmpty()) {
            bindingResult.rejectValue("avatar", "error.avatar.empty", "avatar is empty");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("userRegisterDTO", userRegisterDTO);
            return "auth/register";
        }
        User user = userService.register(userRegisterDTO);
        if (user != null) {
            return "redirect:/auth/login";
        }else {
            model.addAttribute("message", "error");
            return "auth/register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        userService.logout();
        return "redirect:/auth/login";
    }
}
