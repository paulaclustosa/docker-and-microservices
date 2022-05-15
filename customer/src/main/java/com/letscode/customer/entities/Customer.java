package com.letscode.customer.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customer", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name="name")
  private String name;
  @Column(name="username")
  private String username;
  @Column(name="email")
  private String email;
  @Column(name="password")
  private String password;
  @Column(name="public_id")
  private UUID publicId;

  @Builder
  public Customer(String firstName, String lastName, String username, String email, String password) {
    this.name = firstName + ' ' + lastName;
    this.username = username;
    this.email = email;
    this.password = password;
    this.publicId = UUID.randomUUID();
  }
}
