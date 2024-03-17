package com.example.recepcionJson.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Regional {

    @Getter
    @Setter
    private String nombre;

    @Getter
    private List<Alumno> alumnos;

    public Regional(){
        this.alumnos = new ArrayList<>();
    }

    public void agregarAlumno(Alumno alumno){
        this.alumnos.add(alumno);
    }
    
    public void printear(){
        System.out.println(
                "La regional " + this.nombre + " tiene a los alumnos : "
        );
        this.alumnos.forEach(Alumno::printear);
    }
}
