package com.algaworks.algalog.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.dto.EntregaDTO;
import com.algaworks.algalog.domain.model.input.EntregaInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaMapper {

	private ModelMapper modelMapper;

	public EntregaDTO toDTO(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDTO.class);
	}

	public List<EntregaDTO> toCollectionDTO(List<Entrega> entregas) {
		return entregas.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}	

public Entrega toEntity(EntregaInput entregaInput) {
	return modelMapper.map(entregaInput, Entrega.class);
}

}
