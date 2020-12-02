package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "response_to_ticket")
public class ResponseToTicket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_response", nullable = false)
    private Integer idResponse;

    @Column(name = "id_ticket", nullable = false)
    private Integer idTicket;

    @Column(name = "id_user", nullable = false)
    private Integer idUser;

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

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
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
                "idTicket=" + idTicket + '\'' +
                "idUser=" + idUser + '\'' +
                "responseDate=" + responseDate + '\'' +
                "message=" + message + '\'' +
                '}';
    }
}
