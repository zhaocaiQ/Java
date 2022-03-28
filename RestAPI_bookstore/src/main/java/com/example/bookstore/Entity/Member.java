package com.example.bookstore.Entity;

import com.example.bookstore.domain.MemberStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @JsonBackReference
    @OneToMany(mappedBy = "member",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lend> lends;
}