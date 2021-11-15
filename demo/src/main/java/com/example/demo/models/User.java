package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name="usr")
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String test_role;

    private boolean active;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Set<Word> words;

    @Enumerated(EnumType.STRING)
    private Role role;


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
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
