package org.demo.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name = "DEPARTMENT")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DEPARTMENT_SEQUENCE")
    @SequenceGenerator(name = "DEPARTMENT_SEQUENCE", sequenceName = "DEPARTMENT_SEQUENCE", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Column(name = "code", nullable = false, length = 40)
    private String code;

}
