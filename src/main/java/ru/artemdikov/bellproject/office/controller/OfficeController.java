package ru.artemdikov.bellproject.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.artemdikov.bellproject.office.dto.OfficeDto;
import ru.artemdikov.bellproject.office.dto.OfficeDtoShort;
import ru.artemdikov.bellproject.office.dto.OfficeFilter;
import ru.artemdikov.bellproject.office.service.OfficeService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер для работы с Office
 * @author Artem Dikov
 */
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Создать новый офис
     * @param office - офис
     */
    @PostMapping("/save")
    public void saveOffice(@RequestBody OfficeDto office) {
        officeService.add(office);
    }

    /**
     * Обновить офис
     * @param office - офис
     */
    @PostMapping("/update")
    public void updateOffice(@RequestBody OfficeDto office) {
        officeService.update(office);
    }

    /**
     * Получить все офисы
     * @return возвращает список всех офисов
     */
    @GetMapping("/all")
    public List<OfficeDto> allOffices() {
        return officeService.allOffices();
    }

    /**
     * Получить офис по id
     * @param id  - идентификатор
     * @return возвращает офис
     */
    @GetMapping("/{id}")
    public OfficeDto office(@PathVariable Long id) {
        return officeService.getById(id);
    }

    /**
     * Получить отфильтрованный список офисов
     * @param officeFilter - фильтры
     * @return возвращает отфильтрованный список офисов
     */
    @PostMapping("/list")
    public List<OfficeDtoShort> list(@RequestBody OfficeFilter officeFilter) {
        return officeService.getFilteredOfficeList(officeFilter);
    }
}
