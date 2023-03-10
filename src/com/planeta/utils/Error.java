package com.planeta.utils;

import com.planeta.publications.PublicationManager;

public class Error {

    public static final String ERROR_CODE_0X001 = "\n" + Decorate.ANSI_RED + "ERROR 0x001: " + Decorate.DECORATION_RESET + "Has introducido un valor erróneo (probablemente no sea un número)";
    public static final String ERROR_CODE_0X002 = "\n" + Decorate.ANSI_RED + "ERROR 0x002: " + Decorate.DECORATION_RESET + "El valor introducido no se encuentra en el menu";

    public static final String ERROR_CODE_0X003 = "\n" + Decorate.ANSI_RED + "ERROR 0x003: " + Decorate.DECORATION_RESET + "El número de páginas es incoherente";
    public static final String ERROR_CODE_0X004 = "\n" + Decorate.ANSI_RED + "ERROR 0x004: " + Decorate.DECORATION_RESET + "El precio de distribución es incoherente";
    public static final String ERROR_CODE_0X005 = "\n" + Decorate.ANSI_RED + "ERROR 0x005: " + Decorate.DECORATION_RESET + "El precio de venta es incoherente";
    public static final String ERROR_CODE_0X006 = "\n" + Decorate.ANSI_RED + "ERROR 0x006: " + Decorate.DECORATION_RESET + "El numero asignado es incoherente";

    public static final String CORRECT_CODE_8X000 = "\n" + Decorate.ANSI_GREEN + "OPREACIÓN REALIZADA CON ÉXITO: " + Decorate.DECORATION_RESET + "Se ha añadido la nueva publicación";
    public static final String ADVERT_CODE_9X000 = "\n" + Decorate.ANSI_BLACK + Decorate.BACKGROUND_YELLOW + "ADVERTENCIA:" + Decorate.DECORATION_RESET + " No se pueden añadir más publicaciones";




}
