package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Conversion;
import com.casa.san.roque.ferreteria.model.entity.UnidadMedidaBase;
import com.casa.san.roque.ferreteria.service.UnidadMedidaBaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matias Casco
 */
@RestController
@RequestMapping("/UnidadMedidaAPI")
public class UnidadMedidaController {
    
    @Autowired
    private UnidadMedidaBaseService service;
    
    @GetMapping("/metricaById/{metricaId}")
    public UnidadMedidaBase findByIdUnidadMedida(
            @PathVariable(name = "metricaId", required = true) Long metricaId) {
        return service.getUnidadMedidaBase(metricaId);
    }
    
    @GetMapping("/metricas")
    public Page<UnidadMedidaBase> findAllMetricasBase(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size){
        return service.getMedidasBase(PageRequest.of(page, size));
    }
    
    @GetMapping("/conversionById/{conversionId}")
    public Conversion findByIdConversion(
            @PathVariable(name = "conversionId", required = true) Long conversionId) {
        return service.getConversion(conversionId);
    }
    
    @GetMapping("/conversionesByProductoId/{productoId}")
    public Page<Conversion> findAllMetricasByProducto(
            @PathVariable(name = "productoId", required = true) Long productoId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return service.getMedidasByProductoId(productoId, PageRequest.of(page, size));
    }
}