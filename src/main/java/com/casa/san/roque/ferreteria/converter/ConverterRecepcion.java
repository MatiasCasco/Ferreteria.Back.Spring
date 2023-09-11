package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import com.casa.san.roque.ferreteria.model.entity.Recepcion;
import com.casa.san.roque.ferreteria.model.request.RecepcionDTORequest;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterRecepcion {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public Recepcion toRecepcion(RecepcionDTORequest dTORequest) {
        
        CaracteristicaProducto caracteristicaProducto = entityManager.getReference(CaracteristicaProducto.class,
                dTORequest.getCaracteristicaProductoId());        
        Recepcion recepcion = new Recepcion();
        recepcion.setRecepcionId(dTORequest.getRecepcionId());
        recepcion.setCaracteristicaProducto(caracteristicaProducto);
        recepcion.setCantidadEsperada(dTORequest.getCantidadEsperada());
        recepcion.setCantidadRecibida(dTORequest.getCantidadRecibida());
        recepcion.setFechaRecepcion(dTORequest.getFechaRecepcion());
        return recepcion;
    }
    
}
