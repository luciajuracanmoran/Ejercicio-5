public class ProcesoIO extends Proceso {
    public ProcesoIO(String nombre) {
        super(nombre);
    }
    @Override
    public String ejecutar() {
        // Devuelve el resultado.
        return toString() + " -> Esperando por operación de I/O. (Bloqueado esperando dispositivo).";
    }
}
