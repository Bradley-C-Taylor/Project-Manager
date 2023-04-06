package com.projectmanager.server.dao;

import com.projectmanager.server.model.Endpoint;

import java.util.List;

public interface EndpointDao {
   List<Endpoint> getAllEndpointsById(Integer projectId);
   List<Endpoint> getAllEndpointsByName(String name);
}
