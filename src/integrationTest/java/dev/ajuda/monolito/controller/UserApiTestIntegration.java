package dev.ajuda.monolito.controller;

import dev.ajuda.monolito.BaseApiTest;
import dev.ajuda.monolito.dataprovider.database.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("UserApi Integration Tests")
public class UserApiTestIntegration extends BaseApiTest {


    @Test
    @DisplayName("Should register user successfully")
    void shouldRegisterUserSuccessfully() throws Exception {
        mockMvc.perform(post("/v1/user/register")
                        .content("""
                                {
                                   "name": "test user",
                                   "email": "email@email.com",
                                   "password": "1234",
                                   "typeUsers": [
                                     "MENTOR"
                                   ]
                                 }
                                """)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("test user"))
                .andExpect(jsonPath("$.email").value("email@email.com"))
                .andExpect(jsonPath("$.typeUsers[0]").value("MENTOR"));
    }


    @Test
    @DisplayName("Should fail to register because email already exists")
    void shouldReturn400BecauseEmailAlreadyExists() throws Exception {
        userRepository.save(
                UserEntity.builder()
                        .name("test user")
                        .email("email@email.com")
                        .password("1234")
                        .build());
        mockMvc.perform(post("/v1/user/register")
                        .content("""
                                {
                                   "name": "test user",
                                   "email": "email@email.com",
                                   "password": "1234",
                                   "typeUsers": [
                                     "MENTOR"
                                   ]
                                 }
                                """)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.path").value("/v1/user/register"))
                .andExpect(jsonPath("$.date").exists())
                .andExpect(jsonPath("$.errors[?(@.field=='email')].message")
                        .value("Email already exists"));
    }

    @Test
    @DisplayName("Should return 400 when fields is invalid")
    void shouldReturn400WhenFieldsIsInvalid() throws Exception {
        mockMvc.perform(post("/v1/user/register")
                        .content("""
                                {
                                   "name": "",
                                   "email": "",
                                   "password": "",
                                   "typeUsers": [
                                     "MENTOR"
                                   ]
                                 }
                                """)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.path").value("/v1/user/register"))
                .andExpect(jsonPath("$.date").exists())
                .andExpect(jsonPath("$.errors[?(@.field=='name')].message").value("Name is not valid"))
                .andExpect(jsonPath("$.errors[?(@.field=='password')].message").value("Password cannot be empty"))
                .andExpect(jsonPath("$.errors[?(@.field=='email')].message", org.hamcrest.Matchers.containsInAnyOrder(
                        "Email cannot be empty",
                        "Email is not valid"
                )));

    }
}
