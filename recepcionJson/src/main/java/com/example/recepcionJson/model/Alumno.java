package com.example.recepcionJson.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alumno {

    private String nombre;

    private String apellido;

    private Integer edad;

    private Boolean egresado;

    public String printearEgreso(){
        if(egresado){
            return egresado.toString() + " :D";
        }else{
            return egresado.toString() + " (Por ahora)";
        }
    }
    public void printear(){
        System.out.println(
                this.getNombre() + " " + this.getApellido()
                + " de " + this.getEdad() + " años "
                + " ¿se recibió? -> " + this.printearEgreso()
        );
    }
}
