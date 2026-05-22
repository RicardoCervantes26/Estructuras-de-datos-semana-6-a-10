public class ListaCircularSimple {
    private NodoSimple cabeza;
    private NodoSimple cola;

    public ListaCircularSimple() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarInicio(int dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            cola.siguiente = cabeza;
        }
        System.out.println("-> Insertado " + dato + " al inicio de la lista circular.");
    }

    public void eliminar(int dato) {
        if (cabeza == null) {
            System.out.println("La lista circular está vacía.");
            return;
        }

        NodoSimple actual = cabeza;
        NodoSimple anterior = cola;

        do {
            if (actual.dato == dato) {
                if (actual == cabeza && actual == cola) {
                    cabeza = null;
                    cola = null;
                } else if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    cola.siguiente = cabeza;
                } else if (actual == cola) {
                    cola = anterior;
                    cola.siguiente = cabeza;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                System.out.println("-> " + dato + " eliminado de la lista circular.");
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("X El valor " + dato + " no existe en la lista circular.");
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista circular está vacía.");
            return;
        }
        NodoSimple actual = cabeza;
        System.out.print("Lista Circular: ");
        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(cabeza: " + cabeza.dato + ")");
    }
}