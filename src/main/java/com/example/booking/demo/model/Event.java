package com.example.booking.demo.model;


import com.example.booking.demo.enums.EventStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Accessors(chain = true)
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "duration")
    private int duration;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "booked_capacity")
    private Long bookedCapacity = 0L;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EventStatus status = EventStatus.UPCOMING;

    @ManyToOne
    @JoinColumn(name = "location_sub_manager_id")
    private LocationSubManager locationSubManager;

    @ManyToOne
    @JoinColumn(name = "sub_location_id")
    private SubLocation subLocation;

    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER)
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
}
