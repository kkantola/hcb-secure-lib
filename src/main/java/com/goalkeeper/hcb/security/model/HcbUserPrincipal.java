package com.goalkeeper.hcb.security.model;

import java.util.Collection; 
import java.util.Objects; 

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HcbUserPrincipal implements UserDetails {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -4279984342582307630L;

	private String id;

    private String name;

    private String username; 

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public HcbUserPrincipal(String id, String name, String username,  String password,Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username; 
        this.password = password; 
        this.authorities = authorities;
    }

    public static HcbUserPrincipal create(User user) {
        
        return new HcbUserPrincipal(
                user.getId(),
                user.getFirstName(),
                user.getMobileNumber(), 
                user.getPassword(),
                user.getAuthorities()
        );
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
 
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HcbUserPrincipal that = (HcbUserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}