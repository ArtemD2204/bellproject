package ru.artemdikov.bellproject.dictionary.country.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.artemdikov.bellproject.controller.advice.dto.DataDto;
import ru.artemdikov.bellproject.dictionary.country.service.CountryService;

@SpringBootTest
@AutoConfigureMockMvc
public class CountryControllerTest {

    @Autowired
    private CountryService countryService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllCountriesTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        DataDto dataDto = new DataDto();
        dataDto.setData(countryService.countries());
        String expected = objectMapper.writeValueAsString(dataDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries"))
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }
}
