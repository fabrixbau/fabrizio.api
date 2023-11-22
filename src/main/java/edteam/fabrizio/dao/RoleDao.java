package edteam.fabrizio.dao;

import edteam.fabrizio.models.Role;
import java.util.List;

public interface RoleDao {

    List<Role> getAll();
    Role get(long id);
    Role register(Role role);
    Role update(Role role);
    void delete(long id);
    
}
