package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.PersonaRepository;
import com.casa.san.roque.ferreteria.model.entity.Caja;
import com.casa.san.roque.ferreteria.model.entity.Persona;
import com.casa.san.roque.ferreteria.model.request.CajaDTORequest;
import com.casa.san.roque.ferreteria.model.response.CajaDTOResponse;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterCaja {
    
    @Autowired
    private PersonaRepository repository;
    
    private static final String APERTURA = "APERTURA";
    
    public Caja toCaja(CajaDTORequest cajaDTORequest) {
        Persona empleado = new Persona();
        empleado = repository.findById(cajaDTORequest.getCajeroId()).orElseThrow(() -> new IllegalArgumentException("Empleado cannot be null"));
        Caja caja = new Caja();
        caja.setEmpleado(empleado);
        caja.setCajaFechaApertura(LocalDateTime.now());
        caja.setCajaMontoApertura(cajaDTORequest.getCajaMontoApertura());
        caja.setCajaEstado(APERTURA);
        return caja;
    }
    
    public CajaDTOResponse toCajaDTOResponse(Caja caja) {
        CajaDTOResponse cajaDTOResponse = new CajaDTOResponse();
        cajaDTOResponse.setCajaId(caja.getCajaId());
        cajaDTOResponse.setCajeroId(caja.getEmpleado().getPersonaId());
        cajaDTOResponse.setCajaFechaApertura(caja.getCajaFechaApertura());
        cajaDTOResponse.setCajaFechaCierre(caja.getCajaFechaCierre());
        cajaDTOResponse.setCajaMontoApertura(caja.getCajaMontoApertura());
        cajaDTOResponse.setCajaEstado(caja.getCajaEstado());
        return cajaDTOResponse;
    }
}
