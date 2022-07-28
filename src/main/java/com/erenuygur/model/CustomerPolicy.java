package com.erenuygur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer_policy")
public class CustomerPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="customer_id", nullable = false)
    private long customerId;

    @Column(name="agency_id", nullable = false)
    private long agencyId;

    @Column(name="policy_id", nullable = false)
    private long policyId;

    @Column(name="date", nullable = false)
    private Date date;

    @Column(name="insurance_amount", nullable = false)
    private double insuranceAmount;

    @Column(name="is_active", nullable = false)
    private boolean isActive;

    public String toString() {
        return String.format("%d %d %d %s %f ", id, customerId, policyId, date.toString(), insuranceAmount);
    }
}
