package org.demo.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "APP_EXCEPTION")
public class AppException {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String code;
    private String message;
    private String localizedMessage;

}


