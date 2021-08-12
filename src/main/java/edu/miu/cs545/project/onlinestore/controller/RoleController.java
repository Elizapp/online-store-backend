package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.domain.Role;
import edu.miu.cs545.project.onlinestore.dto.RoleDTO;
import edu.miu.cs545.project.onlinestore.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<RoleDTO> getAll(){

        List<Role> roles = roleService.findAll();
        return roles.stream().map(r->modelMapper.map(r, RoleDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable("id") Long id){

        Role role = roleService.findRoleById(id);
        return modelMapper.map(role, RoleDTO.class);
    }

    @GetMapping("/role")
    public RoleDTO getRoleByName(@RequestParam("name") String name){

        Role role = roleService.findRoleByName(name);
        return modelMapper.map(role, RoleDTO.class);
    }

}
