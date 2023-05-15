package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.request.CajaDTORequest;
import com.casa.san.roque.ferreteria.model.request.CajaDetalleDTORequest;
import com.casa.san.roque.ferreteria.model.response.CajaDTOResponse;
import com.casa.san.roque.ferreteria.model.response.CajaDetalleDTOResponse;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface CajaService {
    
    public CajaDTOResponse aperturaCaja(CajaDTORequest cajaDTORequest);
    
    public CajaDetalleDTOResponse registrarTransaccion(CajaDetalleDTORequest cajaDetalleDTORequest);
    
    public List<CajaDetalleDTOResponse> obtenerFacturas(Long cajeroId);
    
    public void calcularSaldo();
    
    public void recalcularSaldo(double montoEntrante, double montoCobrado);
    
    public void arqueoCaja();
}
