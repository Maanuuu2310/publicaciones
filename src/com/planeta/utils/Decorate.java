package com.planeta.utils;

public class Decorate {


    public static final String DECORATION_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GRAY = "\u001B[37m";
    public static final String ANSI_WHITE = "\u001B[38m";

    public static final String BACKGROUND_WHITE = "\u001B[39m";
    public static final String BACKGROUND_BLACK = "\u001B[40m";
    public static final String BACKGROUND_RED = "\u001B[41m";
    public static final String BACKGROUND_GREEN = "\u001B[42m";
    public static final String BACKGROUND_YELLOW = "\u001B[43m";
    public static final String BACKGROUND_BLUE = "\u001B[44m";
    public static final String BACKGROUND_MAGENT = "\u001B[45m";
    public static final String BACKGROUND_CYAN = "\u001B[46m";
    public static final String BACKGROUND_GRAY = "\u001B[47m";

    public static final String ALIGN_CENTER = "\t\t\t\t\t\t\t";

    public static final String HIGH_INTENSITY = "\u001B[1m";
    public static final String LOW_INTENSITY = "\u001B[2m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";

    public static void showAllDecorations() {
        String output = "\t\t" + ANSI_YELLOW + "C" + ANSI_GREEN + "o" + ANSI_BLUE + "l" + ANSI_CYAN + "o" + ANSI_BLACK + "r" + ANSI_RED + "e" + ANSI_MAGENTA + "s: " + DECORATION_RESET + "\n\n";

        output += ANSI_BLACK + "- Negro " + DECORATION_RESET + "(" + ITALIC + "Negro" + DECORATION_RESET + ")\n";
        output += ANSI_GREEN + "- Verde" + DECORATION_RESET + "\n";
        output += ANSI_YELLOW + "- Amarillo" + DECORATION_RESET + "\n";
        output += ANSI_RED + "- Rojo" + DECORATION_RESET + "\n";
        output += ANSI_BLUE + "- Azul" + DECORATION_RESET + "\n";
        output += ANSI_MAGENTA + "- Magenta" + DECORATION_RESET + "\n";
        output += ANSI_CYAN + "- Cyan" + DECORATION_RESET + "\n";
        output += ANSI_GRAY + "- Gris" + DECORATION_RESET + "\n";
        output += ANSI_WHITE + "- Blanco" + DECORATION_RESET + "\n";

        output += "\n" + BACKGROUND_YELLOW + ANSI_BLACK + " Colores de fondo: " + DECORATION_RESET + "\n\n";

        output += BACKGROUND_GREEN + ANSI_BLACK + "- Fondo Verde   " + DECORATION_RESET + "\n";
        output += BACKGROUND_CYAN + ANSI_BLACK + "- Fondo Cyan    " + DECORATION_RESET + "\n";
        output += BACKGROUND_BLUE + ANSI_BLACK + "- Fondo Azul    " + DECORATION_RESET + "\n";
        output += BACKGROUND_MAGENT + ANSI_BLACK + "- Fondo Magenta " + DECORATION_RESET + "\n";
        output += BACKGROUND_RED + ANSI_BLACK + "- Fondo Rojo    " + DECORATION_RESET + "\n";
        output += BACKGROUND_YELLOW + ANSI_BLACK + "- Fondo Amarillo" + DECORATION_RESET + "\n";
        output += BACKGROUND_GRAY + "- Fondo Gris    " + DECORATION_RESET + "\n";
        output += BACKGROUND_BLACK + "- Fondo Negro   " + DECORATION_RESET + "\n";
        output += BACKGROUND_WHITE + "- Sin fondo" + DECORATION_RESET + "\n";

        output += "\n" + UNDERLINE + ITALIC + HIGH_INTENSITY + "Formato de texto" + DECORATION_RESET + "\n\n";

        output += ITALIC + "- Letra cursiva" + DECORATION_RESET + "\n";
        output += "- " + UNDERLINE + "Subrayado" + DECORATION_RESET + "\n";
        output += LOW_INTENSITY + "- Letra Negrita " + DECORATION_RESET + ITALIC + "(Suave)" + DECORATION_RESET + "\n";
        output += HIGH_INTENSITY + "- Letra Negrita " + DECORATION_RESET + ITALIC + "(Común)" + DECORATION_RESET + "\n\n";
        output += "También se puede forzar letras o caractéres invisibles, pero evidentemente no se puede hacer una muestra";

        System.out.println(output);
    }

}
