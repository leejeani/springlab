package com.kbstar.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Cust {
    private String id;
    @Size(min=5,max=20,message = "아이디는 5개이상")
    private String pwd;
    @Email
    private String name;
}
