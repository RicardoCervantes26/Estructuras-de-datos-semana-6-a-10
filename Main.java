import java.util.Scanner;
import java.util.PriorityQueue; // Para la implementación de prioridad rápida

public class Main {

    // --- 1. COLA USANDO ARREGLO CIRCULAR [cite: 84, 103] ---
    static class ColaCircular {
        private int[] arreglo;
        private int frente, fin, capacidad, contador;

        public ColaCircular(int tamano) {
            this.capacidad = tamano;
            this.arreglo = new int[capacidad];
            this.frente = 0;
            this.fin = -1;
            this.contador = 0;
        }

        public void enqueue(int dato) {
            if (contador < capacidad) { // Verificar índices válidos [cite: 108]
                fin = (fin + 1) % capacidad; // Lógica circular [cite: 86]
                arreglo[fin] = dato;
                contador++;
                System.out.println("Encolado en Arreglo: " + dato);
            } else {
                System.out.println("Error: Cola llena (Capacidad limitada) [cite: 113]");
            }
        }

        public void dequeue() {
            if (contador > 0) {
                int elemento = arreglo[frente];
                frente = (frente + 1) % capacidad;
                contador--;
                System.out.println("Desencolado de Arreglo: " + elemento);
            } else {
                System.out.println("Error: Cola vacía [cite: 82]");
            }
        }
    }

    // --- 2. COLA USANDO LISTA ENLAZADA [cite: 87, 104] ---
    static class ColaLista {
        private class Nodo {
            int dato;
            Nodo siguiente;
            Nodo(int d) { this.dato = d; this.siguiente = null; }
        }

        private Nodo frente, fin;

        public void enqueue(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (fin == null) {
                frente = fin = nuevo;
            } else {
                fin.siguiente = nuevo;
                fin = nuevo;
            }
            System.out.println("Encolado en Lista (Dinámico): " + dato);
        }

        public void dequeue() {
            if (frente == null) {
                System.out.println("Error: Cola vacía [cite: 82]");
                return;
            }
            int valor = frente.dato;
            frente = frente.siguiente; // Gestión de memoria dinámica [cite: 89]
            if (frente == null) fin = null; // Liberar memoria [cite: 109]
            System.out.println("Desencolado de Lista: " + valor);
        }
    }

    // --- 3. COLA CON PRIORIDAD [cite: 90, 105] ---
    static class ColaPrioritaria {
        private PriorityQueue<Integer> colaP = new PriorityQueue<>();

        public void enqueue(int dato) {
            colaP.add(dato); // Los elementos se ordenan por prioridad [cite: 91]
            System.out.println("Encolado con Prioridad: " + dato);
        }

        public void dequeue() {
            if (!colaP.isEmpty()) {
                System.out.println("Desencolado Prioritario: " + colaP.poll());
            } else {
                System.out.println("Error: Cola vacía");
            }
        }
    }

    // --- MENÚ Y PRUEBAS CON SCANNER [cite: 106] ---
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaCircular cArreglo = new ColaCircular(5);
        ColaLista cLista = new ColaLista();
        ColaPrioritaria cPrioridad = new ColaPrioritaria();

        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE COLAS (FIFO) ---");
            System.out.println("1. Enqueue (Arreglo)  2. Dequeue (Arreglo)");
            System.out.println("3. Enqueue (Lista)    4. Dequeue (Lista)");
            System.out.println("5. Enqueue (Prioridad) 6. Dequeue (Prioridad)");
            System.out.println("7. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();

            if (opcion == 1 || opcion == 3 || opcion == 5) {
                System.out.print("Ingrese valor: ");
                int val = sc.nextInt();
                if (opcion == 1) cArreglo.enqueue(val);
                else if (opcion == 3) cLista.enqueue(val);
                else cPrioridad.enqueue(val);
            } else {
                if (opcion == 2) cArreglo.dequeue();
                else if (opcion == 4) cLista.dequeue();
                else if (opcion == 6) cPrioridad.dequeue();
            }
        } while (opcion != 7);
        sc.close();
    }
}