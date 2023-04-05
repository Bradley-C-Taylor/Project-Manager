package com.projectmanager.server.dao;

import com.projectmanager.server.model.Endpoint;

import java.util.List;

public interface EndpointDao {
   List<Endpoint> getAllEndpoints();
}
