package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.FacturaVentaRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import com.casa.san.roque.ferreteria.model.entity.DetalleVenta;
import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.request.DetalleVentaDTORequest;
import com.casa.san.roque.ferreteria.model.response.DetalleVentaDTOResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.casa.san.roque.ferreteria.dao.CaracteristicaProductoRepository;
import com.casa.san.roque.ferreteria.dao.UnidadMedidaBaseRepository;
import com.casa.san.roque.ferreteria.model.entity.UnidadMedidaBase;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterDetalleVenta {
    
    @Autowired
    private FacturaVentaRepository repositoryFactura;
    
    @Autowired
    private CaracteristicaProductoRepository repositoryCaracteristicasProducto;
    
    @Autowired
    private UnidadMedidaBaseRepository repositoryUnidadMedidaBase;
    
    public DetalleVentaDTOResponse toDetalleVentaDTO(DetalleVenta detalleVenta) {
        DetalleVentaDTOResponse detalleVentaDTO = new DetalleVentaDTOResponse();
        detalleVentaDTO.setDetalleVentaId(detalleVenta.getDetalleVentaId());
        detalleVentaDTO.setFacturaVentaId(detalleVenta.getFacturaVenta().getFacturaVentaId());
        detalleVentaDTO.setCaracteristicasProductoId(detalleVenta.getCaracteristicasProducto().getCaracteristicasProductoId());
        detalleVentaDTO.setDetalleVentaCantidad(detalleVenta.getDetalleVentaCantidad());
        detalleVentaDTO.setUnidadMedidaBaseId(detalleVenta.getUnidadMedidaBase().getUnidadMedidaBaseId());
        detalleVentaDTO.setDetalleVentaExentas(detalleVenta.getDetalleVentaExentas());
        detalleVentaDTO.setDetalleVentaIva5(detalleVenta.getDetalleVentaIva5());
        detalleVentaDTO.setDetalleVentaIva10(detalleVenta.getDetalleVentaIva10());
        detalleVentaDTO.setDetalleVentaSubTotal(detalleVenta.getDetalleVentaSubTotal());
        return detalleVentaDTO;
    }
    
    public DetalleVenta toDetalleVenta(DetalleVentaDTORequest detalleVentaDTO, Long facturaId) {
        FacturaVenta factura = repositoryFactura.findById(facturaId)
                .orElseThrow(() -> new IllegalArgumentException("Factura cannot be null"));
        CaracteristicaProducto caracteristicasProducto = repositoryCaracteristicasProducto.findById(detalleVentaDTO.getCaracteristicasProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Caracteristica Producto cannot be null"));
        UnidadMedidaBase unidadMedidaBase = repositoryUnidadMedidaBase.findById(detalleVentaDTO.getUnidadMedidaBaseId())
                .orElseThrow(() -> new IllegalArgumentException("Unidad de medida base cannot be null"));
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setFacturaVenta(factura);
        detalleVenta.setCaracteristicasProducto(caracteristicasProducto);
        detalleVenta.setDetalleVentaCantidad(detalleVentaDTO.getDetalleVentaCantidad());
        detalleVenta.setUnidadMedidaBase(unidadMedidaBase);
        detalleVenta.setDetalleVentaExentas(detalleVentaDTO.getDetalleVentaExentas());
        detalleVenta.setDetalleVentaIva5(detalleVentaDTO.getDetalleVentaIva5());
        detalleVenta.setDetalleVentaIva10(detalleVentaDTO.getDetalleVentaIva10());
        detalleVenta.setDetalleVentaSubTotal(detalleVentaDTO.getDetalleVentaSubTotal());
        return detalleVenta;
    }
    
}
