
class Estudiante extends persona {
    private String curso;
    private String materia;
    private float promedio;

    public Estudiante(String nombre, String apellido, int edad, String email, String curso, String materia, float promedio) {
        super(nombre, apellido, edad, email);
        this.curso = curso;
        this.materia = materia;
        this.promedio = promedio;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Curso: " + curso);
        System.out.println("Materia: " + materia);
        System.out.println("Promedio: " + promedio);
    }

    public boolean aprueba() {
        return promedio >= 3.0;
    }
}