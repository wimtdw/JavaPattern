package com.example.lab14.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "manufactures")
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
}
