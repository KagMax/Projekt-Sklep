package com.example.projektsklep.model.entities.user;


import com.example.projektsklep.model.entities.adress.Address;
import com.example.projektsklep.model.entities.order.Order;
import com.example.projektsklep.model.entities.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import java.util.HashSet;

import java.util.Date;
import java.util.Set;
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String email;

    @Column(name = "first_name", unique = true)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password_hash")
    private String passwordHash;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "avatar_path")
    private String avatarPath;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Role> roles;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // poniżej były problemy ze słowem zastrzeżonym user i musiałem zamienić accountHolder
    @OneToMany(mappedBy = "accountHolder")
    private Set<Order> orders;

    public User(String email, String passwordHash, String avatarPath, String firstName, String lastName) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.avatarPath = avatarPath;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void addOrder(Order order) {
        if (orders == null) {
            orders = new HashSet<>(); // Zainicjuj, jeśli null
        }
        orders.add(order);
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

