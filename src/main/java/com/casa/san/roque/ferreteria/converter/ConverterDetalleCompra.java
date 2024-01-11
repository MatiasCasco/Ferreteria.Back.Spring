package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.CaracteristicaProductoRepository;
import com.casa.san.roque.ferreteria.dao.FacturaCompraRepository;
import com.casa.san.roque.ferreteria.dao.UnidadMedidaBaseRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import com.casa.san.roque.ferreteria.model.entity.DetalleCompra;
import com.casa.san.roque.ferreteria.model.entity.FacturaCompra;
import com.casa.san.roque.ferreteria.model.request.DetalleCompraDTORequest;
import com.casa.san.roque.ferreteria.model.response.DetalleCompraDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterDetalleCompra {
    @Autowired
    private FacturaCompraRepository repositoryFactura;
    
    @Autowired
    private CaracteristicaProductoRepository repositoryCaracteristicasProducto;
    
    @Autowired
    private UnidadMedidaBaseRepository repositoryUnidadMedidaBase;
    
    public DetalleCompraDTOResponse toDetalleCompraDTO(DetalleCompra detalleCompra) {
        DetalleCompraDTOResponse detalleCompraDTO = new DetalleCompraDTOResponse();
        detalleCompraDTO.setDetalleCompraId(detalleCompra.getDetalleCompraId());
        detalleCompraDTO.setFacturaCompraId(detalleCompra.getFacturaCompra().getFacturaCompraId());
        detalleCompraDTO.setCaracteristicasProductoId(detalleCompra.getCaracteristicasProducto().getCaracteristicasProductoId());
        detalleCompraDTO.setDetalleCompraCantidad(detalleCompra.getDetalleCompraCantidad());
        detalleCompraDTO.setDetalleCompraPrecioUnit(detalleCompra.getDetalleCompraPrecioUnit());
//        detalleCompraDTO.setUnidadMedidaBaseId(detalleCompra.getUnidadMedidaBase().getUnidadMedidaBaseId());
//        detalleCompraDTO.setDetalleCompraExentas(detalleCompra.getDetalleCompraExentas());
//        detalleCompraDTO.setDetalleCompraIva5(detalleCompra.getDetalleCompraIva5());
//        detalleCompraDTO.setDetalleCompraIva10(detalleCompra.getDetalleCompraIva10());
        detalleCompraDTO.setDetalleCompraSubTotal(detalleCompra.getDetalleCompraSubTotal());
        return detalleCompraDTO;
    }
    
    public DetalleCompra toDetalleCompra(DetalleCompraDTORequest detalleCompraDTO, Long facturaId) {
        FacturaCompra factura = repositoryFactura.findById(facturaId)
                .orElseThrow(() -> new IllegalArgumentException("Factura cannot be null"));
        CaracteristicaProducto caracteristicasProducto = repositoryCaracteristicasProducto.findById(detalleCompraDTO.getCaracteristicasProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Caracteristica Producto cannot be null"));
//        UnidadMedidaBase unidadMedidaBase = repositoryUnidadMedidaBase.findById(detalleCompraDTO.getUnidadMedidaBaseId())
//                .orElseThrow(() -> new IllegalArgumentException("Unidad de medida base cannot be null"));
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setFacturaCompra(factura);
        detalleCompra.setCaracteristicasProducto(caracteristicasProducto);
        detalleCompra.setDetalleCompraCantidad(detalleCompraDTO.getDetalleCompraCantidad());
        detalleCompra.setDetalleCompraPrecioUnit(detalleCompraDTO.getDetalleCompraPrecioUnit());
//        detalleCompra.setUnidadMedidaBase(unidadMedidaBase);
//        detalleCompra.setDetalleCompraExentas(detalleCompraDTO.getDetalleCompraExentas());
//        detalleCompra.setDetalleCompraIva5(detalleCompraDTO.getDetalleCompraIva5());
//        detalleCompra.setDetalleCompraIva10(detalleCompraDTO.getDetalleCompraIva10());
        detalleCompra.setDetalleCompraSubTotal(detalleCompraDTO.getDetalleCompraSubTotal());
        return detalleCompra;
    }
}
