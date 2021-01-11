package pl.ebok;

import org.springframework.web.bind.annotation.*;
import pl.ebok.model.Hardware;
import pl.ebok.model.ResponseToTicket;
import pl.ebok.model.Ticket;

import java.util.List;
import java.util.Optional;

@RequestMapping("/helpdesk")
public interface IHelpdesk {

    @GetMapping("/")
    List<Ticket> getAllTickets();

    @GetMapping("/responses/")
    List<ResponseToTicket> getAllResponses();

    @GetMapping("/{id_ticket}/responses/")
    List<ResponseToTicket> getAllTicketResponses(@PathVariable Integer id_ticket);

    @GetMapping("/{id}")
    Optional<Ticket> getTicketById(@PathVariable Integer id);

    @GetMapping("/{id_ticket}/{id}")
    Optional<ResponseToTicket> getResponseByTicketId(@PathVariable Integer id_ticket, @PathVariable Integer id);

    @PostMapping("/")
    Ticket addTicket(@RequestBody Ticket ticket);

    @PostMapping("/{id_ticket}/")
    ResponseToTicket addResponseToTicket(@RequestBody ResponseToTicket response, @PathVariable Integer id_ticket);

    @PutMapping("/{id}")
    Ticket updateTicket(@RequestBody Ticket changedTicket, @PathVariable Integer id);

    @PutMapping("/{id_ticket}/{id}")
    ResponseToTicket updateResponseToTicket(@RequestBody ResponseToTicket changedResponse, @PathVariable Integer id_ticket, @PathVariable Integer id);

    @DeleteMapping("/{id}")
    void deleteTicket(@PathVariable Integer id);

    @DeleteMapping("/{id_ticket}/{id}")
    void deleteResponseToTicket(@PathVariable Integer id_ticket, @PathVariable Integer id);
}
