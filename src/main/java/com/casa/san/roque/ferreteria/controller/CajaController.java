package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.request.CajaDTORequest;
import com.casa.san.roque.ferreteria.model.response.CajaDTOResponse;
import com.casa.san.roque.ferreteria.service.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
}
