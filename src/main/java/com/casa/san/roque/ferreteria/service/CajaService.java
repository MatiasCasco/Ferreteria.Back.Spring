package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.request.CajaDTORequest;
import com.casa.san.roque.ferreteria.model.response.CajaDTOResponse;

/**
 *
 * @author Matias Casco
 */
public interface CajaService {
    
    public CajaDTOResponse aperturaCaja(CajaDTORequest cajaDTORequest);
    
    public void agregarFactura(Long cajeroId, Long facturaId);
    
    public void obtenerFacturas(Long cajeroId);
    
    public void calcularSaldo();
    
    public void recalcularSaldo(double montoEntrante, double montoCobrado);
    
    public void arqueoCaja();
}
