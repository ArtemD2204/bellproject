package ru.artemdikov.bellproject.user.controller;

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
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.dto.UserDtoShort;
import ru.artemdikov.bellproject.user.dto.UserFilter;
import ru.artemdikov.bellproject.user.service.UserService;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveUserTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        UserDto userDto = new UserDto();
        userDto.setOfficeId(1L);
        userDto.setFirstName("Ivan");
        userDto.setPosition("Director");
        SuccessDto successDto = new SuccessDto();
        String expected = objectMapper.writeValueAsString(successDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    public void updateUserTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setFirstName("Ivan");
        userDto.setPosition("Director");
        SuccessDto successDto = new SuccessDto();
        String expected = objectMapper.writeValueAsString(successDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    public void getAllUsersTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        DataDto expectedData = new DataDto();
        expectedData.setData(userService.allUsers());
        String expectedDataString = objectMapper.writeValueAsString(expectedData);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/all"))
                .andExpect(MockMvcResultMatchers.content().json(expectedDataString));
    }

    @Test
    public void getUserTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Long userId = 1L;
        DataDto expectedData = new DataDto();
        expectedData.setData(userService.getById(userId));
        String expectedDataString = objectMapper.writeValueAsString(expectedData);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/" + userId))
                .andExpect(MockMvcResultMatchers.content().json(expectedDataString));
    }

    @Test
    public void getListTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        UserFilter userFilter = new UserFilter();
        userFilter.setOfficeId(1L);
        String userFilterString = objectMapper.writeValueAsString(userFilter);
        List<UserDtoShort> userDtoShortList = userService.filteredUserList(userFilter);
        DataDto expectedData = new DataDto();
        expectedData.setData(userDtoShortList);
        String expectedDataString = objectMapper.writeValueAsString(expectedData);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userFilterString))
                .andExpect(MockMvcResultMatchers.content().json(expectedDataString));
    }
}
