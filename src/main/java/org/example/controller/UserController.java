package org.example.controller;

import org.example.user.User;
import org.example.user.UserResponse;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {
    private final ArrayList<User> userArrayList = new ArrayList<>();

    @GetMapping("/users")
    public ResponseEntity<Object> getUsers() {
        if (userArrayList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserResponse("Not Found", "404"));
        }
        return ResponseEntity.ok().body(new UserResponse(userArrayList, "Data fetch Successfully."));
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> postUser(@RequestBody User payload) {

        boolean isValid = payload.isEqual(payload);
        userArrayList.add(payload);
        HttpStatus status = isValid ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        String message = isValid ? "Data saved successfully." : "Invalid user data.";
        String code = isValid ? "201" : "400";
        return ResponseEntity.status(status).body(new UserResponse(message, code));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserResponse> getDelete(@Param("id") int id, @RequestHeader String Accept) {
        boolean isDeleted = userArrayList.removeIf(user -> user.getId() == id);
        if (isDeleted) {
            return ResponseEntity.ok().body(new UserResponse("Delete User Successfully", "200"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserResponse("Not Found", "404"));
    }
}
