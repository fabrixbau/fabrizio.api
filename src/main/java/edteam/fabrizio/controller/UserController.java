package edteam.fabrizio.controller;

import edteam.fabrizio.models.User;
import edteam.fabrizio.services.UserService;
import edteam.fabrizio.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private JWTUtil jwtUtil;

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
    void register(@RequestBody User user ) {
        userService.register(user);
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String, Object> login(@RequestBody User dto) {
        User user = userService.login(dto);

        Map<String, Object> result = new HashMap<>();
        if (user != null) {
            String token = jwtUtil.create(String.valueOf(user.getId()), user.getEmail());
            result.put("token", token);
            result.put("user", user);
        }
        return result;
    }

}
