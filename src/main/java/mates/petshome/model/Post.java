package mates.petshome.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String contactPhone;
    @Column(nullable = false)
    private String text;
    private String imageUrl;
    @Column(nullable = false)
    private boolean isApproved;
    @Column(nullable = false)
    private boolean isDeleted;
}
