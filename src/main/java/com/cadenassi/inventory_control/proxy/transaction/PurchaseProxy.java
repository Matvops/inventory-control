package com.cadenassi.inventory_control.proxy.transaction;

import com.cadenassi.inventory_control.dto.objects.purchase.PurchaseDTO;
import com.cadenassi.inventory_control.exceptions.InvalidArgumentException;
import com.cadenassi.inventory_control.exceptions.ResourceNotFoundException;
import com.cadenassi.inventory_control.proxy.GenericServiceProxy;
import com.cadenassi.inventory_control.services.transaction.PurchaseService;
import com.cadenassi.inventory_control.services.transaction.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PurchaseProxy extends GenericServiceProxy implements PurchaseService {

    @Autowired
    private PurchaseServiceImpl service;

    @Override
    public List<PurchaseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public PurchaseDTO getPurchaseById(String id) {
        verifyIsNull(id);
        verifyIsNumber(id);

        return service.getPurchaseById(id);
    }

    @Override
    public List<PurchaseDTO> getPurchaseByDate(String date) {
        verifyIsNull(date);

        Instant parsedDate = toInstant(date);

        validateDate(parsedDate);

        return service.getPurchaseByDate(toPatternInstant(date));
    }

    @Override
    public List<PurchaseDTO> getPurchaseByTimeRange(String first, String last) {
        verifyIsNull(first);
        verifyIsNull(last);

        Instant parsedFirstDate = toInstant(first);
        Instant parsedLastDate = toInstant(last);

        validateDate(parsedFirstDate, parsedLastDate);

        return service.getPurchaseByTimeRange(toPatternInstant(first), toPatternInstant(last));
    }


    @Override
    public PurchaseDTO insertPurchase(PurchaseDTO purchaseDTO) {
        if(purchaseDTO.getProducts().isEmpty()) {
            throw new ResourceNotFoundException("DOES NOT CONTAIN PRODUCTS IN THE PURCHASE");
        }

        purchaseDTO.getProducts().forEach(x -> {
            verifyIsNull(x);
            verifyIsNull(x.getName());
            verifyIsNull(x.getQuantity());
            verifyIsNull(x.getPrice());
            verifyIsNull(x.getCategory());
        });

        return service.insertPurchase(purchaseDTO);
    }

    @Override
    public PurchaseDTO addProductById(PurchaseDTO purchaseDTO) {
        return null;
    }


    @Override
    public PurchaseDTO updateDescription(String description) {
        return null;
    }

    //Day/Month/Year
    private Instant toInstant(String date){
        String[] parts = date.split("/");

        verifyIsNumber(parts[0]);
        verifyIsNumber(parts[1]);
        verifyIsNumber(parts[2]);

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        validateDayMonthAndYear(day, month, year);

        return LocalDateTime.of(year, month, day, 0, 0, 0)
                .toInstant(ZoneOffset.of(ZoneId
                        .systemDefault()
                        .getId()));
    }

    private String toPatternInstant(String pattern){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.systemDefault());


        LocalDate date = LocalDate.parse(pattern, fmt);

        return date.toString();
    }

    private void validateDate(Instant... date) {
        List<Instant> dates = new ArrayList<>(Arrays.asList(date));

        dates.forEach(x -> {
            if(x.isAfter(Instant.now())) {
                throw new InvalidArgumentException("FUTURE DATE");
            }
        });

        if(date.length == 2) {
            if(dates.getFirst().isAfter(dates.getLast())) {
                throw new InvalidArgumentException("THE FIRST DATE COMES AFTER THE LAST DATE");
            }
        }
    }

    private void validateDayMonthAndYear(int day, int month, int year){
        if(day < 1 || day > 31) throw new InvalidArgumentException("DAY " + day + " NOT EXISTS!");
        if(month < 1 || month > 12) throw new InvalidArgumentException("INVALID MONTH");
        if(year < 1970 || year > Instant.now().get(ChronoField.YEAR)) throw new InvalidArgumentException("INVALID YEAR");


        if(month == 2 && day > 28) {
            throw new InvalidArgumentException("THE LAST DAY OF FEBRUARY IS THE 28TH");
        }
    }
}
