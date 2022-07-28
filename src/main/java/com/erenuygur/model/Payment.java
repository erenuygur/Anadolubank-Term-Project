package com.erenuygur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "customer_policy_id", nullable = false)
    private long customerPolicyId;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "payment_amount", nullable = false)
    private double paymentAmount;
}

