package ru.artemdikov.bellproject.office.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.artemdikov.bellproject.controller.advice.dto.DataDto;
import ru.artemdikov.bellproject.controller.advice.dto.SuccessDto;
import ru.artemdikov.bellproject.office.dto.OfficeDto;
import ru.artemdikov.bellproject.office.dto.OfficeFilter;
import ru.artemdikov.bellproject.office.service.OfficeService;

@SpringBootTest
@AutoConfigureMockMvc
public class OfficeControllerTest {

    @Autowired
    private OfficeService officeService;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void saveOfficeTest() throws Exception {
        OfficeDto officeDto = new OfficeDto();
        officeDto.setOrgId(1L);
        String expected = objectMapper.writeValueAsString(new SuccessDto());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(officeDto)))
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    public void updateOfficeTest() throws Exception {
        OfficeDto officeDto = new OfficeDto();
        officeDto.setId(1L);
        officeDto.setName("Office name");
        officeDto.setAddress("ул.Ленина, д.1");
        String expected = objectMapper.writeValueAsString(new SuccessDto());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(officeDto)))
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    public void getAllOfficesTest() throws Exception {
        DataDto expectedData = new DataDto();
        expectedData.setData(officeService.allOffices());
        String expectedDataString = objectMapper.writeValueAsString(expectedData);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/office/all"))
                .andExpect(MockMvcResultMatchers.content().json(expectedDataString));
    }

    @Test
    public void getOfficeTest() throws Exception {
        Long officeId = 1L;
        DataDto expectedData = new DataDto();
        expectedData.setData(officeService.getById(officeId));
        String expectedDataString = objectMapper.writeValueAsString(expectedData);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/office/" + officeId))
                .andExpect(MockMvcResultMatchers.content().json(expectedDataString));
    }

    @Test
    public void getListTest() throws Exception {
        OfficeFilter officeFilter = new OfficeFilter();
        officeFilter.setOrgId(1L);
        String officeFilterString = objectMapper.writeValueAsString(officeFilter);
        DataDto expectedData = new DataDto();
        expectedData.setData(officeService.getFilteredOfficeList(officeFilter));
        String expectedDataString = objectMapper.writeValueAsString(expectedData);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/office/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(officeFilterString))
                .andExpect(MockMvcResultMatchers.content().json(expectedDataString));
    }
}
