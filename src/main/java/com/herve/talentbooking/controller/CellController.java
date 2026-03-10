package com.herve.talentbooking.controller;

import com.herve.talentbooking.model.Cell;
import com.herve.talentbooking.service.CellService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cells")
public class CellController {

    private final CellService cellService;

    public CellController(CellService cellService) {
        this.cellService = cellService;
    }

    @PostMapping
    public Cell createCell(@RequestBody Cell cell) {
        return cellService.saveCell(cell);
    }

    @GetMapping
    public Page<Cell> getAllCells(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy
    ) {
        if (sortBy != null && !sortBy.isEmpty()) {
            return cellService.getAllCells(page, size, sortBy);
        }
        return cellService.getAllCells(page, size);
    }

    @GetMapping("/by-sector/{sectorId}")
    public List<Cell> getCellsBySector(@PathVariable Long sectorId) {
        return cellService.getCellsBySectorId(sectorId);
    }

    @PutMapping("/{id}")
    public Cell updateCell(@PathVariable Long id, @RequestBody Cell cell) {
        return cellService.updateCell(id, cell);
    }

    @DeleteMapping("/{id}")
    public void deleteCell(@PathVariable Long id) {
        cellService.deleteCell(id);
    }
}
