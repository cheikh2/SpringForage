package com.sid.web;

import com.sid.service.UserService;
import com.sid.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistration(){
        return "user/registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
    /*@Autowired
    private UserRepository userRepository;

    @RequestMapping(value="user")
    public String allUser(Model model){
        List<User> users=userRepository.findAll();
        model.addAttribute("listUsers",users);
        return "user/users";
        /*
        public String allClient(Model model,
                            @RequestParam(name = "page", defaultValue = "0") int p,
                            @RequestParam(name = "size", defaultValue = "5") int s) {
        Page<Client> pageClients;
        pageClients = clientRepository.findAll(new PageRequest(p, s));

        model.addAttribute("listClients", pageClients.getContent());
        int[] pages = new int[pageClients.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourant",p);
        return "clients";
    }

    }*/
    /*@RequestMapping(value = "/delete2", method = RequestMethod.GET)
    public String delete(Long id){
        userRepository.deleteById(id);
        return "redirect:/user";
    }

    // chargement du formulaire d'ajout de client
   /* @RequestMapping(value="/formUser", method = RequestMethod.GET)
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "user/addUser";
    }

    // methode d'ajout de client
   /* @RequestMapping(value="/saveU", method=RequestMethod.POST)
    public String save(Model model, User user){
        userRepository.save(user);
        return "redirect:/user";
    }*/
}
