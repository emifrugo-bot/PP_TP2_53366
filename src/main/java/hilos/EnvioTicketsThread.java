package hilos;


import modelo.EventoUniversitario;
import modelo.Inscripcion;
import modelo.actividades.Actividad;

public class EnvioTicketsThread extends Thread {

    private EventoUniversitario evento;

    public EnvioTicketsThread(EventoUniversitario evento) {
        this.evento = evento;
    }

    @Override
    public void run() {

        System.out.println("Hilo de envío de tickets iniciado");

        for (Actividad actividad : evento.getActividades()) {

            for (Inscripcion inscripcion : actividad.getInscripciones()) {

                if (inscripcion.getEstado().equals("CONFIRMADA")
                        && inscripcion.getTicket() != null) {

                    inscripcion.getTicket().enviarTicket();
                }
            }
        }

        System.out.println("Hilo de envío de tickets finalizado");
    }
}


