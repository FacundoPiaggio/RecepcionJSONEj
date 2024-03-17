package com.example.recepcionJson.receptores;

import com.example.recepcionJson.model.DatoSimple;
import org.json.JSONObject;

public class ReceptorDato {

    public DatoSimple decodificarDato(String datoSimpleString){
        DatoSimple datoSimpleParseado = new DatoSimple();

        JSONObject JSONdato = new JSONObject(datoSimpleString);

        datoSimpleParseado.setUnInteger((Integer) JSONdato.get("unInteger"));
        datoSimpleParseado.setUnString((String) JSONdato.get("unString"));
        datoSimpleParseado.setUnDouble(JSONdato.getDouble("unDouble"));


        return datoSimpleParseado;
    }
}
