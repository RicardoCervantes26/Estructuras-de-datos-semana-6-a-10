import java.util.Scanner;

public class Main {
    // 1. Definir estructura del nodo
    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo cabeza = null;

    // --- OPERACIONES DE INSERCIÓN ---

    public void insertarInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        System.out.println("Insertado al inicio: " + dato);
    }

    public void insertarFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temporal = cabeza;
            while (temporal.siguiente != null) {
                temporal = temporal.siguiente;
            }
            temporal.siguiente = nuevo;
        }
        System.out.println("Insertado al final: " + dato);
    }

    // Inserción en posición específica
    public void insertarPosicion(int dato, int pos) {
        if (pos == 0) {
            insertarInicio(dato);
            return;
        }
        Nodo nuevo = new Nodo(dato);
        Nodo temp = cabeza;
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.siguiente;
        }
        if (temp != null) {
            nuevo.siguiente = temp.siguiente;
            temp.siguiente = nuevo;
            System.out.println("Insertado " + dato + " en posición " + pos);
        } else {
            System.out.println("Posición fuera de rango.");
        }
    }

    // --- OPERACIONES DE ELIMINACIÓN ---

    public void eliminarInicio() {
        if (cabeza != null) {
            System.out.println("Eliminado del inicio: " + cabeza.dato);
            cabeza = cabeza.siguiente;
        } else {
            System.out.println("Lista vacía.");
        }
    }

    // Eliminar al final: requiere localizar el penúltimo nodo
    public void eliminarFinal() {
        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }
        if (cabeza.siguiente == null) {
            System.out.println("Eliminado del final: " + cabeza.dato);
            cabeza = null;
            return;
        }
        Nodo temp = cabeza;
        while (temp.siguiente.siguiente != null) { // Buscar el penúltimo
            temp = temp.siguiente;
        }
        System.out.println("Eliminado del final: " + temp.siguiente.dato);
        temp.siguiente = null; // Actualizar puntero a null
    }

    // Eliminar por valor: ajusta apuntadores para saltar el nodo
    public void eliminarPorValor(int valor) {
        if (cabeza == null) return;

        if (cabeza.dato == valor) {
            cabeza = cabeza.siguiente;
            System.out.println("Valor " + valor + " eliminado.");
            return;
        }

        Nodo temp = cabeza;
        while (temp.siguiente != null && temp.siguiente.dato != valor) {
            temp = temp.siguiente;
        }

        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente; // Salto del nodo
            System.out.println("Valor " + valor + " eliminado.");
        } else {
            System.out.println("Valor no encontrado.");
        }
    }

    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }
        Nodo temp = cabeza;
        System.out.print("Lista: ");
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

    // 5. Probar operaciones con Scanner
    public static void main(String[] args) {
        Main lista = new Main();
        Scanner sc = new Scanner(System.in);
        int opcion, valor, pos;

        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE LISTAS ---");
            System.out.println("1. Insertar Inicio  2. Insertar Final  3. Insertar Posición");
            System.out.println("4. Eliminar Inicio  5. Eliminar Final  6. Eliminar por Valor");
            System.out.println("7. Mostrar Lista    8. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor: "); valor = sc.nextInt();
                    lista.insertarInicio(valor); break;
                case 2:
                    System.out.print("Valor: "); valor = sc.nextInt();
                    lista.insertarFinal(valor); break;
                case 3:
                    System.out.print("Valor: "); valor = sc.nextInt();
                    System.out.print("Posición: "); pos = sc.nextInt();
                    lista.insertarPosicion(valor, pos); break;
                case 4:
                    lista.eliminarInicio(); break;
                case 5:
                    lista.eliminarFinal(); break;
                case 6:
                    System.out.print("Valor a eliminar: "); valor = sc.nextInt();
                    lista.eliminarPorValor(valor); break;
                case 7:
                    lista.mostrarLista(); break;
            }
        } while (opcion != 8);
        sc.close();
    }
}