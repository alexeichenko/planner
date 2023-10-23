package com.travel.planner.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String email;
    private String name;
}
