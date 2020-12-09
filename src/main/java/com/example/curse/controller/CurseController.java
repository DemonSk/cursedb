package com.example.curse.controller;

import java.util.List;

import com.example.curse.model.*;
import com.example.curse.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CurseController {


    private final TicketService ticketService;
    private final DriverService DriverService;
    private final InspectorService InspectorService;
    private final PenaltyService PenaltyService;

    @Autowired
    public CurseController(TicketService ticketService, DriverService DriverService, InspectorService InspectorService, PenaltyService PenaltyService) {
        this.ticketService = ticketService;
        this.DriverService = DriverService;
        this.InspectorService = InspectorService;
        this.PenaltyService = PenaltyService;
    }

    @GetMapping("/")
    public String Hub(){
        return "index";
    }

    @GetMapping("/queries")
    public String Queries(){
        return "queries";
    }

    //Ticket Controllers
    @GetMapping("/Tickets")
    public String findAll(Model model){
        List<Ticket> Tickets = ticketService.findAll();
        model.addAttribute("Tickets", Tickets);
        return "Ticket-list";
    }

    @RequestMapping(value = "/Ticket-create", method = RequestMethod.GET)
    public String createTicketForm(Ticket ticket){
        return "ticket-create";
    }


    @GetMapping("/WinterPenalty")
    public String WinterPenalty(Model model){
        List<String> WinterPenalty = ticketService.WinterPenalty();
        model.addAttribute("WinterPenalty", WinterPenalty);
        return "queryresults";
    }

    @GetMapping("/PenaltySum")
    public String PenaltySum(Model model){
        List<String> PenaltySum = ticketService.PenaltySum();
        model.addAttribute("PenaltySum", PenaltySum);
        return "queryresults";
    }


    @GetMapping("/PenaltyByDriver")
    public String PenaltyByDriver(Model model){
        List<String> PenaltyByDriver = ticketService.PenaltyByDriver();
        model.addAttribute("PenaltyByDriver", PenaltyByDriver);
        return "queryresults";
    }


    @GetMapping("/PenaltyPay")
    public String PenaltyPay(Model model){
        List<String> PenaltyPay = ticketService.PenaltyPay();
        model.addAttribute("PenaltyPay", PenaltyPay);
        return "queryresults";
    }

    @GetMapping("/MaxPenalties")
    public String MaxPenalties(Model model){
        List<String> MaxPenalties = ticketService.MaxPenalties();
        model.addAttribute("MaxPenalties", MaxPenalties);
        return "queryresults";
    }

    @GetMapping("/AllPenalties")
    public String AllPenalties(Model model){
        List<String> AllPenalties = ticketService.AllPenalties();
        model.addAttribute("AllPenalties", AllPenalties);
        return "queryresults";
    }

    @GetMapping("/QuaterTicket")
    public String QuaterTicket(Model model){
        List<String> QuaterTicket = ticketService.QuaterTicket();
        model.addAttribute("QuaterTicket", QuaterTicket);
        return "queryresults";
    }

    @GetMapping("/LastMonthPay")
    public String LastMonthPay(Model model){
        List<String> LastMonthPay = ticketService.LastMonthPay();
        model.addAttribute("LastMonthPay", LastMonthPay);
        return "queryresults";
    }

    @PostMapping("/Ticket-create")
    public String createTicket(@Valid Ticket Ticket){
        ticketService.saveTicket(Ticket);
        return "redirect:/Tickets";
    }

    @GetMapping("Ticket-delete/{id}")
    public String deleteTicket(@PathVariable("id") Long id){
        ticketService.deleteById(id);
        return "redirect:/Tickets";
    }

    @GetMapping("/Ticket-update/{id}")
    public String updateTicketForm(@PathVariable("id") Long id, Model model){
        Ticket Ticket = ticketService.findById(id);
        model.addAttribute("Ticket", Ticket);
        return "Ticket-update";
    }

    @PostMapping("/Ticket-update")
    public String updateTicket(@Valid Ticket Ticket) {
        ticketService.saveTicket(Ticket);
        return "redirect:/Tickets";
    }


    //Driver Controllers
    @GetMapping("/Drivers")
    public String findAllDrivers(Model model){
        List<Driver> Drivers = DriverService.findAll();
        model.addAttribute("Drivers", Drivers);
        return "Driver-list";
    }

    @GetMapping("/Driver-create")
    public String createDriverForm(Driver driver){
        return "driver-create";
    }

    @PostMapping("/Driver-create")
    public String createDriver(@Valid Driver Driver){
        DriverService.saveDriver(Driver);
        return "redirect:/Drivers";
    }

    @GetMapping("Driver-delete/{DriverID}")
    public String deleteDriver(@PathVariable("DriverID") Long id){
        DriverService.deleteById(id);
        return "redirect:/Drivers";
    }

    @GetMapping("/Driver-update/{DriverID}")
    public String updateDriverForm(@PathVariable("DriverID") Long id, Model model){
        Driver Driver = DriverService.findById(id);
        model.addAttribute("Driver", Driver);
        return "Driver-update";
    }

    @PostMapping("/Driver-update")
    public String updateDriver(@Valid Driver Driver) {
        DriverService.saveDriver(Driver);
        return "redirect:/Drivers";
    }


    //Inspector Controller

    @GetMapping("/Inspectors")
    public String findAllInspectors(Model model){
        List<Inspector> Inspectors = InspectorService.findAll();
        model.addAttribute("Inspectors", Inspectors);
        return "Inspector-list";
    }

    @GetMapping("/Inspector-create")
    public String createInspectorForm(Inspector Inspector){
        return "Inspector-create";
    }

    @PostMapping("/Inspector-create")
    public String createInspector(@Valid Inspector Inspector){
        InspectorService.saveInspector(Inspector);
        return "redirect:/Inspectors";
    }

    @GetMapping("Inspector-delete/{InspectorID}")
    public String deleteInspector(@PathVariable("InspectorID") Long id){
        InspectorService.deleteById(id);
        return "redirect:/Inspectors";
    }

    @GetMapping("/Inspector-update/{InspectorID}")
    public String updateInspectorForm(@PathVariable("InspectorID") Long id, Model model){
        Inspector Inspector = InspectorService.findById(id);
        model.addAttribute("Inspector", Inspector);
        return "Inspector-update";
    }

    @PostMapping("/Inspector-update")
    public String updateInspector(@Valid Inspector Inspector) {
        InspectorService.saveInspector(Inspector);
        return "redirect:/Inspectors";
    }

    //Penalty Controller

    @GetMapping("/Penalties")
    public String findAllDiagnoses(Model model){
        List<Penalty> Penalties = PenaltyService.findAll();
        model.addAttribute("Penalties", Penalties);
        return "Penalty-list";
    }

    @GetMapping("/Penalty-create")
    public String createPenaltyForm(Penalty Penalty){
        return "Penalty-create";
    }

    @PostMapping("/Penalty-create")
    public String createPenalty(@Valid Penalty Penalty){
        PenaltyService.savePenalty(Penalty);
        return "redirect:/Penalties";
    }

    @GetMapping("Penalty-delete/{PenaltyID}")
    public String deletePenalty(@PathVariable("PenaltyID") Long id){
        PenaltyService.deleteById(id);
        return "redirect:/Penalties";
    }

    @GetMapping("/Penalty-update/{PenaltyID}")
    public String updatePenaltyForm(@PathVariable("PenaltyID") Long id, Model model){
        Penalty Penalty = PenaltyService.findById(id);
        model.addAttribute("Penalty", Penalty);
        return "Penalty-update";
    }

    @PostMapping("/Penalty-update")
    public String updatePenalty(@Valid Penalty Penalty) {
        PenaltyService.savePenalty(Penalty);
        return "redirect:/Penalties";
    }


}