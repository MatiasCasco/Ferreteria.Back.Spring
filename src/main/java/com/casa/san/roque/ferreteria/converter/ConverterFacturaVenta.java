package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.PersonaRepository;
import com.casa.san.roque.ferreteria.model.entity.DetalleVenta;
import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.entity.Persona;
import com.casa.san.roque.ferreteria.model.request.FacturaVentaDTORequest;
import com.casa.san.roque.ferreteria.model.response.DetalleVentaDTOResponse;
import com.casa.san.roque.ferreteria.model.response.FacturaVentaDTOResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterFacturaVenta {
    
    @Autowired
    private ConverterDetalleVenta detalleVentaMapper;
    
    @Autowired
    private PersonaRepository repositoryPersona;
    
    private static final String Estado = "INSERTANDO"; 
    
    public FacturaVentaDTOResponse toFacturaVentaDTO(FacturaVenta facturaVenta) {
        List<DetalleVentaDTOResponse> list = new ArrayList<DetalleVentaDTOResponse>();
        FacturaVentaDTOResponse facturaVentaDTO = new FacturaVentaDTOResponse();
        facturaVentaDTO.setFacturaVentaId(facturaVenta.getFacturaVentaId());
        facturaVentaDTO.setClienteId(facturaVenta.getPersona().getPersonaId());
        facturaVentaDTO.setEmpleadoId(facturaVenta.getEmpleado().getPersonaId());
        facturaVentaDTO.setFacturaCondicion(facturaVenta.getFacturaCondicion());
        facturaVentaDTO.setFacturaVentaEstado(facturaVenta.getFacturaVentaEstado());
        facturaVentaDTO.setFacturaVentaFecha(facturaVenta.getFacturaVentaFecha());
        facturaVentaDTO.setFacturaVentaIva(facturaVenta.getFacturaVentaIva());
        facturaVentaDTO.setFacturaVentaNroRecibo(facturaVenta.getFacturaVentaNroRecibo());
        facturaVentaDTO.setFacturaVentaMontoTotal(facturaVenta.getFacturaVentaMontoTotal());
        for (DetalleVenta detalleVenta : facturaVenta.getDetalleVenta()) {
            list.add(detalleVentaMapper.toDetalleVentaDTO(detalleVenta));
        }
        facturaVentaDTO.setDetalleVenta(list);
        return facturaVentaDTO;
    }
    
    public FacturaVenta toFacturaVenta(FacturaVentaDTORequest facturaVentaDTO) {
        FacturaVenta facturaVenta = new FacturaVenta();
        Persona cliente = new Persona();
        Persona empleado = new Persona();
        cliente = repositoryPersona.findById(facturaVentaDTO.getClienteId()).orElse(new Persona());
        empleado = repositoryPersona.findById(facturaVentaDTO.getEmpleadoId()).orElse(new Persona());
        facturaVenta.setFacturaVentaFecha(facturaVentaDTO.getFacturaVentaFecha());
        facturaVenta.setFacturaVentaNroRecibo(facturaVentaDTO.getFacturaVentaNroRecibo());
        facturaVenta.setFacturaCondicion(facturaVentaDTO.getFacturaCondicion());
        facturaVenta.setFacturaVentaEstado(Estado);
        facturaVenta.setEmpleado(empleado);
        facturaVenta.setPersona(cliente);
        facturaVenta.setFacturaVentaIva(facturaVentaDTO.getFacturaVentaIva());
        facturaVenta.setFacturaVentaMontoTotal(facturaVentaDTO.getFacturaVentaMontoTotal());
        return facturaVenta;
    }   
}
