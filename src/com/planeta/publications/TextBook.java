package com.planeta.publications;

import java.time.LocalDate;
import java.util.Scanner;

import com.planeta.utils.Error;
import com.planeta.utils.Decorate;
import com.planeta.utils.Util;

public class TextBook extends Publication {
    private static final int MAX_THEMES = 2;

    private String targetSubject;
    private static String[] themes = new String[MAX_THEMES];

    public TextBook(String title, int numberOfPages, String isbn, float distributionPrice, float sellingPrice,
                    LocalDate editionDate, String course, String[] themes) {
        super(title, numberOfPages, isbn, distributionPrice, sellingPrice, editionDate);
        this.targetSubject = course;
        TextBook.themes = themes;
    }

    public String getTargetSubject() {
        return targetSubject;
    }

    public void setTargetSubject(String targetSubject) {
        this.targetSubject = targetSubject;
    }

    public static String[] getThemes() {
        return themes;
    }

    public static void setThemes(String[] themes) {
        TextBook.themes = themes;
    }

    public static void createTextBook() {

        Scanner keyBoardInput = new Scanner(System.in);

        System.out.println("\n" + "================== NUEVO LIBRO DE TEXTO ==================" + "\n");

        // Creación del título del libro de texto

        System.out.print("Introduzca un titulo para el libro de texto: ");
        String textBookTitle = keyBoardInput.nextLine();

        // Creación del número de páginas del libro de texto

        System.out.print("Introduzca un número de páginas válido: ");
        int numberOfPages;

        try {
            numberOfPages = keyBoardInput.nextInt();
        } catch (Exception e) {
            keyBoardInput.nextLine();
            System.out.println("\n" + Error.ERROR_CODE_0X003);
            System.out.println("No se asignará un número de páginas - Pulse enter para continuar");
            numberOfPages = 0;
        }
        keyBoardInput.nextLine();

        // Creación del ISBN del libro de texto

        System.out.print("Introduzca el ISBN: ");
        String isbnAsigned = keyBoardInput.nextLine();

        // Creación de un precio de DISTRIBUCIÓN

        System.out.print("Añada un precio de distribución: ");
        float distributionPrice;

        try {
            distributionPrice = keyBoardInput.nextFloat();
        } catch (Exception e) {
            keyBoardInput.nextLine();
            System.out.println("\n" + Error.ERROR_CODE_0X004);
            System.out.println("Se asignará un precio de distribución de 0 - Pulse enter para continuar" + "\n");
            distributionPrice = 0.0f;
        }
        keyBoardInput.nextLine();

        // Creación de un precio de VENTA

        System.out.print("Añada un precio de venta: ");
        float sellingPrice;

        try {
            sellingPrice = keyBoardInput.nextFloat();
        } catch (Exception e) {
            keyBoardInput.nextLine();
            System.out.println("\n" + Error.ERROR_CODE_0X005);
            System.out.println("Se asignará un precio de venta de 0 - Pulse enter para continuar" + "\n");
            sellingPrice = 0.0f;
        }
        keyBoardInput.nextLine();

        // Creación de la asignatura a la que ha sido destinada el libro

        System.out.print("Introduzca la asignatura a la que ha sido orientada el Libro de texto: ");
        String targetSubject = keyBoardInput.nextLine();

        // Creación de una fecha de publicación

        System.out.println("Introduzca la fecha de publicación: " + "\n");

        // Asignación de Dia

        System.out.print("Dia: ");
        int editionDateDay;

        try {
            editionDateDay = keyBoardInput.nextInt();
            if (editionDateDay > 31 | editionDateDay < 1) {
                System.out.println("\n" + "El año asignado excede del rango permitido, se asignará 27" + "\n");
                editionDateDay = 27;
            }
        } catch (Exception e) {
            keyBoardInput.nextLine();
            System.out.println("\n" + Error.ERROR_CODE_0X006);
            System.out.println("Se asignará un dia de seguridad (27) - Pulse enter para continuar" + "\n") ;
            editionDateDay = 27;
        }
        keyBoardInput.nextLine();

        // Asignación de Mes

        System.out.print("Mes: ");
        int editionDateMonth;

        try {
            editionDateMonth = keyBoardInput.nextInt();
            if (editionDateMonth > 12 | editionDateMonth < 1) {
                System.out.println("\n" + "El mes asignado excede del rango permitido, se asignará 9" + "\n");
                editionDateMonth = 9;
            }
        } catch (Exception e) {
            System.out.println("\n" + Error.ERROR_CODE_0X006);
            System.out.println("Se asignará un mes de seguridad (9) - Pulse enter para continuar" + "\n");
            editionDateMonth = 9;
        }
        keyBoardInput.nextLine();

        // Asignación de Año

        System.out.print("Año: ");
        int editionDateYear;

        try {
            editionDateYear = keyBoardInput.nextInt();
            if (editionDateYear > 2022 | editionDateYear < 1920) {
                System.out.println("\n" + "El año asignado excede del rango permitido, se asignará 1979" + "\n");
                editionDateYear = 1979;
            }
        } catch (Exception e) {
            System.out.println(Error.ERROR_CODE_0X006);
            System.out.println("Se asignará un año de seguridad (1979) - Pulse enter para continuar");
            editionDateYear = 1979;
        }
        keyBoardInput.nextLine();

        LocalDate editionDate = LocalDate.of(editionDateYear, editionDateMonth, editionDateDay);

        // Creación de los temas (con un número que da el usuario que no puede superar el máximo posible)

        System.out.println("\n" + "Debe elegir un número de Temas que tendrá el temario de " + textBookTitle);
        System.out.print("Escribe un número de Temas: ");
        int themesNumber;

        try {
            themesNumber = keyBoardInput.nextInt();
            if (themesNumber > MAX_THEMES) {
                System.out.println("\n" + "El número que has asignado excede del máximo de temas (" + MAX_THEMES + ").");
                System.out.println("Se asignará dicho máximo en su lugar" + "\n");
                themesNumber = MAX_THEMES;
            } else if (themesNumber < 0) {
                System.out.println("\n" + "El número asignado es negativo, por lo que no se asignarán temas" + "\n");
                themesNumber = 0;
            }
        } catch (Exception e) {
            System.out.println(Error.ERROR_CODE_0X006);
            System.out.println("No se añadirán temas - Pulse enter para continuar" + "\n");
            themesNumber = 0;
        }
        keyBoardInput.nextLine();

        // Adición de los temas de manera individual a la lista de temas

        if (themesNumber != 0) {
            for (int index = 0; index < themesNumber; index++) {
                if (index == 0) {
                    System.out.println("Introduzca el " + (index + 1) + "er Tema");
                    System.out.print("- ");
                } else {
                    System.out.println("Introduzca el " + (index + 1) + "º Tema");
                    System.out.print("- ");
                }
                String themeName = keyBoardInput.nextLine();
                themes[index] = themeName;
            }
        }

        // Creación final del libro de texto

        TextBook newTextBook = new TextBook(textBookTitle, numberOfPages, isbnAsigned, distributionPrice, sellingPrice, editionDate, targetSubject, themes);


        // Zona secreta

        LocalDate birthdate = LocalDate.of(1979, 9, 27);

        if (editionDate.equals(birthdate)) {
            newTextBook.setTitle("CUMPLEAÑOS DE GOYO");
        }

        // Se añade el libro de texto a la lista de publicaciones

        PublicationManager.addPublication(newTextBook);

    }

    @Override
    public String toString() {
        String outputValue = " ====================================== " + Util.setFirstLetterToCapital(getTitle()) + " ========================================= " + "\n\n";
        outputValue += Decorate.ANSI_CYAN + "Asignatura: " + Decorate.DECORATION_RESET + Decorate.ITALIC + getTargetSubject() + Decorate.DECORATION_RESET + "\n";
        outputValue += Decorate.ANSI_CYAN + "Lista de temas: " + Decorate.DECORATION_RESET + "\n";
        for (int index = 0; index < themes.length; index++) {
            if (themes[index] != null ) {
                outputValue += "\t" + "- " + themes[index] + "\n";
            }
        }
        outputValue += Decorate.ANSI_CYAN + "Precio de distribución: " + Decorate.DECORATION_RESET + Decorate.ITALIC + getDistributionPrice() + Decorate.DECORATION_RESET + " €" + "\n";
        outputValue += Decorate.ANSI_CYAN + "Precio de venta al público: " + Decorate.DECORATION_RESET + Decorate.ITALIC + getSellingPrice() + Decorate.DECORATION_RESET + " €";

        outputValue += "\n\n" + 
        Decorate.ANSI_RED+ "NOTA :" + Decorate.DECORATION_RESET + " Los impuestos no han sido calculados en esta representación.";

        return outputValue;
    }

    
}

