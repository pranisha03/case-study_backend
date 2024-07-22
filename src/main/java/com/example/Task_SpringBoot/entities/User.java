package com.example.Task_SpringBoot.entities;

import com.example.Task_SpringBoot.dto.UserDto;
import com.example.Task_SpringBoot.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class User implements UserDetails {  // Corrected the interface name
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {  // Corrected the method name
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {  // Corrected the method name
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {  // Added the missing method
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserDto getUserDto(){
    UserDto userDto=new UserDto();
    userDto.setId(id);
    userDto.setName(name);
    userDto.setEmail(email);
    userDto.setUserRole(userRole);
        return userDto;
    }
}
