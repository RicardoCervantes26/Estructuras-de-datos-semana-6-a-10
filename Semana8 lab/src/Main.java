import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazadaSimple listaPrincipal = new ListaEnlazadaSimple();
        int op, dato;

        do {
            System.out.println("\n--- MENÚ AVANZADO DE LISTAS ENLAZADAS ---");
            System.out.println("1. Insertar elemento al final");
            System.out.println("2. Mostrar lista actual");
            System.out.println("3. [Prueba 1] Invertir lista");
            System.out.println("4. [Prueba 2] Detectar ciclo (Algoritmo de Floyd)");
            System.out.println("5. [Prueba 2 Auxiliar] Forzar un ciclo en la lista");
            System.out.println("6. [Prueba 3] Fusionar con una lista quemada/ordenada");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Ingrese valor numérico: ");
                    dato = sc.nextInt();
                    listaPrincipal.insertarFinal(dato);
                    System.out.println("Elemento agregado.");
                    break;

                case 2:
                    System.out.print("Contenido: ");
                    listaPrincipal.recorrer();
                    break;

                case 3:
                    System.out.println("Invirtiendo los punteros de la lista...");
                    listaPrincipal.invertir();
                    System.out.print("Resultado: ");
                    listaPrincipal.recorrer();
                    break;

                case 4:
                    System.out.println("Ejecutando algoritmo de la liebre y la tortuga...");
                    boolean cicloDetectado = listaPrincipal.tieneCiclo();
                    if (cicloDetectado) {
                        System.out.println("ALERTA: Se ha detectado un ciclo infinito en la estructura.");
                    } else {
                        System.out.println("OK: La lista es lineal, no se encontraron ciclos.");
                    }
                    break;

                case 5:
                    listaPrincipal.forzarCiclo();
                    break;

                case 6:
                    // Creamos una lista secundaria ordenada de manera automática para la fusión
                    ListaEnlazadaSimple listaSecundaria = new ListaEnlazadaSimple();
                    listaSecundaria.insertarFinal(2);
                    listaSecundaria.insertarFinal(4);
                    listaSecundaria.insertarFinal(6);
                    listaSecundaria.insertarFinal(8);

                    System.out.print("Lista Principal actual: ");
                    listaPrincipal.recorrer();
                    System.out.print("Lista Secundaria de prueba: ");
                    listaSecundaria.recorrer();

                    System.out.println("Fusionando ambas de forma ordenada...");
                    ListaEnlazadaSimple fusionada = ListaEnlazadaSimple.fusionarListas(listaPrincipal, listaSecundaria);

                    System.out.print("Resultado final: ");
                    fusionada.recorrer();
                    break;

                case 0:
                    System.out.println("Cerrando el programa.");
                    break;

                default:
                    System.out.println("Opción inválida del menú.");
            }
        } while (op != 0);

        sc.close();
    }
}