import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDoblementeEnlazada listaDoble = new ListaDoblementeEnlazada();
        ListaCircularSimple listaCircular = new ListaCircularSimple();

        int opcionPrincipal;

        do {
            System.out.println("\n=================================");
            System.out.println("      MENU PRINCIPAL - ESTRUCTURAS ");
            System.out.println("=================================");
            System.out.println("1. Trabajar con Lista Doblemente Enlazada");
            System.out.println("2. Trabajar con Lista Circular Simple");
            System.out.println("3. Salir");
            System.out.print("Seleccione una estructura: ");
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    menuListaDoble(scanner, listaDoble);
                    break;
                case 2:
                    menuListaCircular(scanner, listaCircular);
                    break;
                case 3:
                    System.out.println("¡Saliendo del programa!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionPrincipal != 3);

        scanner.close();
    }

    // Submenú para la Lista Doblemente Enlazada
    private static void menuListaDoble(Scanner scanner, ListaDoblementeEnlazada lista) {
        int opcion;
        do {
            System.out.println("\n--- SUBMENU LISTA DOBLEMENTE ENLAZADA ---");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Eliminar un valor");
            System.out.println("3. Mostrar lista (Recorrido)");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una operación: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número a insertar: ");
                    int valorIns = scanner.nextInt();
                    lista.insertarInicio(valorIns);
                    break;
                case 2:
                    System.out.print("Ingrese el número a eliminar: ");
                    int valorEli = scanner.nextInt();
                    lista.eliminar(valorEli);
                    break;
                case 3:
                    lista.mostrar();
                    break;
                case 4:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 4);
    }

    // Submenú para la Lista Circular Simple
    private static void menuListaCircular(Scanner scanner, ListaCircularSimple lista) {
        int opcion;
        do {
            System.out.println("\n--- SUBMENU LISTA CIRCULAR SIMPLE ---");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Eliminar un valor");
            System.out.println("3. Mostrar lista (Recorrido)");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una operación: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número a insertar: ");
                    int valorIns = scanner.nextInt();
                    lista.insertarInicio(valorIns);
                    break;
                case 2:
                    System.out.print("Ingrese el número a eliminar: ");
                    int valorEli = scanner.nextInt();
                    lista.eliminar(valorEli);
                    break;
                case 3:
                    lista.mostrar();
                    break;
                case 4:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 4);
    }
}