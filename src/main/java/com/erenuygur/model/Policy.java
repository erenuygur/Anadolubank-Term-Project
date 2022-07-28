package com.erenuygur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "policy")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="status", nullable = false)
    private boolean status;

    public String toString() {
        return String.format("id: %d-name: %s-status: %s", this.id, this.name, this.status);
    }

}
