package ru.artemdikov.bellproject.organization.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.artemdikov.bellproject.controller.advice.dto.DataDto;
import ru.artemdikov.bellproject.controller.advice.dto.SuccessDto;
import ru.artemdikov.bellproject.organization.dto.OrgDto;
import ru.artemdikov.bellproject.organization.dto.OrgFilter;
import ru.artemdikov.bellproject.organization.service.OrganizationService;

@SpringBootTest
@AutoConfigureMockMvc
public class OrganizationControllerTest {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void saveOrganizationTest() throws Exception {
        OrgDto orgDto = new OrgDto();
        orgDto.setName("org name");
        orgDto.setFullName("org full name");
        orgDto.setAddress("ул.Гагарина, д.1");
        orgDto.setInn("123");
        orgDto.setKpp("456");
        String expected = objectMapper.writeValueAsString(new SuccessDto());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orgDto)))
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    public void updateOrganizationTest() throws Exception {
        OrgDto orgDto = new OrgDto();
        orgDto.setId(1L);
        orgDto.setName("org name");
        orgDto.setFullName("org full name");
        orgDto.setAddress("ул.Гагарина, д.1");
        orgDto.setInn("123");
        orgDto.setKpp("456");
        String expected = objectMapper.writeValueAsString(new SuccessDto());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orgDto)))
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    public void getAllOrganizationsTest() throws Exception {
        DataDto expectedData = new DataDto();
        expectedData.setData(organizationService.allOrganizations());
        String expectedDataString = objectMapper.writeValueAsString(expectedData);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/organization/all"))
                .andExpect(MockMvcResultMatchers.content().json(expectedDataString));
    }

    @Test
    public void getOrganizationTest() throws Exception {
        Long organizationId = 1L;
        DataDto expectedData = new DataDto();
        expectedData.setData(organizationService.getById(organizationId));
        String expectedDataString = objectMapper.writeValueAsString(expectedData);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/organization/" + organizationId))
                .andExpect(MockMvcResultMatchers.content().json(expectedDataString));
    }

    @Test
    public void getListTest() throws Exception {
        OrgFilter orgFilter = new OrgFilter();
        orgFilter.setName("IBM");
        String orgFilterString = objectMapper.writeValueAsString(orgFilter);
        DataDto expectedData = new DataDto();
        expectedData.setData(organizationService.getFilteredOrganizationList(orgFilter));
        String expectedDataString = objectMapper.writeValueAsString(expectedData);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/organization/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orgFilterString))
                .andExpect(MockMvcResultMatchers.content().json(expectedDataString));
    }
}
