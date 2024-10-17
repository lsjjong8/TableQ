package com.itschool.tableq.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String nickName;

    @Column(nullable = false, unique = true)
    private String phone_Number;

    @Column(updatable = false)
    private Timestamp created_at;

    @Column
    private Timestamp last_login_at;

    @Column
    private String address;

    @Column(nullable = false)
    private String name;

    @Column
    private String social_type;

    @Column
    private String social_id;

    @Column(nullable = false, unique = true)
    private String email;

    @Builder
    public User(long id, String email, String password, String nickName, String phoneNumber, Timestamp timestamp, Timestamp timestamp1
            , String address, String name, String socialType, String socialId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.phone_Number = phoneNumber;
        this.created_at = timestamp;
        this.last_login_at = timestamp1;
        this.address = address;
        this.name = name;
        this.social_type = socialType;
        this.social_id = socialId;
    }

/*    public User(String email, String password, String phone_Number, String name) {
        this.password = password;
        this.email = email;
        this.phone_Number = phone_Number;
        this.name = name;
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.last_login_at = new Timestamp(System.currentTimeMillis());
    }*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone_Number='" + phone_Number + '\'' +
                ", created_at=" + created_at +
                ", last_login_at=" + last_login_at +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", social_type='" + social_type + '\'' +
                ", social_id='" + social_id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
