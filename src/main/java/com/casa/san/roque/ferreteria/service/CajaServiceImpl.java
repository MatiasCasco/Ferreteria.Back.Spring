package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.converter.ConverterCaja;
import com.casa.san.roque.ferreteria.converter.ConverterDetalleCaja;
import com.casa.san.roque.ferreteria.dao.CajaRepository;
import com.casa.san.roque.ferreteria.dao.DetalleCajaRepository;
import com.casa.san.roque.ferreteria.model.entity.Caja;
import com.casa.san.roque.ferreteria.model.entity.DetalleCaja;
import com.casa.san.roque.ferreteria.model.request.CajaDTORequest;
import com.casa.san.roque.ferreteria.model.request.CajaDetalleDTORequest;
import com.casa.san.roque.ferreteria.model.response.CajaDTOResponse;
import com.casa.san.roque.ferreteria.model.response.CajaDetalleDTOResponse;
import java.util.ArrayList;
import java.util.List;
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
    private DetalleCajaRepository repositoryDetalleCaja;
    
    @Autowired
    private ConverterCaja converterCaja;
    
    @Autowired
    private ConverterDetalleCaja converterDetalleCaja;
    
    private static final String ESTADO = "Apertura";
    
    @Override
    public CajaDTOResponse aperturaCaja(CajaDTORequest cajaDTORequest) {
        Caja caja = converterCaja.toCaja(cajaDTORequest);
        repository.save(caja);
        CajaDTOResponse cajaDTOResponse = converterCaja.toCajaDTOResponse(caja);
        return cajaDTOResponse;
    }

    @Override
    public CajaDetalleDTOResponse registrarTransaccion(CajaDetalleDTORequest cajaDetalleDTORequest) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DetalleCaja detalleCaja = converterDetalleCaja.toDetalleCaja(cajaDetalleDTORequest);
        repositoryDetalleCaja.save(detalleCaja);
        CajaDetalleDTOResponse cajaDetalleDTOResponse = converterDetalleCaja.toCajaDetalleDTOResponse(detalleCaja);
        return cajaDetalleDTOResponse;
    }
    
    @Override
    public List<CajaDetalleDTOResponse> obtenerFacturas(Long cajeroId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<DetalleCaja> list = new ArrayList<>();
        List<CajaDetalleDTOResponse> listResponse = new ArrayList<>();
        list = repositoryDetalleCaja.findByCaja_CajaEstadoAndCaja_Empleado_PersonaId(ESTADO, cajeroId);
        for (DetalleCaja detalleCaja : list) {
            listResponse.add(converterDetalleCaja.toCajaDetalleDTOResponse(detalleCaja));
        }
        return listResponse;
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
