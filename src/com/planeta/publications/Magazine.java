package com.planeta.publications;

import java.time.LocalDate;
import java.util.Scanner;
import com.planeta.utils.Error;

import com.planeta.utils.Decorate;
import com.planeta.utils.Util;

public class Magazine extends Publication {
    private static final int MAX_ARTICLES = 2;

    private int magazineNumber;
    private static String[] articles = new String[MAX_ARTICLES];

    public Magazine(String title, int numberOfPages, String isbn, float distributionPrice,
                    float sellingPrice, LocalDate editionDate, int magazineNumber, String[] articles) {
        super(title, numberOfPages, isbn, distributionPrice, sellingPrice, editionDate);
        this.magazineNumber = magazineNumber;
        Magazine.articles = articles;
    }

    public int getMagazineNumber() {
        return magazineNumber;
    }

    public void setMagazineNumber(int magazineNumber) {
        this.magazineNumber = magazineNumber;
    }

    public static String[] getArticles() {
        return articles;
    }

    public static void setArticles(String[] articles) {
        Magazine.articles = articles;
    }

    public static void createMagazine() {

        Scanner keyBoardInput = new Scanner(System.in);

        System.out.println("\n" + "================== NUEVA REVISTA ==================" + "\n");

        // Creación del título de la revista

        System.out.print("Introduzca un titulo para la revista: ");
        String magazineTitle = keyBoardInput.nextLine();

        // Creación del número de páginas de la revista

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

        // Creación del ISBN de la revista

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

        // Creación de un número de revistas

        System.out.print("Introduzca el número de la revista: ");
        int magazineNumber;

        try {
            magazineNumber = keyBoardInput.nextInt();
        } catch (Exception e) {
            keyBoardInput.nextLine();
            System.out.println("\n" + Error.ERROR_CODE_0X006);
            System.out.println("Se asignará un número de seguridad - Pulse enter para continuar" + "\n");
            magazineNumber = -1;
        }
        keyBoardInput.nextLine();

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
            System.out.println("Se asignará un dia de seguridad (27) - Pulse enter para continuar");
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
            System.out.println("Se asignará un mes de seguridad (9) - Pulse enter para continuar");
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

        // Creación de artículos (con un número que da el usuario que no puede superar el máximo posible)

        System.out.println("\n" + "Debe elegir un número de artículos que tendrá la revista " + magazineTitle);
        System.out.print("Escribe un número de artículos: ");
        int articleNumber;

        try {
            articleNumber = keyBoardInput.nextInt();
            if (articleNumber > MAX_ARTICLES) {
                System.out.println("\n" + "El número que has asignado excede del máximo de artículos (" + MAX_ARTICLES + ").");
                System.out.println("Se asignará dicho máximo en su lugar" + "\n");
                articleNumber = MAX_ARTICLES;
            } else if (articleNumber < 0) {
                System.out.println("\n" + "El número asignado es negativo, por lo que no se asignarán artículos" + "\n");
                articleNumber = 0;
            }
        } catch (Exception e) {
            System.out.println(Error.ERROR_CODE_0X006);
            System.out.println("No se añadirán articulos - Pulse enter para continuar" + "\n");
            articleNumber = 0;
        }
        keyBoardInput.nextLine();

            // Adición de los artículos de manera individual a la lista de articulos

        if (articleNumber != 0) {
            for (int index = 0; index < articleNumber; index++) {
                if (index == 0) {
                    System.out.println("Introduzca el " + (index + 1) + "er artículo");
                    System.out.print("- ");
                } else {
                    System.out.println("Introduzca el " + (index + 1) + "º artículo");
                    System.out.print("- ");
                }
                String articleName = keyBoardInput.nextLine();
                articles[index] = articleName;
            }
        }

        // Creación final de la revista

        Magazine newMagazine = new Magazine(magazineTitle, numberOfPages, isbnAsigned, distributionPrice, sellingPrice, editionDate, magazineNumber, articles);

        // Zona secreta

        LocalDate birthdate = LocalDate.of(1979, 9, 27);

        if (editionDate.equals(birthdate)) {
            newMagazine.setTitle("CUMPLEAÑOS DE GOYO");
        }

        // Se añade la revista a la lista de publicaciones

        PublicationManager.addPublication(newMagazine);

    }

    @Override
    public String toString() {
        String outputValue = " ====================================== " + Util.setFirstLetterToCapital(getTitle()) + " ========================================= " + "\n\n";
        outputValue += Decorate.ANSI_CYAN + "Numero de la revista: " + Decorate.DECORATION_RESET + Decorate.ITALIC + getMagazineNumber() + Decorate.DECORATION_RESET + "\n";
        outputValue += Decorate.ANSI_CYAN + "Lista de articulos: " + Decorate.DECORATION_RESET + "\n";
        for (int index = 0; index < articles.length; index++) {
            if (articles[index] != null ) {
                outputValue += "\t" + "- " + articles[index] + "\n";
            }
        }
        outputValue += Decorate.ANSI_CYAN + "Precio de distribución: " + Decorate.DECORATION_RESET + Decorate.ITALIC + getDistributionPrice() + Decorate.DECORATION_RESET + " €" + "\n";
        outputValue += Decorate.ANSI_CYAN + "Precio de venta al público: " + Decorate.DECORATION_RESET + Decorate.ITALIC + getSellingPrice() + Decorate.DECORATION_RESET + " €";

        outputValue += "\n\n" + Decorate.ANSI_RED+ "NOTA :" + Decorate.DECORATION_RESET +  " Los impuestos no han sido calculados en esta representación.";

        return outputValue;
    }
}




