package com.example.appapuestasjava;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Usuario {

private Long id_Usuario;
private String nombre;
private String email;
private String password;
private int estado;
private int saldo;


}
