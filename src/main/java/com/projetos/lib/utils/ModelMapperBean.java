package com.projetos.lib.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
public abstract class ModelMapperBean {
	
	protected ModelMapper mapper;
	
	//@Bean
	public ModelMapper mapper() {
		mapper = new ModelMapper();
		mapper
			.getConfiguration()
			.setFieldMatchingEnabled(true)
			.setAmbiguityIgnored(true)
			.setSkipNullEnabled(true)
			.setMatchingStrategy(MatchingStrategies.STRICT)
			.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
		return mapper;
		
	}

	public <E> E map(Object obj, Class<E> clazz) {
		return mapper.map(obj, clazz);
		
	}
	
	public <E> List<E> mapAll(Iterable<?> origin, Class<E> clazz) {
		List<E> target = new ArrayList<>();
		for (Object obj : origin) {
			target.add(mapper.map(obj, clazz));
		}
		return target;
	}
	
	public <E> Page<E> mapPage(Pageable pageable, Page<?> page, Class<E> clazz){
		return new PageImpl<>(
				mapAll(page.getContent(), clazz),
				pageable,
				page.getTotalElements()
			);
	}
}
