package edu.binar.challenge.MyCinemaMicroservices.AuthService.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@JsonIgnoreProperties(
        value = {"userId"},
        allowGetters = true
)

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    @JsonProperty("userId")
    @JsonIgnore
    private Long userId;

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("username")
    @NotNull
    private String username;

    @JsonProperty("email")
    @NotNull
    private String email;

    @JsonProperty("password")
    @NotNull
    private String password;

    @JsonProperty("phone")
    @NotNull
    private String phone;

    @JsonProperty("role")
    @NotNull
    private String role;
}
