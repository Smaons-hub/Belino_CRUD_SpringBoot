package com.example.csit321g2.belino_crud;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import com.example.csit321g2.belino_crud.entity.ItemEntity;
import com.example.csit321g2.belino_crud.repository.ItemRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class BelinoCrudApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void deleteMissingItemReturnsNotFound() throws Exception {
		mockMvc.perform(delete("/item/api/deleteItem/999"))
			.andExpect(status().isNotFound());
	}

	@Test
	void itemPricePersistsAsExactDecimal() {
		ItemEntity saved = itemRepository.save(new ItemEntity(0, "Rice", "kg", new BigDecimal("12.34")));

		assertEquals(new BigDecimal("12.34"), itemRepository.findById(saved.getItemId()).orElseThrow().getPrice());
	}
}
