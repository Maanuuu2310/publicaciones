package com.planeta.publications;

import java.time.LocalDate;
import java.util.Scanner;

import com.planeta.utils.Error;
import com.planeta.utils.Decorate;
import com.planeta.utils.Util;

public class Novel extends Publication{
    private enum novelThematic {
        BLACK_NOVEL,
        HISTORICAL_NOVEL,
        YOUNG_NOVEL,
    }

    private String author;
    private static novelThematic novelThematic;

    public Novel(String title, int numberOfPages, Novel.novelThematic novelThematic , String isbn,
                 float distributionPrice, float sellingPrice, LocalDate editionDate,
                 String author) {
        super(title, numberOfPages, isbn, distributionPrice, sellingPrice, editionDate);
        this.author = author;
        Novel.novelThematic = novelThematic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Novel.novelThematic getNovelThematic() {
        return novelThematic;
    }

    public void setNovelThematic(Novel.novelThematic novelThematic) {
        Novel.novelThematic = novelThematic;
    }

    public static void createNovel() {

        Scanner keyBoardInput = new Scanner(System.in);

        System.out.println("\n" + "================== NUEVA NOVELA ==================" + "\n");

        // Creación del título de la novela

        System.out.print("Introduzca un titulo para la nueva novela: ");
        String novelTitle = keyBoardInput.nextLine();

        // Creación del nombre del autor

        System.out.print("Introduzca el autor de dicha novela: ");
        String novelAuthor = keyBoardInput.nextLine();

        // Creación del número de páginas de la novela

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
            System.out.println("Se asignará un dia de seguridad (27) - Pulse enter para continuar" + "\n");
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
            System.out.println("Se asignará un año de seguridad (1979) - Pulse enter para continuar" + "\n");
            editionDateYear = 1979;
        }
        keyBoardInput.nextLine();

        LocalDate editionDate = LocalDate.of(editionDateYear, editionDateMonth, editionDateDay);

        // Selección de tema de la novela

        System.out.println("\n" + "Debe elegir la temática de la novela " + novelTitle + "\n");

        System.out.println(" 1. Novela negra");
        System.out.println(" 2. Novela Historica");
        System.out.println(" 3. Novela Juvenil" + "\n");

        System.out.println(" 4. No deseo seleccionar un tema ahora mismo");
        System.out.print("\n" + "Selección: ");
        int thematicSelection;
        // Selección del tema dado por el usuario
        Novel.novelThematic finalThematic;

        try {
            thematicSelection = keyBoardInput.nextInt();
            if (thematicSelection == 1) {
                finalThematic = Novel.novelThematic.BLACK_NOVEL;
            } else if (thematicSelection == 2) {
                finalThematic = Novel.novelThematic.HISTORICAL_NOVEL;
            } else if (thematicSelection == 3) {
                finalThematic = Novel.novelThematic.YOUNG_NOVEL;
            } else if (thematicSelection == 0) {
                System.out.println("No se asignará una temática por el momento");
                finalThematic = null;
            } else {
                System.out.println("No se ha seleccionado ningun valor del menú, no se asignará temática");
                finalThematic = null;
            }
        } catch (Exception e) {
            System.out.println(Error.ERROR_CODE_0X006);
            System.out.println("Se ha introducido un valor erróneo en el menú, no se asignará temática");
            finalThematic = null;
        }
        keyBoardInput.nextLine();


        // Creación final de la novela

        Novel newNovel = new Novel(novelTitle, numberOfPages , finalThematic, isbnAsigned, distributionPrice, sellingPrice, editionDate, novelAuthor);

        LocalDate birthdate = LocalDate.of(1979, 9, 27);

        // Zona secreta

        if (editionDate.equals(birthdate)) {
            newNovel.setTitle("CUMPLEAÑOS DE GOYO");
        }

        // Adición de la novela a la lista

        PublicationManager.addPublication(newNovel);

    }

    @Override
    public String toString() {
        String outputValue = " ====================================== " + Util.setFirstLetterToCapital(getTitle()) + " ========================================= " + "\n\n";
        outputValue += Decorate.ANSI_CYAN + "Temática: " + Decorate.DECORATION_RESET;
        if (getNovelThematic() == Novel.novelThematic.BLACK_NOVEL) {
            outputValue += Decorate.ITALIC + "Novela negra" + Decorate.DECORATION_RESET;
        } else if (getNovelThematic() == Novel.novelThematic.HISTORICAL_NOVEL) {
            outputValue += Decorate.ITALIC + "Novela Histórica" + Decorate.DECORATION_RESET;
        } else if (getNovelThematic() == Novel.novelThematic.YOUNG_NOVEL){
            outputValue += Decorate.ITALIC + "Novela Juvenil" + Decorate.DECORATION_RESET;
        } else {
            outputValue += "No hay una temática preestablecida";
        }
        outputValue += "\n" + Decorate.ANSI_CYAN + "Autor: " + Decorate.DECORATION_RESET + getAuthor() + "\n";
        outputValue += Decorate.ANSI_CYAN + "Precio de distribución: " + Decorate.DECORATION_RESET + Decorate.ITALIC + getDistributionPrice() + Decorate.DECORATION_RESET + " €" + "\n";
        outputValue += Decorate.ANSI_CYAN + "Precio de venta al público: " + Decorate.DECORATION_RESET + Decorate.ITALIC + getSellingPrice() + Decorate.DECORATION_RESET + " €";

        outputValue += "\n\n" + Decorate.ANSI_RED+ "NOTA :" + Decorate.DECORATION_RESET +  " Los impuestos no han sido calculados en esta representación.";

        return outputValue;
    }

    
}

