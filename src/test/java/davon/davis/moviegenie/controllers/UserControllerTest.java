//package davon.davis.moviegenie.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import davon.davis.moviegenie.User;
//import davon.davis.moviegenie.services.UserService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(UserController.class)
//class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @Test
//    void shouldSaveUserWhenANewUserIsAdded() throws Exception {
//        when(userService.addUser("new-user")).thenReturn(new User("new-user"));
//
//        this.mockMvc.perform(post("/users").contentType(MediaType.TEXT_PLAIN).content("new-user"))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name").value("new-user"));
//    }
//
//    @Test
//    void shouldFindAllUsers() throws Exception {
//        when(userService.getUsers()).thenReturn(List.of(
//                new User("first-user"),
//                new User("second-user")));
//
//        this.mockMvc.perform(get("/users"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].name").value("first-user"))
//                .andExpect(jsonPath("$[1].name").value("second-user"));
//
//        verify(userService).getUsers();
//    }
//
//    @Test
//    void shouldUpdateUserInterest() throws Exception {
//        when(userService.updateUserInterest(1L, "updated-interest")).thenReturn(Optional.of(new User("new-user")));
//
//        this.userService.updateUserInterest(1L, "updated-interest");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(Map.of("interest", "updated-interest"));
//
//        MockHttpServletRequestBuilder request = patch("/users/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json);
//
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("updated-interest"));
//    }
//}