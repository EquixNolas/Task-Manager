package converters;

import entities.Estado;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EstadoConverter implements AttributeConverter<Estado, String> {

	@Override
	public String convertToDatabaseColumn(Estado estado) {
		if (estado == null) return null;
		
		//Mapeo al texto de BBDD
		switch (estado) {
			case Pendiente: return "Pendiente";
			case En_progreso: return "En Progreso";
			case Completada: return "Completada";
			default: throw new IllegalArgumentException("Estado desconocido: " + estado);
		}
	}

	@Override
	public Estado convertToEntityAttribute(String dbData) {
		if (dbData == null) return null;
		
		//Mapea el texto al enum
		switch (dbData) {
		case "Pendiente": return Estado.Pendiente;
		case "En Progreso": return Estado.En_progreso;
		case "Completada": return Estado.Completada;
		default: throw new IllegalArgumentException("Valor de Base de Datos desconocido: " + dbData); 
		}
	}

}
