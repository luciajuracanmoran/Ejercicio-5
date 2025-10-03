public class Daemon extends Proceso {
    public Daemon(String nombre) {
        super(nombre);
    }
    @Override
    public String ejecutar() {
        // Devuelve el resultado.
        return toString() + " -> Monitoreando en segundo plano... (Proceso de servicio continuo).";
    }
}