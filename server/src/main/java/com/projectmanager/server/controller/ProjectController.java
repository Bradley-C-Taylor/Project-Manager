package com.projectmanager.server.controller;

import com.projectmanager.server.model.Endpoint;
import com.projectmanager.server.service.EndpointService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
public class ProjectController {

   private EndpointService service;

   public ProjectController(EndpointService endpointService) {
      this.service = endpointService;
   }

   /**
    * Endpoint for getting a list of all endpoints for the specified project
    * @param name Project Name (optional)
    * @param id Project ID (optional)
    * @return list of all endpoints for the given project
    */
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
