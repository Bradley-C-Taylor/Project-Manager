package com.projectmanager.server.dao;

import com.projectmanager.server.model.Endpoint;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcEndpointDao implements EndpointDao{

   private JdbcTemplate jdbcTemplate;

   public JdbcEndpointDao(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public List<Endpoint> getAllEndpoints() {
      return null;
   }
}
