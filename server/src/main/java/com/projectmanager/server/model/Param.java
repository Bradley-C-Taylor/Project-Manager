package com.projectmanager.server.model;

import java.util.Objects;

public class Param {

   private int id;
   private String name;
   private String description;
   private boolean optional = false;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public boolean isOptional() {
      return optional;
   }

   public void setOptional(boolean optional) {
      this.optional = optional;
   }

   @Override
   public String toString() {
      return "Param{" +
              "id=" + id +
              ", name=" + name +
              ", description=" + description +
              ", optional=" + optional +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Param param = (Param) o;
      return id == param.id && name == param.name && description == param.description && optional == param.optional;
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name, description, optional);
   }
}
