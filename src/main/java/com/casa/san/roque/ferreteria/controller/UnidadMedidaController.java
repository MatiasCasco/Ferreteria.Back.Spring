package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.model.entity.Conversion;
import com.casa.san.roque.ferreteria.model.entity.UnidadMedidaBase;
import com.casa.san.roque.ferreteria.service.UnidadMedidaBaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<UnidadMedidaBase> findAllMetricasBase(){
        return service.getMedidasBase();
    }
    
    @GetMapping("/conversionById/{conversionId}")
    public Conversion findByIdConversion(
            @PathVariable(name = "conversionId", required = true) Long conversionId) {
        return service.getConversion(conversionId);
    }
    
    @GetMapping("/conversionesByProductoId/{productoId}")
    public List<Conversion> findAllMetricasByProducto(
            @PathVariable(name = "productoId", required = true) Long productoId){
        return service.getMedidasByProductoId(productoId);
    }
}
