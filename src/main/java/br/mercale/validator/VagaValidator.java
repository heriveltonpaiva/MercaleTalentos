package br.mercale.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.mercale.dominio.Cargo;
import br.mercale.dominio.Vaga;

public class VagaValidator implements Validator{
	@Override
	public boolean supports(Class<?> paramClass) {
		return Vaga.class.equals(paramClass);
	}
	@Override
	public void validate(Object obj, Errors erros) {
		 Vaga vaga = (Vaga) obj;
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(erros, "codigo", "vaga.codigo");

		 if(vaga.getUnidadeLotacao().getId() == 0)
			 erros.reject("vaga.unidadeLotacao");

		 if(vaga.getSalario() == 0)
			 erros.reject("vaga.salario");

		 if(vaga.getCargaHoraria() == 0)
			 erros.reject("vaga.cargaHoraria");
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(erros, "descricao", "vaga.descricao");
		
		 if(vaga.getRamo().getId() == 0)
			 erros.reject("vaga.ramo");
		 if(vaga.getSetor().getId() == 0)
			 erros.reject("vaga.setor");
		 if(vaga.getCargo().getId() == 0)
			 erros.reject("vaga.cargo");
		 if(vaga.getEtapa()!= null && vaga.getEtapa().getId() == 0)
			 erros.reject("vaga.etapa");
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(erros, "dataInicio", "vaga.dataInicio");
		 ValidationUtils.rejectIfEmptyOrWhitespace(erros, "dataFinal", "vaga.dataFinal");
		 
	}
}
