package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "response_to_ticket")
public class ResponseToTicket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_response", nullable = false)
    private Integer idResponse;

    @ManyToOne
    @JoinColumn(name = "id_ticket", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "response_date", nullable = false)
    private LocalDate responseDate;

    @Column(name = "message", length = 500, nullable = false)
    private String message;

    public void setIdResponse(Integer idResponse) {
        this.idResponse = idResponse;
    }

    public Integer getIdResponse() {
        return idResponse;
    }

    public void setTicket(Ticket idTicket) {
        this.ticket = idTicket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setUser(User idUser) {
        this.user = idUser;
    }

    public User getUser() {
        return user;
    }

    public void setResponseDate(LocalDate responseDate) {
        this.responseDate = responseDate;
    }

    public LocalDate getResponseDate() {
        return responseDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResponseToTicket{" +
                "idResponse=" + idResponse + '\'' +
                "idTicket=" + ticket + '\'' +
                "idUser=" + user + '\'' +
                "responseDate=" + responseDate + '\'' +
                "message=" + message + '\'' +
                '}';
    }
}
