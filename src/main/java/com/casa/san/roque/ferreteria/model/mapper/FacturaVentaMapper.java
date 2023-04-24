package com.casa.san.roque.ferreteria.model.mapper;

import com.casa.san.roque.ferreteria.model.entity.DetalleVenta;
import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.response.DetalleVentaDTO;
import com.casa.san.roque.ferreteria.model.response.FacturaVentaDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class FacturaVentaMapper {
    
    @Autowired
    private DetalleVentaMapper detalleVentaMapper;
    
    public FacturaVentaDTO toFacturaVentaDTO(FacturaVenta facturaVenta) {
        List<DetalleVentaDTO> list = new ArrayList<DetalleVentaDTO>();
        FacturaVentaDTO facturaVentaDTO = new FacturaVentaDTO();
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
    
}
