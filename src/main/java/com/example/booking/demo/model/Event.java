package com.example.booking.demo.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.yaml.snakeyaml.tokens.ScalarToken;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Accessors(chain = true)
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;



}
