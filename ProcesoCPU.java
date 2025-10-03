public class ProcesoCPU extends Proceso {
    public ProcesoCPU(String nombre) {
        super(nombre);
    }
    @Override
    public String ejecutar() {
        // Devuelve el resultado.
        return toString() + " -> Realizando cálculo intensivo de CPU... (Tarea de cálculo alto).";
    }
}