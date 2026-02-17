package org.example.service;
import org.example.repository.SupplyRepository;
import org.example.model.Supply;

import java.util.List;

public class SupplyService {
    private SupplyRepository repo ;
    public SupplyService(SupplyRepository repo) {
        this.repo = repo;
    }


    public Supply findById(Integer id) {
        return repo.findOne(id);
    }
public List<Supply> findAll(){
        return repo.findAll();
    }
}
