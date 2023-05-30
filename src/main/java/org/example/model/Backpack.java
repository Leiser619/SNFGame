package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "backpack")
@Data
public class Backpack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int maxSpace;
    private int  currentSpace;
}
