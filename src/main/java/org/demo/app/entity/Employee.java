package org.demo.app.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "EMPLOYEE_SEQUENCE")
    @SequenceGenerator(name = "EMPLOYEE_SEQUENCE", sequenceName = "EMPLOYEE_SEQUENCE", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;
    @Column(name = "email", unique = true, nullable = false, length = 70)
    private String email;

    @Column(name = "salary", nullable = false, precision = 10)
    private BigDecimal salary;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "JOIN_DATE", nullable = true)
    private Date joinDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

}


