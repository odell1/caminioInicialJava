import java.util.LinkedList;
import java.util.Queue;

class Celda {
    int fila;
    int columna;
    int distancia;
    Celda padre; //Para reconstruir el camino

    public Celda(int fila, int columna, int distancia) {
        this.fila = fila;
        this.columna = columna;
        this.distancia = distancia;
        this.padre = null;
    }

    public Celda(int fila, int columna, int distancia, Celda padre) {
        this.fila = fila;
        this.columna = columna;
        this.distancia = distancia;
        this.padre = padre;
    }
}