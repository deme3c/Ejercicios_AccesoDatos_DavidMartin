package pruebas;

public class Tarea {
    private int id;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private boolean finalizada;

    public Tarea(int id, String descripcion, String fechaInicio, String fechaFin, boolean finalizada) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.finalizada = finalizada;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public boolean isFinalizada() {
        return finalizada;
    }
}