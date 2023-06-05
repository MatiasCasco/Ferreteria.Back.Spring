package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.request.CajaDTORequest;
import com.casa.san.roque.ferreteria.model.request.CajaDetalleDTORequest;
import com.casa.san.roque.ferreteria.model.response.CajaDTOResponse;
import com.casa.san.roque.ferreteria.model.response.CajaDetalleDTOResponse;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface CajaService {
    
    public CajaDTOResponse aperturaCaja(CajaDTORequest cajaDTORequest);
    
    public CajaDetalleDTOResponse registrarTransaccion(CajaDetalleDTORequest cajaDetalleDTORequest);
    
    public Page<CajaDetalleDTOResponse> obtenerFacturas(Long cajeroId, Pageable pageable);
    
    public CajaDetalleDTOResponse getDetalleCajaById(Long detalleId);
    
}
