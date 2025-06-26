package dev.ajuda.monolito;

import dev.ajuda.monolito.core.domain.StatesBrazil;
import dev.ajuda.monolito.dataprovider.database.entity.CityEntity;
import dev.ajuda.monolito.dataprovider.database.repository.CityRepository;
import dev.ajuda.monolito.dataprovider.database.repository.CommunityRepository;
import dev.ajuda.monolito.dataprovider.database.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = MonolitoApplication.class)
@ExtendWith(MockitoExtension.class)
public class BaseApiTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected CommunityRepository communityRepository;

    @Autowired
    protected CityRepository cityRepository;

    protected MockMvc mockMvc;



    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @AfterEach
    void setDown() {
        cityRepository.deleteAll();
        communityRepository.deleteAll();
        userRepository.deleteAll();
    }
}
