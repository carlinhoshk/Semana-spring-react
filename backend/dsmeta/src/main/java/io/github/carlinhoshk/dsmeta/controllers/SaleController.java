package io.github.carlinhoshk.dsmeta.controllers;

import io.github.carlinhoshk.dsmeta.entities.Sale;
import io.github.carlinhoshk.dsmeta.services.SaleService;
import io.github.carlinhoshk.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    @Autowired
    private SaleService service;
    @Autowired
    private SmsService smsService;
    @GetMapping
    public Page<Sale> findSales(
        @RequestParam(value="minDate", defaultValue = "") String minDate,
        @RequestParam(value="maxDate", defaultValue = "") String maxDate,
        Pageable pageable){
        return service.findSales(minDate, maxDate, pageable);
    }
    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
