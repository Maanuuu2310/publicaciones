package com.planeta.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Util {

    public static String setFirstLetterToCapital(String inputString) {
        return inputString.toUpperCase(Locale.ROOT).charAt(0) + inputString.substring(1).toLowerCase(Locale.ROOT);
    }

    // Habia hecho esta clase para que se pudiese parsear la fecha (de manera visual únicamente) al formato que tenemos nosotros:
    //      DD / MM / AAAA -> Pero dado que no se nos solicitó en el toString lo he dejado
    //          por si en algun punto quieren añadir la fecha de Edición

    public static String dateParser(LocalDate dateToParse) {

        DateTimeFormatter formateo = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String fecha = dateToParse.format(formateo);
        LocalDate fechaParseada = LocalDate.parse(fecha, formateo);

        return fechaParseada.format(formateo);

    }



}
