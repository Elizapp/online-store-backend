package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findRoleByName(String name);
    Role findRoleById(Long id);
}
