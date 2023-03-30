package com.planeta.publications;

import com.planeta.utils.Error;

public class PublicationManager {
    public static final int MAX_PUBLICATIONS = 4;
    public static Publication publications[] = new Publication[MAX_PUBLICATIONS];

    public static int publicationCount = 0;

    public static void addPublication(Publication publicationToAdd) {
        if (publicationCount < publications.length) {
            publications[publicationCount] = publicationToAdd;
            publicationCount++;
            System.out.println(Error.CORRECT_CODE_8X000);
        } else { 
            System.out.println(Error.ADVERT_CODE_9X000);
        }
    }

    public static int getNumberOfPublicationsCreated() {
        int count = 0;
        for (int index = 0; index < publications.length ; index++) {
            if (publications[index] != null) {
                count++;
            }
        }
        return count;
    }

    public static void listAllPublications() {
        for (int index = 0; index < publications.length ; index++) {
            if (publications[index] != null) {
                System.out.println(publications[index] + "\n\n");
            }
        }
    }

    public static void simpleListAllPublications() {
        for (int index = 0; index < publications.length ; index++) {
            if (publications[index] != null) {
                System.out.println((index + 1) + ". " + publications[index].getTitle());
            }
        }
    }

}
