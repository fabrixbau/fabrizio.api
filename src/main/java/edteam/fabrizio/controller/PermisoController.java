package edteam.fabrizio.controller;

import edteam.fabrizio.models.Permiso;
import edteam.fabrizio.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("permiso")
public class PermisoController {

    @Autowired
    PermisoService permisoService;

    // Trae todos los usuarios
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permiso> getAll() {
        return permisoService.getAll();
    }

    // Trae usuario por Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permiso get(@PathVariable long id) {
        return permisoService.get(id);
    }

    // Registrar usuario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permiso register(@RequestBody Permiso permiso ) {
        return permisoService.register(permiso);
    }

    //Actualizar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Permiso update(@RequestBody Permiso permiso) {
        return permisoService.update(permiso);
    }


    // Eliminar
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id){
        permisoService.delete(id);
    }
    
}
