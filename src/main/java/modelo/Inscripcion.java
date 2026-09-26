package modelo;

import modelo.actividades.Actividad;

import java.io.Serializable;
import java.time.LocalDate;


public class Inscripcion implements Serializable {
    private Actividad actividad;
    private Estudiante estudiante;
    private LocalDate fecha;
    private String estado;
    private TicketDeAcceso ticket;

    public Inscripcion(Actividad actividad, Estudiante estudiante, LocalDate fecha, String estado) {
        this.actividad = actividad;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public TicketDeAcceso getTicket() {
        return ticket;
    }

    public void confirmar() {
        this.estado = "CONFIRMADA";

        if (this.ticket == null) {
            this.ticket = new TicketDeAcceso(
                    "TICKET-" + actividad.getId() + "-" + estudiante.getLegajo(),
                    LocalDate.now()
            );
        }
    }
    public class TicketDeAcceso implements Serializable{
        private String idTicket;
        private LocalDate fechaEmision;
         public TicketDeAcceso(String idTicket, LocalDate fechaEmision){
             this.idTicket=idTicket;
             this.fechaEmision = fechaEmision;
         }
         public void enviarTicket(){
             System.out.println("Enviando ticket "+ idTicket+ " a " + estudiante.getNombre() + " para la actividad" + actividad.getTitulo());
         }

    }
}
