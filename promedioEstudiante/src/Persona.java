
class persona {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String email;

    public persona(String nombre, String apellido, int edad, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Email: " + email);
    }
}
