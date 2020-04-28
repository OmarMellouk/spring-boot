package org.sid.web;


import org.sid.entities.Auth;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class AuthRestRepository {

    @GetMapping(path = "/basicauth")
    public Auth basicauth() {
        return new Auth("You are authenticated");
    }
}
