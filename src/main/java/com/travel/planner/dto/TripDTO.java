package com.travel.planner.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class TripDTO {
    private Long id;
    private String name;
    private String description;
}
