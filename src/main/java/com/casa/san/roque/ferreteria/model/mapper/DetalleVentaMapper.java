package com.casa.san.roque.ferreteria.model.mapper;

import com.casa.san.roque.ferreteria.model.entity.DetalleVenta;
import com.casa.san.roque.ferreteria.model.response.DetalleVentaDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class DetalleVentaMapper {
    
    public DetalleVentaDTO toDetalleVentaDTO(DetalleVenta detalleVenta) {
        DetalleVentaDTO detalleVentaDTO = new DetalleVentaDTO();
        detalleVentaDTO.setDetalleVentaId(detalleVenta.getDetalleVentaId());
        detalleVentaDTO.setFacturaVentaId(detalleVenta.getFacturaVenta().getFacturaVentaId());
        detalleVentaDTO.setCaracteristicasProductoId(detalleVenta.getCaracteristicasProducto().getCaracteristicasProductoId());
        detalleVentaDTO.setDetalleVentaCantidad(detalleVenta.getDetalleVentaCantidad());
        detalleVentaDTO.setDetalleVentaUnidadStock(detalleVenta.getDetalleVentaUnidadStock());
        detalleVentaDTO.setDetalleVentaIva(detalleVenta.getDetalleVentaId());
        detalleVentaDTO.setDetalleVentaSubTotalIva(detalleVenta.getDetalleVentaSubTotalIva());
        detalleVentaDTO.setDetalleVentaSubTotal(detalleVenta.getDetalleVentaSubTotal());
        return detalleVentaDTO;
    }
    
}
