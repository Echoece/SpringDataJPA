package com.echo.springdatajpa.entity;


import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides(
        {
            @AttributeOverride(
                    name = "name",
                    column = @Column(name = "guardian_name")
            ),
            @AttributeOverride(
                    name = "email",
                    column = @Column(name = "guardian_email")
            ),
            @AttributeOverride(
                    name = "mobile",
                    column = @Column(name = "guardian_mobile")
            )
        }
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
