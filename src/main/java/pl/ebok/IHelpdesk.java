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

    @GetMapping("/responses/{id}")
    Optional<ResponseToTicket> getResponseToTicketById(@PathVariable Integer id);

    @PostMapping("/")
    Ticket addTicket(@RequestBody Ticket ticket);

    @PostMapping("/responses/")
    ResponseToTicket addResponseToTicket(@RequestBody ResponseToTicket response);

    @PutMapping("/{id}")
    Ticket updateTicket(@RequestBody Ticket changedTicket, @PathVariable Integer id);

    @PutMapping("/responses/{id}")
    ResponseToTicket updateResponseToTicket(@RequestBody ResponseToTicket changedResponse, @PathVariable Integer id);

}
