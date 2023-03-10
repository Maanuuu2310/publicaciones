package com.planeta.publications;

import java.time.LocalDate;

public class Publication {
    private final int MAX_PUBLICATIONS = 999;

    public static final int ISBN_LENGTH = 13;
    public static final String ISBN_PREFIX1 = "978";
    public static final String ISBN_PREFIX2 = "979";

    private String title;
    private int numberOfPages;
    private String isbn;
    private float distributionPrice;
    private float sellingPrice;
    private LocalDate editionDate;

    public Publication(String title, int numberOfPages, String isbn, float distributionPrice,
                    float sellingPrice, LocalDate editionDate) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.editionDate = editionDate;
        this.isbn = isbn;
        this.distributionPrice = distributionPrice;
        this.sellingPrice = sellingPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void printNumberOfPages() {
        String outputValue = getTitle() + " tiene un total de: " + numberOfPages;
        if (numberOfPages == 1) {
            outputValue += " pagina";
        } else {
            outputValue += " paginas";
        }
        System.out.println(outputValue);
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public float getDistributionPrice() {
        return distributionPrice;
    }

    public void setDistributionPrice(float distributionPrice) {
        this.distributionPrice = distributionPrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public LocalDate getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(LocalDate editionDate) {
        this.editionDate = editionDate;
    }
    
}
