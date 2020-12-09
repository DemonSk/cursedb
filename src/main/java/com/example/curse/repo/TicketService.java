package com.example.curse.repo;

import com.example.curse.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket findById(Long id){
        return ticketRepository.getOne(id);
    }

    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    public Ticket saveTicket(Ticket Ticket){
        return ticketRepository.save(Ticket);
    }

    public void deleteById(Long id){
        ticketRepository.deleteById(id);
    }

    public List<String> WinterPenalty() { return ticketRepository.WinterPenalty(); }

    public List<String> PenaltySum(){ return ticketRepository.PenaltySum(); }

    public List<String> PenaltyByDriver(){
        return ticketRepository.PenaltyByDriver();
    }

    public List<String> PenaltyPay() { return ticketRepository.PenaltyPay(); }

    public List<String> MaxPenalties(){ return ticketRepository.MaxPenalties(); }

    public List<String> AllPenalties(){ return ticketRepository.AllPenalties(); }

    public List<String> QuaterTicket(){ return ticketRepository.QuaterTicket(); }

    public List<String> LastMonthPay(){ return ticketRepository.LastMonthPay(); }
}