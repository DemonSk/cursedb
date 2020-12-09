package com.example.curse.repo;

import com.example.curse.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {


    @Query(value = "SELECT distinct penaltytype FROM penalty natural join ticket natural join (select penaltyid, count(penaltyid)\n" +
            "FROM ticket where extract('month' from ticketdate)  = '12'\n" +
            "              or extract('month' from ticketdate) < '3'group by penaltyid\n" +
            "having count(penaltyid)=(select count(penaltyid)\n" +
            "from ticket where extract('month' from ticketdate)  = '12'\n" +
            "              or extract('month' from ticketdate) < '3' group by penaltyid having count(penaltyid)\n" +
            "= (select max(counted) from\n" +
            "(select count(penaltyid) as counted from ticket where extract('month' from ticketdate)  = '12'\n" +
            "              or extract('month' from ticketdate) < '3' group by penaltyid) as sub1)))\n" +
            "    as sub2 where penaltyid=sub2.penaltyid", nativeQuery = true)
    List<String> WinterPenalty();

    @Query(value = "Select * from sumpenalty()", nativeQuery = true)
    List<String> PenaltySum();

    @Query(value = "Select * from ticket natural join (SELECT personid, min(current_date - ticket.ticketdate) as mindate FROM ticket\n" +
            "WHERE (current_date - ticket.ticketdate)>0 group by personid) as sub\n" +
            "where (current_date - ticket.ticketdate) = mindate and personid=sub.personid", nativeQuery = true)
    List<String> PenaltyByDriver();

    @Query(value = "SELECT * FROM ticket where payed is null", nativeQuery = true)
    List<String> PenaltyPay();

    @Query(value = "SELECT fullname , COUNT(personid)\n" +
            "        FROM ticket join drivers d on d.driverid = ticket.personid GROUP BY fullname\n" +
            "            HAVING COUNT (fullname)=(\n" +
            "                SELECT MAX(mycount)\n" +
            "                    FROM (\n" +
            "                        SELECT personid, COUNT(personid) mycount\n" +
            "                            FROM ticket\n" +
            "                                 GROUP BY personid\n" +
            "                                    ) as sub1)", nativeQuery = true)
    List<String> MaxPenalties();

    @Query(value = "SELECT fullname, count(distinct penaltyid) FROM ticket\n" +
            "    join drivers d on d.driverid = ticket.personid\n" +
            "group by fullname \n" +
            "having count(distinct penaltyid)=(SELECT count(penaltyid) from penalty)", nativeQuery = true)
    List<String> AllPenalties();

    @Query(value = "SELECT * from ticket where date_trunc('quarter', current_date)<=ticketdate and\n" +
            "                           date_trunc('quarter', current_date)+interval '3 month'>ticketdate", nativeQuery = true)
    List<String> QuaterTicket();

    @Query(value = "SELECT * FROM ticket where payed is not null and payed< date_trunc('month', current_date) and\n" +
            "                           payed >= date_trunc('month', current_date) - interval '1 month'", nativeQuery = true)
    List<String> LastMonthPay();


}
