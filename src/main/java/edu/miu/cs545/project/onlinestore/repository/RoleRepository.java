package edu.miu.cs545.project.onlinestore.repository;

import edu.miu.cs545.project.onlinestore.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
    public List<Role> findAll();
    public Role findRoleById(Long id);
    public Role findRoleByName(String name);
    public List<Role> findRolesByIdIn(List<Long> Ids);
}
