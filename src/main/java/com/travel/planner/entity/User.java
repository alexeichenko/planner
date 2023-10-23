package com.travel.planner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "planer")
@Component
@Scope("prototype")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String password;
    // Roles mapping
    @ManyToMany
    @JoinTable(
            name = "user_roles", schema = "planer",
            joinColumns = {
                    @JoinColumn(
                            name = "user_id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "role_id",
                            nullable = false
                    )
            }

    )
    @JsonIgnore
    private List<Role> roleList = new ArrayList<>();
    // Trips mapping
    @ManyToMany
    @JoinTable(
            name = "user_trips", schema = "planer",
            joinColumns = {
                    @JoinColumn(
                            name = "user_id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "trip_id",
                            nullable = false
                    )
            }

    )
    @JsonIgnore
    private List<Trip> tripList = new ArrayList<>();
}
