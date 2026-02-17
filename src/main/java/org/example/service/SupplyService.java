package org.example.service;
import org.example.repository.SupplyRepository;
import org.example.model.Supply;
public class SupplyService {
    private SupplyRepository repo ;
    public SupplyService(SupplyRepository repo) {
        this.repo = repo;
    }


    public Supply findById(Integer id) {
        return repo.findOne(id);
    }

}
