package com.reservaciones_restaurante.services;

import com.reservaciones_restaurante.model.Tables;
import com.reservaciones_restaurante.repository.TablesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablesService {

    private final TablesRepository tablesRepository;

    // Constructor injection
    public TablesService(TablesRepository tablesRepository) {
        this.tablesRepository = tablesRepository;
    }

    public List<Tables> getAllTables() {
        return tablesRepository.findAll();
    }

    public Optional<Tables> getTableById(int id) {
        return tablesRepository.findById(id);
    }

    public Tables saveTable(Tables table) {
        return tablesRepository.save(table);
    }

    public void deleteTable(int id) {
        tablesRepository.deleteById(id);
    }
}
