package com.projetos.lib.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {
	
	
	private Long id;
	private String nome;
	private String descricao;

}
