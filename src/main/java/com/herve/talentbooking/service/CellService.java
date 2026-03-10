package com.herve.talentbooking.service;

import com.herve.talentbooking.model.Cell;
import com.herve.talentbooking.repository.CellRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CellService {

    private final CellRepository cellRepository;

    public CellService(CellRepository cellRepository) {
        this.cellRepository = cellRepository;
    }

    public Cell saveCell(Cell cell) {
        return cellRepository.save(cell);
    }

    public List<Cell> getAllCells() {
        return cellRepository.findAll();
    }

    public Page<Cell> getAllCells(int page, int size) {
        return cellRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Cell> getAllCells(int page, int size, String sortBy) {
        return cellRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    public List<Cell> getCellsBySectorId(Long sectorId) {
        return cellRepository.findBySectorId(sectorId);
    }

    public Cell updateCell(Long id, Cell cell) {
        Cell existing = cellRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cell not found"));
        existing.setName(cell.getName());
        if (cell.getSector() != null) {
            existing.setSector(cell.getSector());
        }
        return cellRepository.save(existing);
    }

    public void deleteCell(Long id) {
        cellRepository.deleteById(id);
    }
}
