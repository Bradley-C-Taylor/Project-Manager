package com.projectmanager.server.controller;

import com.projectmanager.server.model.Endpoint;
import com.projectmanager.server.service.EndpointService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@PreAuthorize("permitAll")
@RestController
public class ProjectController {

   private EndpointService service;

   public ProjectController(EndpointService endpointService) {
      this.service = endpointService;
   }

   @GetMapping("/endpoints")
   public List<Endpoint> getEndpoints(@RequestParam(defaultValue = "")String name,
                                      @RequestParam(required = false)Integer id) {
      List<Endpoint> endpoints = service.getEndpoints(name, id);
      if(endpoints == null) {
         throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No endpoints for that project");
      }
      return endpoints;
   }
}
