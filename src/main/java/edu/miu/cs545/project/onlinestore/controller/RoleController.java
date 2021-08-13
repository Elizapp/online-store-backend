package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.domain.Role;
import edu.miu.cs545.project.onlinestore.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    IRoleService roleService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        Collection<Role> roles = roleService.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable("id") Long id) {

        Role role = roleService.findRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @GetMapping("/role")
    public ResponseEntity<?> getRoleByName(@RequestParam("name") String name) {
        Role role = roleService.findRoleByName(name);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

}
