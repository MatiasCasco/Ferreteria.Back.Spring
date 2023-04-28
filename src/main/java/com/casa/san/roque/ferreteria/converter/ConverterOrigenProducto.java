package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.CaracteristicasProductoRepository;
import com.casa.san.roque.ferreteria.dao.EmpresaRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicasProducto;
import com.casa.san.roque.ferreteria.model.entity.Empresa;
import com.casa.san.roque.ferreteria.model.entity.OrigenProducto;
import com.casa.san.roque.ferreteria.model.request.OrigenProductoDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterOrigenProducto {
    
    @Autowired
    private EmpresaRepository empresaRepository;
    
    @Autowired
    private CaracteristicasProductoRepository caracteristicasProductoRepository;

    public OrigenProducto convertToEntity(OrigenProductoDTORequest origenProductoDTO) {
        OrigenProducto origenProducto = new OrigenProducto();
        origenProducto.setPrecioVentaProveedor(origenProductoDTO.getPrecioVentaProveedor());
        
        Empresa empresa = empresaRepository.findById(origenProductoDTO.getEmpresaId())
            .orElseThrow(() -> new IllegalArgumentException("Empresa cannot be null"));
        origenProducto.setEmpresa(empresa);
        
        CaracteristicasProducto caracteristicasProducto = caracteristicasProductoRepository.findById(origenProductoDTO.getCaracteristicasProductoId())
            .orElseThrow(() -> new IllegalArgumentException("CaracteristicasProducto cannot be null"));
        origenProducto.setCaracteristicasProducto(caracteristicasProducto);
        
        return origenProducto;
    }
}
