package org.example.repository;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.HasId;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractJSONRepository<ID, E extends HasId<ID>> {
    protected Map<ID, E> entities = new HashMap<>();
    private String fileName;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Class<E> genericType;

    public AbstractJSONRepository(String fileName, Class<E> genericType) {
        this.fileName = fileName;
        this.genericType = genericType;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        loadData();
    }

    public void save(E entity) {
        entities.put(entity.getId(), entity);
        saveToFile();
    }

    public List<E> findAll() {
        return new ArrayList<>(entities.values());
    }

    private void loadData() {
        File file = new File(fileName);
        if (!file.exists()) throw new RuntimeException("Fisierul nu exista");
        try {
            // Logica specială pentru a citi o Listă de tip Generic E
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, genericType);
            List<E> list = objectMapper.readValue(file, type);
            list.forEach(e -> entities.put(e.getId(), e));
        } catch (IOException e) { e.printStackTrace(); }
    }
    public E findOne(ID id) {
        return entities.get(id);
    }

    protected void saveToFile() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), entities.values());
        } catch (IOException e) { e.printStackTrace(); }
    }




}