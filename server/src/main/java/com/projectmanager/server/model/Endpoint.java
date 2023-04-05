package com.projectmanager.server.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Endpoint {

   private int id;
   private String url;
   private String method;
   private List<Param> params = new ArrayList<>();

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public String getMethod() {
      return method;
   }

   public void setMethod(String method) {
      this.method = method;
   }

   public List<Param> getParams() {
      return params;
   }

   public void setParams(List<Param> params) {
      this.params = params;
   }

   public void addParam(Param param) {
      this.params.add(param);
   }

   @Override
   public String toString() {
      return "Endpoint{" +
              "id=" + id +
              ", url='" + url + '\'' +
              ", method='" + method + '\'' +
              ", params=" + params +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Endpoint endpoint = (Endpoint) o;
      return id == endpoint.id && url.equals(endpoint.url) && method.equals(endpoint.method) && params.equals(endpoint.params);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, url, method, params);
   }
}
