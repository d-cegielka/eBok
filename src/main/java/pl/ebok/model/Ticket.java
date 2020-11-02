package pl.ebok.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ticket {
    @GeneratedValue
    @Id
    private Integer ticketId;

    @ManyToOne
    private User user;

    @Column
    private String topic;

    @Column
    @Lob
    private String message;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private String status;

    @OneToMany(mappedBy = "ticket")
    private List<ResponseToTicket> responses;

    public Integer getTicketId() {
        return ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResponseToTicket> getResponses() {
        return responses;
    }

    public void setResponses(List<ResponseToTicket> responses) {
        this.responses = responses;
    }
}
