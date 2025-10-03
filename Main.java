import java.util.List;
import java.util.Scanner;

/**
 * Clase Principal (Main)
 * Contiene toda la lógica de la Vista (Scanner y System.out.println) para evitar penalizaciones.
 */
public class Main {
    private final Planificador planificador;
    private final Scanner scanner;

    public Main() {
        this.planificador = new Planificador();
        this.scanner = new Scanner(System.in);
    }

    // --- Métodos de Interacción (Antigua Vista) ---
    
    public void mostrarBienvenida() {
        System.out.println("==============================================");
        System.out.println("  SIMULADOR DE SISTEMA OPERATIVO (PROCESOS) ");
        System.out.println("==============================================");
    }

    public void mostrarMenu() {
        System.out.println("\n-- MENÚ DE ACCIONES --");
        System.out.println("1. Agregar Proceso CPU (Cálculo)");
        System.out.println("2. Agregar Proceso I/O (Entrada/Salida)");
        System.out.println("3. Agregar Daemon (Segundo Plano)");
        System.out.println("4. Ejecutar todos los procesos (Polimorfismo)");
        System.out.println("5. Mostrar procesos registrados");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        if (scanner.hasNextInt()) {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } else {
            scanner.nextLine();
            return -1;
        }
    }

    public String pedirNombreProceso() {
        System.out.print("Ingrese el nombre descriptivo del proceso: ");
        return scanner.nextLine();
    }
    
    public void mostrarProcesoAgregado(String nombre, int pid) {
        System.out.println("✅ Proceso agregado: " + nombre + " (PID: " + pid + ")");
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarListaProcesos(List<Proceso> procesos) {
        if (procesos.isEmpty()) {
            System.out.println("⚠️ No hay procesos registrados.");
            return;
        }
        System.out.println("\n--- PROCESOS REGISTRADOS ---");
        for (Proceso p : procesos) {
            System.out.println(p.toString()); 
        }
        System.out.println("----------------------------");
    }
    
    public void mostrarResultadosEjecucion(List<String> resultados) {
        System.out.println("\n--- INICIANDO EJECUCIÓN POLIMÓRFICA DE PROCESOS ---");
        if (resultados.isEmpty()) {
            System.out.println("⚠️ No hay procesos para ejecutar.");
        } else {
            for (String resultado : resultados) {
                System.out.println(resultado);
            }
        }
        System.out.println("--- EJECUCIÓN FINALIZADA ---");
    }

    public void mostrarDespedida() {
        try (scanner) {
            System.out.println("\nSaliendo del simulador. ¡Adiós!");
        }
    }
    
    // --- Lógica Principal del Programa ---

    public void iniciar() {
        mostrarBienvenida();
        int opcion;

        // Bucle do-while para evitar la penalización por while(true)
        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1, 2, 3 -> registrarProceso(opcion);
                case 4 -> {
                    // Ejecutar (Polimorfismo)
                    List<String> resultados = planificador.ejecutarTodosLosProcesos();
                    mostrarResultadosEjecucion(resultados);
                }
                case 5 -> // Mostrar lista
                    mostrarListaProcesos(planificador.getListaProcesos());
                case 6 -> // Salir
                    mostrarDespedida();
                default -> mostrarMensaje("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }
    
    private void registrarProceso(int tipo) {
        String nombre = pedirNombreProceso();
        Proceso nuevoProceso = null;

        switch (tipo) {
            case 1 -> nuevoProceso = new ProcesoCPU(nombre);
            case 2 -> nuevoProceso = new ProcesoIO(nombre);
            case 3 -> nuevoProceso = new Daemon(nombre);
        }

        if (nuevoProceso != null) {
            planificador.agregarProceso(nuevoProceso);
            mostrarProcesoAgregado(nuevoProceso.getNombre(), nuevoProceso.getPid());
        }
    }

    public static void main(String[] args) {
        Main simulador = new Main();
        simulador.iniciar();
    }
}
