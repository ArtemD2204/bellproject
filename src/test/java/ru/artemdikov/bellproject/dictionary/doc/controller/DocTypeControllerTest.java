package ru.artemdikov.bellproject.dictionary.doc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.artemdikov.bellproject.controller.advice.dto.DataDto;
import ru.artemdikov.bellproject.dictionary.doc.service.DocTypeService;

@SpringBootTest
@AutoConfigureMockMvc
public class DocTypeControllerTest {

    @Autowired
    private DocTypeService docTypeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllDocsTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        DataDto dataDto = new DataDto();
        dataDto.setData(docTypeService.docTypes());
        String expected = objectMapper.writeValueAsString(dataDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/docs"))
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }
}
