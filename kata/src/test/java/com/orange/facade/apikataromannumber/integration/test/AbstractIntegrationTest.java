package com.orange.facade.apikataromannumber.integration.test;

import org.junit.jupiter.api.extension.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.orange.facade.apikataromannumber.ApiKataRomanNumberApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ApiKataRomanNumberApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public abstract class AbstractIntegrationTest {
   protected MockMvc mvc;
   @Autowired
   WebApplicationContext webApplicationContext;

   protected void setUp() throws Exception {
      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
   }
}
