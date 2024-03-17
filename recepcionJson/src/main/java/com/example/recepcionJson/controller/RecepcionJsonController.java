package com.example.recepcionJson.controller;

import com.example.recepcionJson.model.Alumno;
import com.example.recepcionJson.model.DatoSimple;
import com.example.recepcionJson.receptores.ReceptorDato;
import com.example.recepcionJson.model.Regional;
import com.example.recepcionJson.receptores.ReceptorRegional;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class RecepcionJsonController {

    /*
    * La idea de los receptores la tome del ejercicio de Casa Segura.
    */
    private ReceptorDato receptorDato;

    private ReceptorRegional receptorRegional;

    /*
    * Cree 6 rutas:
    *
    *   1° - Encargada de demostrar como se recibe un JSON y solo printear los datos recibidos.
    *   2° - Encargada de Instanciar "a mano" (en el propio controller) el objeto que representa el JSON recibido.
    *   3° - Encargada de delegar la instanciacion a otro objeto.
    *   4° - Encargada de demostrar como ciertos frameworks y herramientas nos pueden resolver toda la logica de instanciacion y parseo facilmente.
    *   5° - Encargada de Instanciar "a mano" un objeto que a su vez contiene otros objetos a partir de un JSON que contiene otros JSONs.
    *   6° - Encargada de delegar la instanciacion anterior a otro objeto.
    * */

    @PostMapping("/api/recibirDatoSimple")
    public String recibirJson(@RequestBody String datoSimpleString){

        JSONObject JSONdatoSimple = new JSONObject(datoSimpleString);
        System.out.println(JSONdatoSimple);
        System.out.println(JSONdatoSimple.get("unInteger"));
        System.out.println(JSONdatoSimple.get("unString"));
        System.out.println(JSONdatoSimple.get("unDouble"));

        return "Recibi: " + datoSimpleString;
    }

    @PostMapping("/api/instanciarDatoAMano")
    public String instanciarDatoAMano(@RequestBody String datoSimpleString){

        JSONObject JSONdatoSimple = new JSONObject(datoSimpleString);

        DatoSimple datoSimple = new DatoSimple();
        datoSimple.setUnInteger((Integer) JSONdatoSimple.get("unInteger"));
        datoSimple.setUnString((String) JSONdatoSimple.get("unString"));
        datoSimple.setUnDouble(JSONdatoSimple.getDouble("unDouble"));

        return "Recibi el dato:"
                + " unInteger = " + datoSimple.getUnInteger()
                + " unString = " + datoSimple.getUnString()
                + " unDouble = " + datoSimple.getUnDouble();
    }

    @PostMapping("/api/instanciarDatoConClase")
    public String instanciarDatoConClase(@RequestBody String datoSimpleString){
        this.receptorDato = new ReceptorDato();

        DatoSimple datoSimple = receptorDato.decodificarDato(datoSimpleString);

        return "Recibi el dato:"
                + " unInteger = " + datoSimple.getUnInteger()
                + " unString = " + datoSimple.getUnString()
                + " unDouble = " + datoSimple.getUnDouble();
    }

    @PostMapping("/api/datoConFramework")
    public String frame(@RequestBody DatoSimple DatoSimple){

        return "Recibi el dato:"
                + " datoInteger = " + DatoSimple.getUnInteger()
                + " datoString = " + DatoSimple.getUnString();
    }

    @PostMapping("/api/RegionalAMano")
    public String recibirRegional(@RequestBody String regionalString){

        JSONObject JSONregional = new JSONObject(regionalString);
        JSONArray JSONArrayAlumnos = JSONregional.getJSONArray("alumnos");

        Regional regional = new Regional();
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

        regional.printear();

        return HttpStatus.OK.toString();
    }

    @PostMapping("/api/RegionalConClase")
    public String recibirRegionalConClase(@RequestBody String regionalString){
        this.receptorRegional = new ReceptorRegional();

        Regional regional = this.receptorRegional.recibirRegional(regionalString);

        regional.printear();

        return HttpStatus.OK.toString();
    }
}
