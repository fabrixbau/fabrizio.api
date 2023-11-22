package edteam.fabrizio.dao.imp;


import edteam.fabrizio.dao.PermisoDao;
import edteam.fabrizio.models.Permiso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PermisoDaoImp implements PermisoDao {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @Override
    public List<Permiso> getAll() {
        String hql = "FROM Permiso as u ";
        return (List<Permiso>) entityManager.createQuery(hql).getResultList();
    }
    @Transactional
    @Override
    public Permiso get(long id){
        return entityManager.find(Permiso.class, id);
    }


    @Transactional
    @Override
    public Permiso register(Permiso permiso){
        entityManager.merge(permiso);
        return permiso;
    }


    @Transactional
    @Override
    public Permiso update(Permiso permiso){
        entityManager.merge(permiso);
        return permiso;
    }

    @Transactional
    @Override
    public void delete(long id){
        Permiso permiso = get(id);
        entityManager.remove(permiso);
    }


}
