package pl.ebok.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import pl.ebok.IHelpdesk;
import pl.ebok.model.ResponseToTicket;
import pl.ebok.model.Ticket;
import pl.ebok.repository.ResponseToTicketRepository;
import pl.ebok.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories(basePackageClasses = {TicketRepository.class, ResponseToTicketRepository.class})
@RestController
public class HelpdeskManager implements IHelpdesk {
    private final TicketRepository ticketRepository;
    private final ResponseToTicketRepository responseToTicketRepository;

    @Autowired
    public HelpdeskManager(TicketRepository ticketRepository, ResponseToTicketRepository responseToTicketRepository) {
        this.ticketRepository = ticketRepository;
        this.responseToTicketRepository = responseToTicketRepository;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<ResponseToTicket> getAllResponses() {
        return responseToTicketRepository.findAll();
    }

    @Override
    public List<ResponseToTicket> getAllTicketResponses(Integer id_ticket) {
        Optional<Ticket> ticket = ticketRepository.findById(id_ticket);
        if (ticket.isEmpty())
            return null;

        return ticket.get().getResponsesToTicket();
    }

    @Override
    public Optional<Ticket> getTicketById(Integer id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Optional<ResponseToTicket> getResponseToTicketById(Integer id) {
        return responseToTicketRepository.findById(id);
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public ResponseToTicket addResponseToTicket(ResponseToTicket response) {
        return responseToTicketRepository.save(response);
    }

    @Override
    public Ticket updateTicket(Ticket changedTicket, Integer id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isEmpty())
            return null;

        changedTicket.setIdTicket(id);
        return ticketRepository.save(changedTicket);
    }

    @Override
    public ResponseToTicket updateResponseToTicket(ResponseToTicket changedResponse, Integer id) {
        Optional<ResponseToTicket> response = responseToTicketRepository.findById(id);
        if (response.isEmpty())
            return null;

        changedResponse.setIdResponse(id);
        return responseToTicketRepository.save(changedResponse);
    }

}
