package dev.ajuda.monolito.controller;

import dev.ajuda.monolito.BaseApiTest;
import dev.ajuda.monolito.core.domain.StatesBrazil;
import dev.ajuda.monolito.dataprovider.database.entity.CityEntity;
import dev.ajuda.monolito.dataprovider.database.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("CommunityApi Integration Tests")
public class CommunityApiTestIntegration extends BaseApiTest {


     @Test
     @DisplayName("Should register community successfully")
     void shouldRegisterCommunitySuccessfully() throws Exception {
         var cityEntity = cityRepository.save(
                 CityEntity.builder()
                         .name("Campos dos Goytacazes")
                         .state(StatesBrazil.RIO_DE_JANEIRO)
                         .build()
         );

         var userEntity =  userRepository.save(UserEntity.builder()
                 .name("test user")
                 .email("email@email.com")
                 .password("1234")
                 .build());
         mockMvc.perform(post("/v1/community/register")
                         .content("""
                                 {
                                   "cityId": %d,
                                   "name": "Test Community",
                                   "description": "test community",
                                   "ownerId": %s
                                 }
                                 """.formatted(cityEntity.getId(), userEntity.getId()))
                         .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isCreated());
     }

}
