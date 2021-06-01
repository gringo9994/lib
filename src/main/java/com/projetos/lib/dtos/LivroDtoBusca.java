package com.projetos.lib.dtos;




import com.projetos.lib.models.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class LivroDtoBusca {
	
	
	


	private Long id;
	private String titulo;
	private String autor;
	private String descricao;
	
	
	private CategoriaDto categorias;
	

}
