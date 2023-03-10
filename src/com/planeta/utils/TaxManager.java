package com.planeta.utils;

import com.planeta.publications.Publication;

public class TaxManager {

    public static final float IVA = 0.04f;
    public static final float IGIC = 0.03f;
    public static final String IVA_TEXT = String.format("IVA (%o",(int)(IVA * 100)) + "%)";
    public static final String IGIC_TEXT = String.format("IGIC (%o",(int)(IGIC * 100)) + "%)";

    public static float calculateIVA(float priceValue) {
        return priceValue + (priceValue * IVA);
    }

    public static float calculateIGIC(float priceValue) {
        return priceValue + (priceValue * IGIC);
    }

    public static void printPublicationPricesTaxed(Publication publicationToTax) {
        System.out.println("Los precios calculados de la revista - " + publicationToTax.getTitle() + " son: " + "\n");
        System.out.println("\t" + "- Precio de distribución: " + "\n");
        System.out.println("\t\t" + " - Precio con " + IVA_TEXT + " " + publicationToTax.getDistributionPrice() + " => " +  calculateIVA(publicationToTax.getDistributionPrice()));
        System.out.println("\t\t" + " - Precio con " + IGIC_TEXT + " " + publicationToTax.getDistributionPrice() + " => " + calculateIGIC(publicationToTax.getDistributionPrice()));
        System.out.println("\n\t" + "- Precio de venta: " + "\n");
        System.out.println("\t\t" + " - Precio con " + IVA_TEXT + " " + publicationToTax.getSellingPrice() + " => " +  calculateIVA(publicationToTax.getSellingPrice()));
        System.out.println("\t\t" + " - Precio con " + IGIC_TEXT + " " + publicationToTax.getSellingPrice() + " => " + calculateIGIC(publicationToTax.getSellingPrice()));
    }

}
