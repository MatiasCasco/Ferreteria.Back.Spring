package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.request.CajaDTORequest;
import com.casa.san.roque.ferreteria.model.request.CajaDetalleDTORequest;
import com.casa.san.roque.ferreteria.model.response.CajaDTOResponse;
import com.casa.san.roque.ferreteria.model.response.CajaDetalleDTOResponse;
import com.casa.san.roque.ferreteria.service.CajaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matias Casco
 */
@RestController
@RequestMapping("/CajaAPI")
public class CajaController {
    
    @Autowired
    private CajaService service;
    
    @PostMapping("/addCaja")
    public CajaDTOResponse addCaja(@RequestBody CajaDTORequest cajaDTORequest) {
        return service.aperturaCaja(cajaDTORequest);
    }
    
    @PostMapping("/addCajaDetalle")
    public CajaDetalleDTOResponse addCajaDetalle(@RequestBody CajaDetalleDTORequest cajaDetalleDTORequest) {
        return service.registrarTransaccion(cajaDetalleDTORequest);
    }
    
    @GetMapping("/facturas/{idEmpleado}")
    public List<CajaDetalleDTOResponse> getFacturas(@PathVariable(name = "idEmpleado", required = true) Long idEmpleado) {
        return service.obtenerFacturas(idEmpleado);
    }
    
    @GetMapping("/detalleCaja/{idDetalle}")
    public CajaDetalleDTOResponse getDetalleCajaById(@PathVariable(name = "idDetalle", required = true) Long idDetalle) {
        return service.getDetalleCajaById(idDetalle);
    }
}
