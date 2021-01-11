package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "ticket")
@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket", nullable = false)
    private Integer idTicket;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "topic", length = 50, nullable = false)
    private String topic;

    @Column(name = "message", length = 500, nullable = false)
    private String message;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;

    @OneToMany(mappedBy = "ticket")
    private List<ResponseToTicket> responsesToTicket;

    public Ticket setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
        return this;
    }

    public List<ResponseToTicket> getResponsesToTicket() {
        return responsesToTicket;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public Ticket setUser(User idUser) {
        this.user = idUser;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Ticket setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public Ticket setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Ticket setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Ticket setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Ticket setStatus(Status idStatus) {
        this.status = idStatus;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket + '\'' +
                "idUser=" + user + '\'' +
                "topic=" + topic + '\'' +
                "message=" + message + '\'' +
                "createdDate=" + createdDate + '\'' +
                "endDate=" + endDate + '\'' +
                "idStatus=" + status + '\'' +
                '}';
    }
}
