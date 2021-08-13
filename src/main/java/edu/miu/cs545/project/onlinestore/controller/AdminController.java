package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;

    @GetMapping("/approve")
    public ResponseEntity<?> approveSeller(@RequestParam("seller") Long id) {
        return new ResponseEntity<>(adminService.approveSeller(id), HttpStatus.OK);
    }
}