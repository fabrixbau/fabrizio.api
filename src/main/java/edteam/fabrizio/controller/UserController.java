package edteam.fabrizio.controller;

import edteam.fabrizio.models.User;
import edteam.fabrizio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    // Trae todos los usuarios
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getAll() {
        return userService.getAll();
    }

    // Trae usuario por Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User get(@PathVariable long id) {
        return userService.get(id);
    }

    // Registrar usuario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    User register(@RequestBody User user ) {
        return userService.register(user);
    }

    //Actualizar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User update(@RequestBody User user) {
        return userService.update(user);
    }


    // Eliminar
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id){
        userService.delete(id);
    }

}
