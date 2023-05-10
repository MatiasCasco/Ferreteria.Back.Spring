package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.converter.ConverterCaja;
import com.casa.san.roque.ferreteria.dao.CajaRepository;
import com.casa.san.roque.ferreteria.model.entity.Caja;
import com.casa.san.roque.ferreteria.model.request.CajaDTORequest;
import com.casa.san.roque.ferreteria.model.response.CajaDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matias Casco
 */
@Service
public class CajaServiceImpl implements CajaService {
    
    @Autowired
    private CajaRepository repository;
    
    @Autowired
    private ConverterCaja converterCaja;
    
    @Override
    public CajaDTOResponse aperturaCaja(CajaDTORequest cajaDTORequest) {
        Caja caja = converterCaja.toCaja(cajaDTORequest);
        repository.save(caja);
        CajaDTOResponse cajaDTOResponse = converterCaja.toCajaDTOResponse(caja);
        return cajaDTOResponse;
    }

    @Override
    public void agregarFactura(Long cajeroId, Long facturaId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void obtenerFacturas(Long cajeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calcularSaldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recalcularSaldo(double montoEntrante, double montoCobrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void arqueoCaja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
