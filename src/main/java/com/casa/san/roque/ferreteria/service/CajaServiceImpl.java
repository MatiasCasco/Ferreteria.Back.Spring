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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    @Transactional
    @Override
    public CajaDTOResponse aperturaCaja(CajaDTORequest cajaDTORequest) {
        Caja caja = converterCaja.toCaja(cajaDTORequest);
        repository.save(caja);
        CajaDTOResponse cajaDTOResponse = converterCaja.toCajaDTOResponse(caja);
        return cajaDTOResponse;
    }

    @Transactional
    @Override
    public CajaDetalleDTOResponse registrarTransaccion(CajaDetalleDTORequest cajaDetalleDTORequest) {
        DetalleCaja detalleCaja = converterDetalleCaja.toDetalleCaja(cajaDetalleDTORequest);
        repositoryDetalleCaja.save(detalleCaja);
        CajaDetalleDTOResponse cajaDetalleDTOResponse = converterDetalleCaja.toCajaDetalleDTOResponse(detalleCaja);
        return cajaDetalleDTOResponse;
    }
    
    @Override
    public Page<CajaDetalleDTOResponse> obtenerFacturas(Long cajeroId, Pageable pageable) {
        Page<DetalleCaja> page = repositoryDetalleCaja.findByCaja_CajaEstadoAndCaja_Empleado_PersonaId(ESTADO, cajeroId, pageable);
        List<DetalleCaja> list = page.getContent();
        List<CajaDetalleDTOResponse> listResponse = new ArrayList<>();
        for (DetalleCaja detalleCaja : list) {
            listResponse.add(converterDetalleCaja.toCajaDetalleDTOResponse(detalleCaja));
        }
        Page<CajaDetalleDTOResponse> responsePage = new PageImpl<>(listResponse, pageable, page.getTotalElements());
        return responsePage;
    }

    @Override
    public CajaDetalleDTOResponse getDetalleCajaById(Long detalleId) {
        CajaDetalleDTOResponse cajaDetalleDTOResponse = new CajaDetalleDTOResponse();
        DetalleCaja detalleCaja = new DetalleCaja();
        detalleCaja = repositoryDetalleCaja.findById(detalleId).orElse(new DetalleCaja());
        System.out.println(detalleCaja);
        cajaDetalleDTOResponse = converterDetalleCaja.toCajaDetalleDTOResponse(detalleCaja);
        return cajaDetalleDTOResponse;
    }
   
}
