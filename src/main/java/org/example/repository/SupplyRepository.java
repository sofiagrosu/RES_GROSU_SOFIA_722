package org.example.repository;

import org.example.model.Supply;

public class SupplyRepository extends AbstractJSONRepository<Integer, Supply>{
    public SupplyRepository(String fileName) {
        super(fileName, Supply.class);
    }


    protected Integer getId(Supply entity) {
        return entity.getId();
    }
}
