public class ListaEnlazadaSimple {
    Nodo cabeza;

    public ListaEnlazadaSimple() {
        this.cabeza = null;
    }

    // 1. ALGORITMO DE INVERSIÓN DE LISTA
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = cabeza;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        cabeza = anterior;
    }

    // 2. DETECCIÓN DE CICLOS CON FLOYD
    public boolean tieneCiclo() {
        if (cabeza == null) return false;

        Nodo tortuga = cabeza;
        Nodo liebre = cabeza;

        while (liebre != null && liebre.siguiente != null) {
            tortuga = tortuga.siguiente;
            liebre = liebre.siguiente.siguiente;

            if (tortuga == liebre) {
                return true;
            }
        }
        return false;
    }

    // 3. FUSIÓN DE LISTAS ORDENADAS
    public static ListaEnlazadaSimple fusionarListas(ListaEnlazadaSimple l1, ListaEnlazadaSimple l2) {
        Nodo p1 = l1.cabeza;
        Nodo p2 = l2.cabeza;

        ListaEnlazadaSimple listaResultado = new ListaEnlazadaSimple();
        Nodo dummy = new Nodo(0);
        Nodo actual = dummy;

        while (p1 != null && p2 != null) {
            if (p1.dato <= p2.dato) {
                actual.siguiente = p1;
                p1 = p1.siguiente;
            } else {
                actual.siguiente = p2;
                p2 = p2.siguiente;
            }
            actual = actual.siguiente;
        }

        if (p1 != null) {
            actual.siguiente = p1;
        } else if (p2 != null) {
            actual.siguiente = p2;
        }

        listaResultado.cabeza = dummy.siguiente;
        return listaResultado;
    }

    // Métodos de soporte obligatorios para poder operar la lista en el menú
    public void insertarFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public void recorrer() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Metodo especial para crear un ciclo controlado y poder probar Floyd
    public void forzarCiclo() {
        if (cabeza == null || cabeza.siguiente == null) {
            System.out.println("No hay suficientes elementos para crear un ciclo.");
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        // El último nodo apunta al segundo nodo de la lista creando el bucle
        actual.siguiente = cabeza.siguiente;
        System.out.println("¡Ciclo forzado generado con éxito!");
    }
}