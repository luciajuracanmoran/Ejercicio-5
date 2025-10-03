/**
 * Clase base abstracta. El comportamiento polimórfico 'ejecutar' devuelve un String
 * para evitar System.out.println en el Modelo.
 */
public abstract class Proceso {
    private final int pid;
    private final String nombre;
    private static int nextPid = 100;

    public Proceso(String nombre) {
        this.pid = nextPid++;
        this.nombre = nombre;
    }

    // Método polimórfico: DEVUELVE el resultado de la ejecución.
    public abstract String ejecutar();

    /**
     * Sobrecarga (Overloading).
     */
    public String ejecutar(int prioridad) {
        return "\t-> Proceso " + pid + " ejecutándose con Prioridad: " + prioridad + "\n" + this.ejecutar();
    }

    // Getters y toString (sin System.out.println)
    public int getPid() { return pid; }
    public String getNombre() { return nombre; }
    
    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + " PID: " + pid + ", Nombre: " + nombre + "]";
    }
}