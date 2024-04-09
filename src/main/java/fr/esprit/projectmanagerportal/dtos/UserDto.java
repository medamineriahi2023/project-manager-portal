package fr.esprit.projectmanagerportal.dtos;

import lombok.Data;

@Data
public class UserDto {
   private String userId;
   private String firstName;
   private String lastName;
   private String email;
   private String userName;
}
