package com.example.recepcionJson.receptores;

import com.example.recepcionJson.model.Alumno;
import com.example.recepcionJson.model.Regional;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReceptorRegional {

    public Regional recibirRegional(String regionalString){
        Regional regional = new Regional();

        JSONObject JSONregional = new JSONObject(regionalString);
        JSONArray JSONArrayAlumnos = JSONregional.getJSONArray("alumnos");

        regional.setNombre((String) JSONregional.get("nombre"));

        for(int i = 0; i < JSONArrayAlumnos.length(); i++){
            JSONObject JSONalumno = (JSONObject) JSONArrayAlumnos.get(i);
            Alumno alumno = new Alumno();

            alumno.setNombre(JSONalumno.getString("nombre"));
            alumno.setApellido(JSONalumno.getString("apellido"));
            alumno.setEdad(JSONalumno.getInt("edad"));
            alumno.setEgresado(JSONalumno.getBoolean("egresado"));

            regional.agregarAlumno(alumno);
        }

        return regional;
    }
}
