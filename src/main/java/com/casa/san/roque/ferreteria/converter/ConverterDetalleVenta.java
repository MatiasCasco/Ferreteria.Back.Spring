package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.CaracteristicasProductoRepository;
import com.casa.san.roque.ferreteria.dao.FacturaVentaRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicasProducto;
import com.casa.san.roque.ferreteria.model.entity.DetalleVenta;
import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.request.DetalleVentaDTORequest;
import com.casa.san.roque.ferreteria.model.response.DetalleVentaDTOResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterDetalleVenta {
    
    @Autowired
    private FacturaVentaRepository repositoryFactura;
    
    @Autowired
    private CaracteristicasProductoRepository repositoryCaracteristicasProducto;
    
    public DetalleVentaDTOResponse toDetalleVentaDTO(DetalleVenta detalleVenta) {
        DetalleVentaDTOResponse detalleVentaDTO = new DetalleVentaDTOResponse();
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
    
    public DetalleVenta toDetalleVenta(DetalleVentaDTORequest detalleVentaDTO, Long facturaId) {
        FacturaVenta factura = repositoryFactura.findById(facturaId)
                .orElseThrow(() -> new IllegalArgumentException("Factura cannot be null"));
        CaracteristicasProducto caracteristicasProducto = repositoryCaracteristicasProducto.findById(detalleVentaDTO.getCaracteristicasProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Caracteristica Producto cannot be null"));
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setFacturaVenta(factura);
        detalleVenta.setCaracteristicasProducto(caracteristicasProducto);
        detalleVenta.setDetalleVentaCantidad(detalleVentaDTO.getDetalleVentaCantidad());
        detalleVenta.setDetalleVentaIva(detalleVentaDTO.getDetalleVentaIva());
        detalleVenta.setDetalleVentaUnidadStock(detalleVentaDTO.getDetalleVentaUnidadStock());
        detalleVenta.setDetalleVentaSubTotal(detalleVentaDTO.getDetalleVentaSubTotal());
        detalleVenta.setDetalleVentaSubTotalIva(detalleVentaDTO.getDetalleVentaSubTotalIva());
        return detalleVenta;
    }
    
}
