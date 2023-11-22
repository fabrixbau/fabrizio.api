package edteam.fabrizio.services;

import edteam.fabrizio.dao.PermisoDao;
import edteam.fabrizio.models.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PermisoService {
    @Autowired
    PermisoDao permisoDao;

    public List<Permiso> getAll() {
        return permisoDao.getAll();
    }

    public Permiso get(long id) {
        return permisoDao.get(id);
    }


    public Permiso register(Permiso permiso ) {
        return permisoDao.register(permiso);
    }

    public Permiso update(@RequestBody Permiso permiso){
        return permisoDao.update(permiso);
    }

    public void delete(@PathVariable long id){
        permisoDao.delete(id);
    }

}
