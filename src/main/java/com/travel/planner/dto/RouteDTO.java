package com.travel.planner.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class RouteDTO {
    private long id;
    private String name;
    private String description;
}
