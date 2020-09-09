package com.example.aprendendotddcomspring;

import com.example.controller.SalarioMinimoController;
import com.example.model.SalarioMinimo;
import com.example.service.SalarioMinimoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;

public class SalarioMinimoControllerTest extends AprendendotddcomspringApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private SalarioMinimoController salarioMinimoController;

    @Autowired
    private SalarioMinimoService salarioMinimoService;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(salarioMinimoController).build();
    }

    @Test
    public void testGETIndexSalarioMinimoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/salarios")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGETSaveSalarioMinimoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/salarios/novo"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("salarioMinimo"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPOSTSaveSalarioMinimoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/salarios")
                .param("estado", "BR")
                .param("salario", "800")
                .param("dataInicio", "01/01/2016")
                .param("dataFim", "02/02/2016")
        ).andExpect(MockMvcResultMatchers.redirectedUrl("/salarios/novo"));
    }

    @Test
    public void testPUTSalarioMinimoController() throws Exception {
        SalarioMinimo salarioMinimo = (SalarioMinimo) salarioMinimoService.save(new SalarioMinimo("AL", "800", new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2016"), new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2016"), "decreto test"));
        this.mockMvc.perform(MockMvcRequestBuilders.put("/salarios/" + salarioMinimo.getId() + "/editar")).andExpect(MockMvcResultMatchers.redirectedUrl("/salarios"));
    }

}