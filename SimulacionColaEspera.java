import java.util.LinkedList;

class Cliente {
    private String nombre;
    private int tiempoLlegada;

    public Cliente(String nombre, int tiempoLlegada) {
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }
}

public class SimulacionColaEspera {
    private LinkedList<Cliente> cola;

    public SimulacionColaEspera() {
        cola = new LinkedList<>();
    }

    public void agregarCliente(Cliente cliente) {
        cola.addLast(cliente);
        System.out.println("Nuevo cliente agregado a la cola: " + cliente.getNombre());
    }

    public void atenderCliente() {
        if (!cola.isEmpty()) {
            Cliente cliente = cola.removeFirst();
            System.out.println("Atendiendo a cliente: " + cliente.getNombre());
        } else {
            System.out.println("No hay clientes en espera.");
        }
    }

    public static void main(String[] args) {
        SimulacionColaEspera simulacion = new SimulacionColaEspera();

        simulacion.agregarCliente(new Cliente("Cliente1", 0));
        simulacion.agregarCliente(new Cliente("Cliente2", 2));
        simulacion.agregarCliente(new Cliente("Cliente3", 5));

        simulacion.atenderCliente();
        simulacion.atenderCliente();
        simulacion.atenderCliente(); 
        simulacion.atenderCliente(); 
    }
}
