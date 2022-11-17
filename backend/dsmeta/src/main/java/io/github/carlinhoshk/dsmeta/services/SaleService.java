package io.github.carlinhoshk.dsmeta.services;

import io.github.carlinhoshk.dsmeta.entities.Sale;
import io.github.carlinhoshk.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public List<Sale> findSales() {
        return repository.findAll();

    }
}
