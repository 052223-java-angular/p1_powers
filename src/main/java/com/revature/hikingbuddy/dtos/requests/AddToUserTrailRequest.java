package com.revature.hikingbuddy.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddToUserTrailRequest {
    private String trail_name;
    private String user_id;
}
