public class ListaDoblementeEnlazada {
    private NodoDoble cabeza;
    private NodoDoble cola;

    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarInicio(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        System.out.println("-> Insertado " + dato + " al inicio de la lista doble.");
    }

    public void eliminar(int dato) {
        NodoDoble actual = cabeza;
        while (actual != null) {
            if (actual.dato == dato) {
                if (actual == cabeza) {
                    cabeza = actual.siguiente;
                    if (cabeza != null) cabeza.anterior = null;
                    else cola = null;
                } else if (actual == cola) {
                    cola = actual.anterior;
                    cola.siguiente = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                System.out.println("-> " + dato + " eliminado de la lista doble.");
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("X El valor " + dato + " no existe en la lista doble.");
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista doble está vacía.");
            return;
        }
        NodoDoble actual = cabeza;
        System.out.print("Lista Doble: ");
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}