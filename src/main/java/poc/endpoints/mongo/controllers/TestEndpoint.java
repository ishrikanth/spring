package poc.endpoints.mongo.controllers;

import io.swagger.annotations.Api;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shrikanth on 8/9/16.
 */
@RestController
@Api(value = "TestEndpoint", description = "Operations pertaining to user sessions V7 endpoint.")
public class TestEndpoint {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("hello","Hi");
        return "hello-world";
    }

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
}