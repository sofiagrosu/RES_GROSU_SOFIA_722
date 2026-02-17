package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MissionEvent implements HasId<Integer>{


    @JsonProperty("id") Integer id;
    @JsonProperty("astronautId") Integer astronautId;
    @JsonProperty("day") Integer day;
    @JsonProperty("type") MissionEventType type;
    @JsonProperty("basePoints") Integer basePoints;

    public MissionEvent(Integer id, Integer astronautId, Integer day, MissionEventType type, Integer basePoints) {
        this.id = id;
        this.astronautId = astronautId;
        this.day = day;
        this.type = type;
        this.basePoints = basePoints;
    }

    public MissionEvent() {
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

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public MissionEventType getType() {
        return type;
    }

    public void setType(MissionEventType type) {
        this.type = type;
    }

    public Integer getBasePoints() {
        return basePoints;
    }

    public void setBasePoints(Integer basePoints) {
        this.basePoints = basePoints;
    }


}
