package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Supply implements HasId<Integer>{
    // "id": 1,
    //    "astronautId": 1,
    //    "type": "OXYGEN",
    //    "value": 12
    //  },
    @JsonProperty("id") Integer id;
    @JsonProperty("astronautId") Integer astronautId;
    @JsonProperty("type") SupplyType type;
    @JsonProperty("value") Integer value;

    public Supply(Integer id, Integer astronautId, SupplyType type, Integer value) {
        this.id = id;
        this.astronautId = astronautId;
        this.type = type;
        this.value = value;
    }

    public Supply() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getAstronautId() {
        return astronautId;
    }


    public void setAstronautId(Integer astronautId) {
        this.astronautId = astronautId;
    }

    public SupplyType getType() {
        return type;
    }

    public void setType(SupplyType type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
