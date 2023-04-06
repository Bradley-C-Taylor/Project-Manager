package com.projectmanager.server.dao;

import com.projectmanager.server.model.Endpoint;
import com.projectmanager.server.model.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEndpointDao implements EndpointDao{

   private JdbcTemplate jdbcTemplate;

   public JdbcEndpointDao(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public List<Endpoint> getAllEndpointsById(Integer projectId) {
      List<Endpoint> endpointList = new ArrayList<>();
      String sqlQuery = "SELECT e.endpoint_id, e.endpoint_url, e.endpoint_method, ep.param_id, ep.param_name, ep.param_description, ep.param_optional " +
              "FROM endpoint e JOIN project p ON e.project_id = p.project_id " +
              "LEFT JOIN endpoint_param ep ON e.endpoint_id = ep.endpoint_id " +
              "WHERE p.project_id = ?;";
      SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlQuery);
      while(rowSet.next()) {
         mapRowToEndpoint(rowSet, endpointList);
      }
      return endpointList;
   }

   @Override
   public List<Endpoint> getAllEndpointsByName(String name) {
      String sqlQuery = "SELECT e.endpoint_url, e.endpoint_method, ep.param_name, ep.param_description, ep.param_optional " +
              "FROM endpoint e JOIN project p ON e.project_id = p.project_id " +
              "LEFT JOIN endpoint_param ep ON e.endpoint_id = ep.endpoint_id " +
              "WHERE p.project_name = ?;";
      return null;
   }

   private Endpoint mapRowToEndpoint(SqlRowSet rowSet, List<Endpoint> endpointList) {
      Endpoint point = new Endpoint();
      point.setId(rowSet.getInt("endpoint_id"));
      point.setUrl(rowSet.getString("endpoint_url"));
      point.setMethod(rowSet.getString("endpoint_method"));
      if(endpointList.contains(point)) {
         //Add Params to existing

      } else {
         //Add Params to newly created
         point.addParam(mapRowToParam(rowSet));
      }

      return point;
   }
   private Param mapRowToParam(SqlRowSet rowSet) {
      Param param = new Param();
      param.setId(rowSet.getInt("param_id"));
      param.setName(rowSet.getString("param_name"));
      param.setDescription(rowSet.getString("param_description"));
      param.setOptional(rowSet.getBoolean("param_optional"));
      return param;
   }
}
