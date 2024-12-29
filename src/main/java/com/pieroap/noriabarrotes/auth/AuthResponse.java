package com.pieroap.noriabarrotes.auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    String token;
    String username;
    String firstname;
    String lastname;
    String country;
}
