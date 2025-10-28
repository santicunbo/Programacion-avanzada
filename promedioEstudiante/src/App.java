
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Ana", "Niño", 20, "ana@gmail.com", "1101","Matemáticas", 4.2f));
        estudiantes.add(new Estudiante("Ana", "Gómez", 20, "ana@gmail.com", "1101", "Matemáticas", 4.0f));
        estudiantes.add(new Estudiante("Luis", "Pérez", 21, "luis@gmail.com", "1102", "Física", 3.5f));
        estudiantes.add(new Estudiante("Marta", "López", 19, "marta@gmail.com", "1103", "Química", 2.8f));
        estudiantes.add(new Estudiante("Carlos", "Ramírez", 22, "carlos@gmail.com", "1104", "Biología", 4.5f));
        estudiantes.add(new Estudiante("Lucía", "Martínez", 20, "lucia@gmail.com", "1105", "Historia", 3.2f));
        estudiantes.add(new Estudiante("Pedro", "Sánchez", 23, "pedro@gmail.com", "1106", "Geografía", 4.8f));
        estudiantes.add(new Estudiante("Elena", "Torres", 19, "elena@gmail.com", "1107", "Literatura", 2.5f));
        estudiantes.add(new Estudiante("Jorge", "Ramón", 21, "jorge@gmail.com", "1108", "Arte", 3.0f));
        estudiantes.add(new Estudiante("Sofía", "Hernández", 20, "sofia@gmail.com", "1109", "Música", 4.2f));

        for (Estudiante e : estudiantes) {
            e.mostrarInfo(); // polimorfismo: método sobrescrito
            System.out.println("Aprueba: " + (e.aprueba() ? "Sí" : "No"));
            System.out.println("--------------------------");
        }
    }
}