package edteam.fabrizio.controller;

import edteam.fabrizio.models.Role;
import edteam.fabrizio.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    // Trae todos los usuarios
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Role> getAll() {
        return roleService.getAll();
    }

    // Trae usuario por Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Role get(@PathVariable long id) {
        return roleService.get(id);
    }

    // Registrar usuario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Role register(@RequestBody Role role ) {
        return roleService.register(role);
    }

    //Actualizar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Role update(@RequestBody Role role) {
        return roleService.update(role);
    }


    // Eliminar
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id){
        roleService.delete(id);
    }
    
}
