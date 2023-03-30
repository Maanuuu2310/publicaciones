import java.util.Scanner;
import com.planeta.utils.TaxManager;
import com.planeta.utils.Error;

import com.planeta.publications.*;

public class App {

    public static Scanner keyBoardInput = new Scanner(System.in);

    public static int mainInterface() {

        System.out.println("\n" + "o0o========o0o=======================oooooo0|0-0|0ooooooo=======================o0o========o0o");

        System.out.println("\n" + "Bienvenido Adrian a la editorial el planeta" + "\n");  
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o0oo0=0oo0o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o- \n");

        System.out.println("Las opciones de nuestro catálogo son las siguientes: " + "\n");

        System.out.println("\t 1. Crear una nueva revista");
        System.out.println("\t 2. Crear un nuevo libro de texto");
        System.out.println("\t 3. Crear una nueva novela" + "\n");

        System.out.println("\t 4. Listar todas las publicaciones");
        System.out.println("\t 5. Seleccionar una publicación y calcula su precio en Canarias y Península." + "\n");

        System.out.println("\t 0. Para salir del menu." + "\n");

        System.out.print("Selección: ");
        int selectedValue;

        try {
            selectedValue = keyBoardInput.nextInt();
        } catch (Exception e) {
            System.out.println("\n" + Error.ERROR_CODE_0X001);
            return -1;
        }
        keyBoardInput.nextLine();
        return selectedValue;
    }

    public static int taxesInterface() {

        System.out.println("¿De qué publicación desea calcular los impuestos?" + "\n");
        PublicationManager.simpleListAllPublications();

        System.out.print("\n" + "Publicacion: ");
        int taxesMenuValue;

        try {
            taxesMenuValue = keyBoardInput.nextInt();
        } catch (Exception e) {
            System.out.println("\n" + Error.ERROR_CODE_0X001);
            return -1;
        }
        keyBoardInput.nextLine();

        return taxesMenuValue;

    }

    public static void main(String[] args) {

        int mainMenuValue;
        int publicationsAvailable;

        do {

            mainMenuValue = mainInterface();

            switch (mainMenuValue) {
                case 1:
                    publicationsAvailable = PublicationManager.getNumberOfPublicationsCreated();
                    if (publicationsAvailable == PublicationManager.MAX_PUBLICATIONS) {
                        System.out.println(Error.ADVERT_CODE_9X000);
                    } else {
                        Magazine.createMagazine();
                    }
                    break;
                case 2:
                    publicationsAvailable = PublicationManager.getNumberOfPublicationsCreated();
                    if (publicationsAvailable == PublicationManager.MAX_PUBLICATIONS) {
                        System.out.println(Error.ADVERT_CODE_9X000);
                    } else {
                        TextBook.createTextBook();
                    }
                    break;
                case 3:
                    publicationsAvailable = PublicationManager.getNumberOfPublicationsCreated();
                    if (publicationsAvailable == PublicationManager.MAX_PUBLICATIONS) {
                        System.out.println(Error.ADVERT_CODE_9X000);
                    } else {
                        Novel.createNovel();
                    }
                    break;
                case 4:
                    publicationsAvailable = PublicationManager.getNumberOfPublicationsCreated();
                    if (publicationsAvailable == 0) {
                        System.out.println("\n" + "No hay publicaciones creadas, saliendo...");
                    } else {
                        System.out.println("\n" + "Estas son todas las publicaciones: \n");
                        PublicationManager.listAllPublications();
                    }
                    break;
                case 5:
                    publicationsAvailable = PublicationManager.getNumberOfPublicationsCreated();
                    if (publicationsAvailable == 0) {
                        System.out.println("\n" + "No hay publicaciones creadas, saliendo...");
                    } else {
                        int publicationToTax = taxesInterface();
                        if (publicationToTax < PublicationManager.publications.length) {
                            TaxManager.printPublicationPricesTaxed(PublicationManager.publications[publicationToTax - 1]);
                        } else {
                            System.out.println(Error.ERROR_CODE_0X002);
                        }
                    }
                    break;
                case 0:
                    System.out.println("\n" + "Editorial cerrada uwu tenga buen dia (:");
                    break;
                default:
                    if (mainMenuValue != -1) {
                        System.out.println(Error.ERROR_CODE_0X002);
                    }
                    break;
            }

        } while (mainMenuValue != 0);

    }

}
