package com.company.clinapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {


    private User user;
    private String token;

    public JwtResponse(String token) {
        this.token=token;
    }
}
