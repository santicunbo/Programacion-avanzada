
//Importamos Listas para poder crear los registros y scanner
import java.util.Scanner;
import java.util.ArrayList;


public class SistemaCitas {
    
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static ArrayList<Doctor> doctores = new ArrayList<>();
    private static ArrayList<Cita> citas = new ArrayList<>();
    private static ArrayList<String> turnos = new ArrayList<>();
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        turnos.add("Turno1= 10AM-11AM");
        turnos.add("Turno2= 11AM-12PM");
        turnos.add("Turno3= 12PM-1PM");
        turnos.add("Turno4= 1PM-2PM");
        turnos.add("Turno5= 2PM-3PM");
        turnos.add("Turno6= 3PM-4PM");
        turnos.add("Turno7= 4PM-5PM");
        turnos.add("Turno8= 5PM-6PM");
        
        int opcion;
        
        do {
            System.out.println("===== MENÚ DE OPCIONES =====");
            System.out.println("1. Sistema de Doctores");
            System.out.println("2. Sistema citas");
            System.out.println("3. Mostrar horario");
            System.out.println("4. Mostrar pacientes con fecha de su cita");
            System.out.println("5. Buscar paciente por id");
            System.out.println("6. Mostrar cantidad de citas de cada doctor con fecha y paciente");
            System.out.println("7 Buscar citas por fecha");
            System.out.println("8. Salir");

            opcion = 0;
            boolean opcionValida = false;

            while (!opcionValida) {
            System.out.print("Selecciona una opción: ");

            try {
            opcion = Integer.parseInt(scanner.nextLine());

            if (opcion >= 1 && opcion <= 8) {
            opcionValida = true; 
            } else {             
            System.out.println("Opción no válida. Debe ser un número entre 1 y 8.");
            }
            } catch (NumberFormatException e) {
            System.out.println("Opción no válida. Debes ingresar un número entero.");
            }
            }

            switch (opcion) {
                case 1:
                    sistemaDoctores(scanner);
                    break;
                case 2:
                    sistemaCitas(scanner);
                    break;
                case 3:
                    mostrarHorario();
                    break;
                case 4:
                    mostrarPacientesConCita();
                    break;
                case 5:
                    buscarPacientePorId(scanner);
                    break;
                case 6:
                    mostrarCitasPorDoctor();
                    break;
                case 7:
                    buscarCitasPorFecha(scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

            System.out.println();

        } while (opcion != 8); // Continuar hasta que el usuario elija la opción 8 (Salir)

        scanner.close(); 
    }
    

    // Métodos 
    
        public static void sistemaDoctores (Scanner scanner) {
            
        int opcionDoctor;
    
        do {
        System.out.println("===== SISTEMA DE DOCTORES =====");
        System.out.println("1. Registrar Doctor");
        System.out.println("2. Modificar Doctor");
        System.out.println("3. Eliminar Doctor");
        System.out.println("4. Listar Doctores");
        System.out.println("5. Volver al menú principal");
        System.out.print("Selecciona una opción: ");
        opcionDoctor = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcionDoctor) {
            case 1:
                registrarDoctor(scanner);
                break;
            case 2:
                modificarDoctor(scanner);
                break;
            case 3:
                eliminarDoctor(scanner);
                break;
            case 4:
                listaDoctores(scanner);
                break;
            case 5:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
        }
    } while (opcionDoctor != 5);}

    public static void registrarDoctor(Scanner scanner) {
    System.out.println("=== Registrar Doctor ===");
    System.out.print("Ingrese nombre: ");
    String nombre = scanner.nextLine(); 
    
    System.out.print("Ingrese id del doctor: ");
    String id = scanner.nextLine(); 

    // Validación para evitar registrar el mismo doctor 2 veces
    for (Doctor d : doctores) {
    if (d.getNombre().equals(nombre) && d.getId().equals(id)) {
    System.out.println("Ya está registrado el doctor: " + nombre);
    return;
    } }
    
    System.out.println("=== Información del Doctor ===");
    System.out.println("Nombre: " + nombre);
    System.out.println("ID: " + id);
    
    String confirmacion;
    while (true) {
    System.out.print("¿Desea confirmar el registro de este doctor? (s/n): ");
    confirmacion = scanner.nextLine();
        
    if (confirmacion.equalsIgnoreCase("n")) {
    System.out.println("✖ Proceso Cancelado");
    return;
    } else if (confirmacion.equalsIgnoreCase("s")) {
    Doctor d = new Doctor(nombre, id);
    doctores.add(d);
    System.out.println("✓ Doctor registrado correctamente ✓");
    break;
    } else {
    System.out.println("Carácter no válido. Por favor ingrese 's' o 'n'.");
    } } }
    
    public static void modificarDoctor(Scanner scanner) {
    System.out.println("=== Modificar Doctor ===");
    System.out.print("Ingrese el ID del doctor a modificar: ");
    String id = scanner.nextLine();

    // Buscar el doctor por ID
    Doctor doctor = null;
    for (Doctor d : doctores) {
        if (d.getId().equals(id)) {
            doctor = d;
            break;
        }
    }

    if (doctor == null) {
        System.out.println("No se encontró un doctor con ese ID.");
        return;}

    System.out.println("Doctor encontrado: " + doctor);
    
// Solicitar nueva información
    System.out.println("Ingrese el nuevo nombre del doctor (deje en blanco para no cambiar): ");
    String nuevoNombre = scanner.nextLine();
    
    if (!nuevoNombre.isEmpty()) {
        System.out.println("Nuevo nombre: " + nuevoNombre);
    }

    String confirmacion;
    while (true) {
        System.out.print("¿Desea confirmar la modificación de este doctor? (s/n): ");
        confirmacion = scanner.nextLine();
        
        if (confirmacion.equalsIgnoreCase("n")) {
            System.out.println("✖ Modificación Cancelada");
            return;
        } else if (confirmacion.equalsIgnoreCase("s")) {
            if (!nuevoNombre.isEmpty()) {
                doctor.setNombre(nuevoNombre);
            }
            System.out.println("✓ Doctor modificado correctamente ✓");
            break;
        } else {
            System.out.println("Carácter no válido. Por favor ingrese 's' o 'n'.");
        }
    }
}
    
    public static void eliminarDoctor(Scanner scanner) {
    System.out.println("=== Eliminar Doctor ===");
    System.out.print("Ingrese el ID del doctor a eliminar: ");
    String id = scanner.nextLine();

    // Buscar el doctor por ID
    Doctor doctorEliminar = null;
    for (Doctor d : doctores) {
        if (d.getId().equals(id)) {
            doctorEliminar = d;
            break;
        }
    }

    if (doctorEliminar == null) {
    System.out.println("No se encontró un doctor con ese ID.");
    return;
    }
    
      // Mostrar doctor que se eliminara
    System.out.println("=== Información del Doctor a Eliminar ===");
    System.out.println(doctorEliminar);

    String confirmacion;
    while (true) {
    System.out.print("¿Desea confirmar la eliminación de este doctor? (s/n): ");
    confirmacion = scanner.nextLine();
        
    if (confirmacion.equalsIgnoreCase("n")) {
    System.out.println("✖ Proceso Cancelado");
    return;
    } else if (confirmacion.equalsIgnoreCase("s")) {
     // Eliminar el doctor
    doctores.remove(doctorEliminar);
    System.out.println("✓ Doctor eliminado correctamente ✓");
    break;
    } else {
    System.out.println("Carácter no válido. Por favor ingrese 's' o 'n'.");
     } }}

        public static void listaDoctores(Scanner scanner) {    
        System.out.println("=== Lista de Doctores Registrados ===");

        if (doctores.isEmpty()) {
        System.out.println("No hay doctores registrados.");
        return;
        }

        int numero = 1;
        for (Doctor d : doctores) {
        System.out.println(numero + ". " + d.toString());
        numero++;
    }}
        
    
    public static void sistemaCitas(Scanner scanner) {
        int opcionCita;
            do {
        System.out.println("===== SISTEMA DE CITAS =====");
        System.out.println("1. Registrar Cita");
        System.out.println("2. Modificar Cita");
        System.out.println("3. Eliminar Cita");
        System.out.println("4. Volver al menú principal");
        System.out.print("Selecciona una opción: ");
        opcionCita = scanner.nextInt();
        scanner.nextLine();
        
                switch (opcionCita) {
            case 1:
                registrarCita(scanner);
                break;
            case 2:
                modificarCita(scanner);
                break;
            case 3:
                eliminarCita(scanner);
                break;
            case 4:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
                }
        }while (opcionCita != 4); }
            
        public static void registrarCita(Scanner scanner) {
        System.out.println("=== Registrar Cita ===");
        
        System.out.print("Ingrese ID del paciente: ");
        String id = scanner.nextLine();
        
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Confirma nombre: ");
        String usuario= scanner.nextLine();
        
            // Validar que el nombre fue escrito bien para registrarlo
            if (!nombre.equals(usuario)) {
            System.out.println("✖ Los nombres no coinciden ✖");
            return;
            }
            System.out.println("✓ Nombres coinciden");
            
        System.out.print("Ingrese teléfono: ");
        String telefono = scanner.nextLine();
        
        System.out.print("Ingrese servicio: ");
        String servicio = scanner.nextLine();
        
        System.out.print("Ingrese fecha de la cita (DD-MM-AAAA): ");
        String fecha = scanner.nextLine();
        
        System.out.println("Seleccione un turno disponible:");

             for (int i = 0; i < turnos.size();i++) {
             System.out.println((i + 1) + ". " + turnos.get(i));
             }
             
        int opcionTurno = -1;// se pone en -1 para que no este en el rango aproposito
                            //de manera que si se ejecute el bucle hasta que el usuario
                            //escoga un numero valido osea entero y entre 1 y la size de la lista
        while (opcionTurno < 1 || opcionTurno > turnos.size()) {
         System.out.print("Ingrese el número del turno deseado (1-8): ");
            
            // Comprobamos si la entrada es un número entero
         if (scanner.hasNextInt()) {
         opcionTurno = scanner.nextInt();
         scanner.nextLine(); 

         if (opcionTurno < 1 || opcionTurno > turnos.size()) {
         System.out.println(" X Turno no válido X. Debe estar entre 1 y " + turnos.size());
         }
         } else {
         // Si no es un número, mostramos un mensaje y pedimos de nuevo la entrada
         System.out.println(" X Entrada no válida. Por favor ingrese un número entre 1 y " + turnos.size() + " X");
                scanner.nextLine();
            }
        }
        // Cuando el número es válido, seleccionamos el turno
        String turno = turnos.get(opcionTurno - 1);
        System.out.println("Turno seleccionado: " + turno);
        

        
           // Validación para evitar registrar en el mismo turno el mismo dia
         for (Cita c : citas) {
         if (c.getFecha().equals(fecha)&& c.getTurno().equals(turno)) {
         System.out.println("Lo sentimos :( ya existe una cita el " + fecha + " Turno: " + turno);
         return;
         }
         } 
         
         if (doctores.isEmpty()) {
         System.out.println("No hay doctores registrados.");
         return;
         } 

        System.out.println("Seleccione un doctor:");
        for (int i = 0; i < doctores.size(); i++) {
        System.out.println((i + 1) + ". " + doctores.get(i).getNombre() + " (" + doctores.get(i).getId() + ")"); }
        int opcionDoctor = scanner.nextInt();
        scanner.nextLine(); 
        if (opcionDoctor < 1 || opcionDoctor > doctores.size()) {
        System.out.println(" Opción no válida. Por favor, elija un número entre 1 y " + doctores.size());
        return;
        }
        
        String doctor = doctores.get(opcionDoctor - 1).getNombre();
        //asigno a doctor de la clase Cita el nombre de la opcion seleccionada
        System.out.println("Doctor seleccionado: " + doctor);
        
        System.out.println("=====INFORMACION DEL REGISTRO=====");
        System.out.println("Servicio: " + servicio );
        System.out.println("Fecha:    " + fecha );
        System.out.println("Usuario:  " + usuario );
        System.out.println("Telefono: " + telefono );
        System.out.println("Doctor:   " + doctor );
        System.out.println("Turno:    " + turno );
        System.out.println("\n");

        while (true) {
        String confirmacion ;
        System.out.print("¿Desea confirmar el registro? (s/n): ");
        confirmacion = scanner.nextLine();
            
        if (confirmacion.equalsIgnoreCase("n")) {
        System.out.println("✖ Proceso Cancelado");
        return;
        
        } else if (confirmacion.equalsIgnoreCase("s")) {
            
        Cita c = new Cita(servicio, fecha, usuario, doctor, turno );
        citas.add(c);
        Paciente p = new Paciente(id, nombre, telefono );
        pacientes.add(p);
        
        System.out.println("✓ Paciente registrado con cita correctamente ✓");
        break;
        
        } else {
        System.out.println("Carácter no válido, Ingrese 's' o 'n'.");
        }}
        
    }
        
        public static void modificarCita(Scanner scanner) {
    System.out.println("=== Modificar Cita ===");

    System.out.print("Ingrese la fecha de la cita a modificar (DD-MM-AAAA): ");
    String fecha = scanner.nextLine();
    
    System.out.print("Ingrese el turno de la cita a modificar: ");
    String turno = scanner.nextLine();

    Cita cita = null;
    for (Cita c : citas) {
        if (c.getFecha().equals(fecha) && c.getTurno().equals(turno)) {
            cita = c;
            break;
        }
    }

    if (cita == null) {
        System.out.println("No se encontró una cita con esa fecha y turno.");
        return;
    }

    System.out.println("Cita encontrada: ");
    System.out.println(cita);

    System.out.println("Ingrese nuevo nombre del paciente (deje en blanco para no cambiar): ");
    String nuevoNombre = scanner.nextLine();
    if (!nuevoNombre.isEmpty()) {
        cita.setPaciente(nuevoNombre);
    }

    System.out.println("Ingrese nueva fecha (deje en blanco para no cambiar): ");
    String nuevaFecha = scanner.nextLine();
    if (!nuevaFecha.isEmpty()) {
        cita.setFecha(nuevaFecha);
    }

    System.out.println("Ingrese nuevo turno (deje en blanco para no cambiar): ");
    String nuevoTurno = scanner.nextLine();
    if (!nuevoTurno.isEmpty()) {
        cita.setTurno(nuevoTurno);
    }

    System.out.println("✓ Cita modificada correctamente ✓ ");
}
        
        public static void eliminarCita(Scanner scanner) {
    System.out.println("=== Eliminar Cita ===");

    System.out.print("Ingrese la fecha de la cita a eliminar (DD-MM-AAAA): ");
    String fecha = scanner.nextLine();
    
    System.out.print("Ingrese el turno de la cita a eliminar: ");
    String turno = scanner.nextLine();

    Cita citaEliminar = null; // null valor especial significa que la variable no apunta a ningún objeto. 
    for (Cita c : citas) {    //Es como tener un contenedor vacío, q luego busca la cita a eliminar y en caso de encontrarla
                              //Se va a guardar en la variable citaWliminar de tipo Cita y luego con if se verifica si
                              //citaEliminar sigue vacia= no encontro nada o si encontro la cita que la elimine
        if (c.getFecha().equals(fecha) && c.getTurno().equals(turno)) {
            citaEliminar = c;
            break;
        }
    }

    if (citaEliminar == null) {
        System.out.println("No se encontró una cita con esa fecha y turno.");
        return;
    }
    
    System.out.println("=== Vas a eliminar la cita ===");
    System.out.println(citaEliminar);
    
    String confirmacion ;
        while (true) {
            System.out.print("¿Desea confirmar la eliminacion? (s/n): ");
            confirmacion = scanner.nextLine();
            
            if (confirmacion.equalsIgnoreCase("n")) {
            System.out.println("✖ Proceso Cancelado");
            return;
            } else if (confirmacion.equalsIgnoreCase("s")) {
            System.out.println("Eliminando...");
                // eliminar la cita
                citas.remove(citaEliminar);
                System.out.println("Cita eliminada correctamente.");
                break;
            } else {
            System.out.println("Carácter no válido. Por favor ingrese 's' o 'n'.");
            }}
}
        

    public static void mostrarHorario() {
        System.out.println(">> Horarios disponibles en el mes:");
        System.out.println("Lunes a Viernes: 10:00 AM - 6:00 PM");
        System.out.println("Turnos repartidos por hora en un orden del 1 al 8");
        System.out.println("Siendo 1 =10AM-11AM ");
        System.out.println("Siendo 2 =11AM-12PM ");
        System.out.println("Siendo 3 =12PM-1PM ");
        System.out.println("Siendo 4 =1PM-2PM ");
        System.out.println("Siendo 5 =2PM-3PM ");
        System.out.println("Siendo 6 =3PM-4PM ");
        System.out.println("Siendo 7 =4PM-5PM ");
        System.out.println("Siendo 8 =5PM-6PM ");
        
    }

    public static void mostrarPacientesConCita() {
        
                if (pacientes.isEmpty()) {
                System.out.println("No hay pacientes registrados.");
                } else {
                for (Cita c : citas) {
                System.out.println(c);
            }
        }
    }

    public static void buscarPacientePorId(Scanner scanner) {
        
        System.out.print("Ingrese ID del paciente: ");
        String id = scanner.nextLine();
        boolean encontrado = false;

        for (Paciente p : pacientes) {
            if (p.getId().equals(id)) {
                System.out.println( p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Paciente no encontrado.");
        }
        
    }

    public static void mostrarCitasPorDoctor() {
        
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        for (Doctor d : doctores) {
            System.out.println("Doctor: " + d.getNombre());
            int contador = 0;
            for (Cita c : citas){
                if (c.getDoctor().equals(d.getNombre())) {
                    System.out.println("   - " + c.getFecha() + " | " + c.getUsuario()+ " | " + c.getTurno());
                    contador++;
                }
            }
            System.out.println("Total de citas: " + contador);
        }
    }
        
    private static void buscarCitasPorFecha(Scanner scanner){
        System.out.print("Ingrese la fecha (Dia-Mes-Año)");
        String fecha = scanner.nextLine();
        boolean encontrado = false;

        for (Cita c : citas) {
            if (c.getFecha().equals(fecha)) {
                System.out.println(c);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay citas en esa fecha.");
        }
    }
}