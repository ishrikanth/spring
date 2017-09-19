package poc.endpoints.mongo.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import poc.endpoints.mongo.repositories.Users;
import poc.endpoints.mongo.repositories.UsersRepository;

import java.util.List;
import java.util.Random;

/**
 * Created by shrikanth on 17/7/17.
 */
@Controller
@Api(value = "HelloMongoController", description = "Operations pertaining to user sessions V7 endpoint.")
public class HelloMongoController {
    @Autowired
    private UsersRepository userRepository;


    @RequestMapping(value = "/mongo", method = RequestMethod.GET)
    public @ResponseBody
    List<Users> helloWorld() {
        List<Users> users = userRepository.findAll();
        //throw new ResourceNotFoundException("Not Found");
        //ModelAndView modelAndView = new ModelAndView("index");
        //modelAndView.addObject("users", users );
        return users;
    }

    @RequestMapping(value = "/mongo/find", method = RequestMethod.GET)
    public @ResponseBody
    List<Users> helloWorldFind(@RequestParam(value = "name", required = false) String name) {
        List<Users> users = userRepository.findByFirstName(name);
        //ModelAndView modelAndView = new ModelAndView("index");
        //modelAndView.addObject("users", users );
        return users;
    }

    @RequestMapping(value = "/mongo", method = RequestMethod.POST)
    public @ResponseBody Users helloWorldPost() {
        Users user = new Users();
        user.setFirstName("Shrikanth");
        user.setLastName("Hathwar");
        user.setId(String.valueOf(new Random().nextInt()));
        userRepository.save(user);
        return user;
    }
}