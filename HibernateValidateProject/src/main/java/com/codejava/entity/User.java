package com.codejava.entity;

import com.codejava.annotation.Phone;
import com.codejava.annotation.UserId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @UserId
    private String id;

    @NotNull(message = "Thieu username")
    private String name;

    @NotNull(message = "Thieu email")
    @Email(message = "Email khong hop le")
    private String email;

    @NotEmpty(message = "Thieu sdt")
    @Phone
    private String phone;

    @Min(0)
    @Max(100)
    private Integer age;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past
    private Date dateOfBirth;
}
