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
   public List<Endpoint> getEndpoints() {
      List<Endpoint> endpoints;
      return null;
   }
}
