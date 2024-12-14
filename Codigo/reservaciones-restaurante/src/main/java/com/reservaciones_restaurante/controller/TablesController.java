package com.reservaciones_restaurante.controller;

import com.reservaciones_restaurante.model.Tables;
import com.reservaciones_restaurante.services.TablesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TablesController {

    private final TablesService tablesService;

    // Constructor injection
    public TablesController(TablesService tablesService) {
        this.tablesService = tablesService;
    }

    @GetMapping
    public List<Tables> getAllTables() {
        return tablesService.getAllTables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tables> getTableById(@PathVariable int id) {
        return tablesService.getTableById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tables createTable(@RequestBody Tables table) {
        return tablesService.saveTable(table);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tables> updateTable(@PathVariable int id, @RequestBody Tables table) {
        return tablesService.getTableById(id)
                .map(existingTable -> {
                    table.setId(id);
                    return ResponseEntity.ok(tablesService.saveTable(table));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable int id) {
        if (tablesService.getTableById(id).isPresent()) {
            tablesService.deleteTable(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
