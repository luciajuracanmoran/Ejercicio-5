import java.util.ArrayList;
import java.util.List;

/**
 * El Planificador (Controlador) administra los procesos.
 * Retorna todos los resultados a la clase Main para que esta se encargue de la impresión.
 */
public class Planificador {
    private final List<Proceso> listaProcesos;

    public Planificador() {
        this.listaProcesos = new ArrayList<>();
    }

    public void agregarProceso(Proceso p) {
        this.listaProcesos.add(p);
    }

    /**
     * Ejecuta los procesos polimórficamente y retorna la lista de resultados String.
     */
    public List<String> ejecutarTodosLosProcesos() {
        List<String> resultados = new ArrayList<>();
        
        for (Proceso p : listaProcesos) {
            String resultadoEjecucion;
            
            // Verifica que p no sea null antes de llamar métodos
            if (p != null) {
                // Uso de Polimorfismo y Overloading
                if (p instanceof ProcesoCPU) {
                    resultadoEjecucion = p.ejecutar(5); // Llama al método sobrecargado
                } else {
                    resultadoEjecucion = p.ejecutar(); // Llama al método sobreescrito
                }
            } else {
                resultadoEjecucion = "Proceso nulo";
            }
            resultados.add(resultadoEjecucion);
        }
        return resultados;
    }

    public List<Proceso> getListaProcesos() {
        return listaProcesos;
    }
}

