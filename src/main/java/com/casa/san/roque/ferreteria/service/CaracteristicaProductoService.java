package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import com.casa.san.roque.ferreteria.model.request.CaracteristicaProductoDTORequest;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface CaracteristicaProductoService {
           
    public List<CaracteristicaProducto> getAll();
    
    public CaracteristicaProducto findByCaracteristicaId(Long caracteristicaProductoId);
        
    public CaracteristicaProducto addCaracteristicaProducto(CaracteristicaProductoDTORequest caracteristicaProductoRequest);

    public List<CaracteristicaProducto> addCaracteristicaProductos(List<CaracteristicaProductoDTORequest> productos);

    public CaracteristicaProducto updateCaracteristicaProducto(CaracteristicaProductoDTORequest caracteristicaProductoRequest);

    public String deleteCaracteristicaProducto(Long caracteristicaProductoId);
}
