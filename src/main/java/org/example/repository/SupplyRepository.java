package org.example.repository;

import org.example.model.Astronaut;
import org.example.model.Supply;

import java.util.List;

public class SupplyRepository extends AbstractJSONRepository<Integer, Supply>{
    public SupplyRepository(String fileName) {
        super(fileName, Supply.class);
    }


    protected Integer getId(Supply entity) {
        return entity.getId();
    }
    public List<Supply> findAll() {
        return super.findAll();
    }
}
