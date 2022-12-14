package com.example.barogo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.barogo.service.impl.OrderServiceImpl;

@SpringBootTest
class OrderTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void modifyOrder() {

		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		param.add("address", "제주 제주시 중앙로");

		mvc.perform(post("/v1/order/1"))
				.params(param))
				.andExpect(status().isOk());
	}

	@Test
	void findOrder() {

		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		param.add("createDateTime", "2022-12-12 13:00:00");

		mvc.perform(get("/v1/order"))
				.params(param))
				.andExpect(status().isOk());
	}

}
