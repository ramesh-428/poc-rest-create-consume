package com.ramesh.demoPOC1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramesh.demoPOC1.data.model.ProductPrice;
import com.ramesh.demoPOC1.data.pojo.Price;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class WebServicesTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testProductId1() throws Exception {
    this.mockMvc.perform(get("/api/products/13860428")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(13860428))
        .andExpect(jsonPath("$.name").value("The Big Lebowski (Blu-ray)"))
        .andExpect(jsonPath("$.current_price.value").value("9.99"))
        .andExpect(jsonPath("$.current_price.currency_code").value("USD"));

  }

  @Test
  public void testProductId2() throws Exception {
    this.mockMvc.perform(get("/api/products/13264003")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(13264003))
        .andExpect(jsonPath("$.name").value("Jif Natural Creamy Peanut Butter - 40oz"))
        .andExpect(jsonPath("$.current_price.value").value("6.99"))
        .andExpect(jsonPath("$.current_price.currency_code").value("USD"));

  }

  @Test
  public void testProductId3() throws Exception {
    this.mockMvc.perform(get("/api/products/12954218")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(12954218))
        .andExpect(jsonPath("$.name").value("Kraft Original Mac and Cheese Dinner"))
        .andExpect(jsonPath("$.current_price.value").value("1.29"))
        .andExpect(jsonPath("$.current_price.currency_code").value("USD"));

  }

  @Test
  public void testProductUpdateId1() throws Exception {
    ProductPrice productPrice = new ProductPrice(13860428, new Price(9.98, "USD"));
    ObjectMapper mapper = new ObjectMapper();
    mockMvc.perform(post("/api/products/" + productPrice.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(productPrice)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(productPrice.getId()))
        .andExpect(jsonPath("$.current_price.value").value(productPrice.getCurrent_price().getValue()))
        .andExpect(jsonPath("$.current_price.currency_code").value(productPrice.getCurrent_price().getCurrency_code()));
  }

  @Test
  public void testProductUpdateIdNotFound() throws Exception {
    ProductPrice productPrice = new ProductPrice(138604289, new Price(9.98, "USD"));
    ObjectMapper mapper = new ObjectMapper();
    mockMvc.perform(post("/api/products/" + productPrice.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(productPrice)))
        .andExpect(status().is5xxServerError())
        .andExpect(jsonPath("$.status").value("ERROR"))
        .andExpect(jsonPath("$.code").value("PRODUCT_NOT_FOUND"));
  }

  @Test
  public void testProductUpdateIdBadData1() throws Exception {
    ProductPrice productPrice = new ProductPrice(138604289, new Price(9.98, "USD"));
    ObjectMapper mapper = new ObjectMapper();
    mockMvc.perform(post("/api/products/XXXXX")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(productPrice)))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void testProductUpdateIdBadData2() throws Exception {
    ProductPrice productPrice = new ProductPrice(138604289, new Price(9.98, "USD"));
    ObjectMapper mapper = new ObjectMapper();
    mockMvc.perform(post("/api/products/null")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(productPrice)))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void testProductIdNotFound() throws Exception {
    this.mockMvc.perform(get("/api/products/129542189")).andDo(print()).andExpect(status().is5xxServerError())
        .andExpect(jsonPath("$.status").value("ERROR"))
        .andExpect(jsonPath("$.code").value("PRODUCT_NOT_FOUND"));
  }

  @Test
  public void testProductBadData1() throws Exception {
    this.mockMvc.perform(get("/api/products/XXXXX")).andDo(print()).andExpect(status().isBadRequest());
  }

  @Test
  public void testProductBadData2() throws Exception {
    this.mockMvc.perform(get("/api/products/null")).andDo(print()).andExpect(status().isBadRequest());
  }
}