package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Astronaut implements HasId<Integer>{


    @JsonProperty("id") Integer id;
   @JsonProperty("name") String name;
    @JsonProperty("spacecraft") String spacecraft;
   @JsonProperty("status") AstronautStatus status;
    @JsonProperty("experienceLevel") Integer experienceLevel;

    public Astronaut(Integer id, String name, String spacecraft, AstronautStatus status, Integer experienceLevel) {
        this.id = id;
        this.name = name;
        this.spacecraft = spacecraft;
        this.status = status;
        this.experienceLevel = experienceLevel;
    }

    public Astronaut() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(String spacecraft) {
        this.spacecraft = spacecraft;
    }

    public AstronautStatus getStatus() {
        return status;
    }

    public void setStatus(AstronautStatus status) {
        this.status = status;
    }

    public Integer getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(Integer experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
    @Override
    public String toString(){
//        [#id] name | spacecraft | status | exp=<experienceLevel>

        return String.format("[#%d] %s | %s | %s | exp=%d",id,name,spacecraft,status,experienceLevel);
    }
}
