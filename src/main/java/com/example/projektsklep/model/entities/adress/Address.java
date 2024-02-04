package com.example.projektsklep.model.entities.adress;

import com.example.projektsklep.model.entities.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String postalCode;
    private String country;





    public Address(String s, String s2, String s1, String s3) {

    }

    @Column(name = "user_id") // Assuming a relationship with User exists
    private Long userId; // Przechowuje ID powiązanego użytkownika




    public User getUser() {
     return null;
    }

    public void setUser(User user) {
        this.userId = user.getId(); // Set foreign key based on User ID
    }
}

