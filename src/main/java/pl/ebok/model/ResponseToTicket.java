package pl.ebok.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ResponseToTicket {
    @GeneratedValue
    @Id
    private Integer responseId;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private User respondingUser;

    @Column
    private LocalDateTime responseDate;

    @Column
    @Lob
    private String message;

    public Integer getResponseId() {
        return responseId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getRespondingUser() {
        return respondingUser;
    }

    public void setRespondingUser(User respondingUser) {
        this.respondingUser = respondingUser;
    }

    public LocalDateTime getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(LocalDateTime responseDate) {
        this.responseDate = responseDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
