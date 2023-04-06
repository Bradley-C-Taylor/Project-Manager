package com.projectmanager.server.service;

import com.projectmanager.server.dao.EndpointDao;
import com.projectmanager.server.model.Endpoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndpointServiceImp implements EndpointService{

   private EndpointDao endpointDao;

   public EndpointServiceImp(EndpointDao endpointDao) {
      this.endpointDao = endpointDao;
   }


   @Override
   public List<Endpoint> getEndpoints(String name, Integer projectId) {
      List<Endpoint> endpoints;
      if(name.equals("") && projectId == null) {
         endpoints = null;
      } else if(projectId == null) {
         endpoints = endpointDao.getAllEndpointsByName(name);
      } else {
         endpoints = endpointDao.getAllEndpointsById(projectId);
      }
      return endpoints;
   }
}
