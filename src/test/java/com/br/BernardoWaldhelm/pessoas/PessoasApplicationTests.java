package com.br.BernardoWaldhelm.pessoas;

import br.com.pessoa.entity.Pessoa;
import br.com.pessoa.http.control.PessoaController;
import br.com.pessoa.repository.PessoaRepository;
import net.minidev.json.JSONUtil;
import org.h2.util.json.JsonConstructorUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(controllers = PessoaController.class)
@SpringBootTest
class PessoasApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@MockBean
	PessoaRepository pessoaRepository;
	@Test
	void buscarPessoa() throws Exception {
		var pessoa = new Pessoa();
		Mockito.when(pessoaRepository.findAll()).thenReturn(List.of(pessoa));
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/pessoa")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void pessoaSemNomeDate() throws Exception {
		Pessoa pessoaSemNomeData = new Pessoa();
		pessoaSemNomeData.setId((long) 1);

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/pessoa")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
