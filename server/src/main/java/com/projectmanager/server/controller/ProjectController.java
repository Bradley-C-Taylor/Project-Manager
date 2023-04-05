package com.projectmanager.server.controller;

import com.projectmanager.server.model.Endpoint;
import com.projectmanager.server.service.EndpointService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProjectController {

   private EndpointService service;

   public ProjectController(EndpointService endpointService) {
      this.service = endpointService;
   }

   @GetMapping("/endpoints")
   public List<Endpoint> getEndpoints() {
      List<Endpoint> endpoints = service.getEndpoints();
      if(endpoints == null) {
         throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No endpoints for that project");
      }
      return endpoints;
   }
}
