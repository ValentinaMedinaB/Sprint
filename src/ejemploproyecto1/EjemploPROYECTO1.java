/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploproyecto1;

import java.io.File;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author valen
 */
public class EjemploPROYECTO1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int menuOpcion;
        boolean salir = false;

        // acceso a la aplicacion
        do {        //menu del usuario
            menuOpcion = imprimirMenu();

            switch (menuOpcion) {

                case 1: //admin.
                    int admin;

                    do {
                        admin = menuAdim();

                        switch (admin) {
                            case 1:// alta usuario
                                break;
                            case 2://lista de los usuarios
                                break;
                            case 3://modifica contraseña y rol de camarero
                                break;
                            case 4:// elimina un usuario de rol camarero
                                break;
                            case 5://salir
                                salir = true;
                                break;

                        }
                    } while (admin != 5);

                    break;

                case 2:// cambrer
                    int cambrer;
                    do {
                        cambrer = menuCambrer();
                        switch (cambrer) {
                            case 1:// lista mesas
                                lecturaFichero();
                                break;
                            case 2:// alta mesas
                                crearMesa();
                                lecturaFichero();
                                break;
                            case 3://modifica mesas
                                
                                System.out.println("que indice quieres cambiar ");
                                String indiceCambio = lector.next();
                                modificarFichero(indiceCambio);
                                lecturaFichero();
                                break;
                            case 4:// elimina mesa

                                System.out.println("que linea id quieres eliminar: ");
                                String indice = lector.next();
                                eliminarLinea(indice);
                                lecturaFichero();
                                break;
                            case 5://salir
                                salir = true;
                                break;
                        }

                    } while (cambrer != 5);
                    break;

            }

        } while (menuOpcion != 3);

    }

    private static void lecturaFichero() {
        File fichero = new File("C:/Users/valen/OneDrive/Documentos/NetBeansProjects/EjemploPROYECTO1/Archivo/ejemploFichero.txt");
        try {
            Scanner lector = new Scanner(fichero);
            while (lector.hasNext()) {
                System.out.println(lector.next());
            }
            lector.close();

        } catch (Exception e) {
            System.out.println("ha ocurrido un ERROR al abrir o leer el fichero");

        }

    }

    private static void crearMesa() {
        File fichero = new File("C:/Users/valen/OneDrive/Documentos/NetBeansProjects/EjemploPROYECTO1/Archivo/ejemploFichero.txt");
        Scanner lector = new Scanner(System.in);
        try {
            FileWriter Scanner = new FileWriter(fichero,true);
            
            System.out.println("introduce el id de la mesa:");
            String id=lector.next();
            System.out.println("***********************************");
            System.out.println("introduce el nombre de la mesa de la mesa:");
            String nombre=lector.next();
            System.out.println("***********************************");
            System.out.println("introduce la cantidad maxima de sillas de la mesa:");
            String max=lector.next();
            System.out.println("***********************************");
            System.out.println("introduce si la mesa tiene silla para niño:");
            String nen=lector.next();
            System.out.println("***********************************");
            System.out.println("introduce el numero de sillas de adulto de la mesa:");
            String adulto=lector.next();
            System.out.println("***********************************");
            System.out.println("introduce si la mesa tiene ventilador :");
            String ventilador=lector.next();
            System.out.println("***********************************");
            System.out.println("introduce si esta en el jardin o no la mesa:");
            String jardin=lector.next();
            
            Scanner.write(id+","+nombre+","+max+","+nen+","+adulto+","+ventilador+","+jardin+"\n");
            
            Scanner.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al crear/escribir en el fichero");
        }
    }

    private static void eliminarLinea(String id) {
        File fichero = new File("C:/Users/valen/OneDrive/Documentos/NetBeansProjects/EjemploPROYECTO1/Archivo/ejemploFichero.txt");

        // Array para guardar todas las líneas leídas del fichero
        ArrayList<String> lineas = new ArrayList<>();

        // Abrimos el fichero de texto para leerlo en memoria
        try {
            Scanner lector = new Scanner(fichero);

            int i = 0;

            while (lector.hasNext()) {
                lineas.add(lector.nextLine());
            }

            lector.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al abrir/leer el fichero");
        }

        // Abrimos el fichero de texto para sobreescribirlo
        // Eliminaremos la línea 3
        try {
            FileWriter Scanner = new FileWriter(fichero);
            String[] palabra = new String[7];

            for (String linea : lineas) {
                palabra = linea.split(",");
                if (!palabra[0].equals(id)) {
                    Scanner.write(linea + "\n");
                }

            }

            Scanner.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al abrir/sobreescribir el fichero");
        }

    }

    

    private static void modificarFichero(String indice) {
        File fichero = new File("C:/Users/valen/OneDrive/Documentos/NetBeansProjects/EjemploPROYECTO1/Archivo/ejemploFichero.txt");
        ArrayList<String> Lineas = new ArrayList<>();
        Scanner lector = new Scanner(System.in);
        try {

            // El true al final indica que escribiremos al final del fichero añadiendo texto
            FileWriter Scanner = new FileWriter(fichero);

            String[] palabra = new String[7];

            for (String linea : Lineas) {
                palabra = linea.split(",");
                if (palabra[0].equals(indice)) {
                    
                        System.out.println("introduce el cambio del " + indice + ":");
                        String cambioPalabra = lector.next();
                        Scanner.write(cambioPalabra);
                    

                }

            }

            Scanner.close();

        } catch (Exception e) {

            System.out.println("Ha ocurrido un error al modificar el fichero");

        }

    }

    //MENU
    public static int imprimirMenu() {
        Scanner lector = new Scanner(System.in);
        int opcion;
        System.out.println("***MENU del USUARIO***");
        System.out.println("1. ADMINISTRADOR");
        System.out.println("2. CAMBRER");
        System.out.println("3. Sortir");
        opcion = lector.nextInt();
        return opcion;
    }

    private static int menuAdim() {
        Scanner lector = new Scanner(System.in);
        int opcion;
        System.out.println("***MENU del ADMINISTRADOR***");
        System.out.println("1. ALTA USUARI");
        System.out.println("2. LISTAR TOTS ELS USUARIS");
        System.out.println("3. MODIFICA CONTRASENYA Y ROL DE UN CAMBRER");
        System.out.println("4. ELIMINAR UN USUARI DE ROL CAMBRER");
        System.out.println("5. SORTIR");
        opcion = lector.nextInt();
        return opcion;
    }

    private static int menuCambrer() {
        Scanner lector = new Scanner(System.in);
        int opcion;
        System.out.println("***MENU CAMBRER***");
        System.out.println("1. LISTA MESAS");
        System.out.println("2. ALTA MESAS");
        System.out.println("3. MODIFICAR / EDITAR UNA MESA");
        System.out.println("4. BORRAR UNA MESA");
        System.out.println("5. SORTIR");
        opcion = lector.nextInt();
        return opcion;
    }

}
