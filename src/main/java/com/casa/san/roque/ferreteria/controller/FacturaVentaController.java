package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.converter.ConverterFacturaVenta;
import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.request.FacturaVentaDTORequest;
import com.casa.san.roque.ferreteria.model.response.FacturaVentaDTOResponse;
import com.casa.san.roque.ferreteria.service.FacturaVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matias Casco
 */
@RestController
@RequestMapping("/FacturaVenta")
public class FacturaVentaController {
    
    @Autowired
    private FacturaVentaService service;
    
    @Autowired
    private ConverterFacturaVenta converterFacturaVenta;
    
    @PostMapping("/addFacturaVenta")
    public FacturaVenta addFacturaVenta(@RequestBody FacturaVentaDTORequest facturaVentaDTO) throws Exception {
        FacturaVenta facturaVenta = new FacturaVenta();
        facturaVenta = converterFacturaVenta.toFacturaVenta(facturaVentaDTO);
        return service.addFacturaVenta(facturaVentaDTO); 
    }
    
    @GetMapping("/FacturaById/{idFactura}")
    public FacturaVentaDTOResponse findFacturaById(
            @PathVariable(name = "idFactura", required = true) Long idFactura
    ) throws Exception{
        return service.findFacturaById(idFactura);
    }
    
    @GetMapping("/FacturasByClienteAndEmpleado/{idCliente}/{idEmpleado}")
    public Page<FacturaVentaDTOResponse> findFacturaByClienteByEmpleado(
            @PathVariable(name = "idCliente", required = true) Long idCliente,
            @PathVariable(name = "idEmpleado", required = true) Long idEmpleado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
            ) throws Exception{
        return service.findLast(idEmpleado, idCliente, PageRequest.of(page, size));
    }
    
    @GetMapping("/FacturasByCliente/{idCliente}")
    public Page<FacturaVentaDTOResponse> findFacturasByCliente(
            @PathVariable(name = "idCliente", required = true) Long idCliente,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws Exception{
        return service.getFacturasByCliente(idCliente, PageRequest.of(page, size));
    }
    
    @GetMapping("/FacturasPendientesByEmpleado/{idEmpleado}")
    public Page<FacturaVentaDTOResponse> findFacturasPendientesByEmpleado(
            @PathVariable(name = "idEmpleado", required = true) Long idEmpleado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws Exception{
        return service.FacturasPendientesBYEmpleado(idEmpleado, PageRequest.of(page, size));
    }
    
    @GetMapping("/FacturasByEmpleado/{idEmpleado}")
    public Page<FacturaVentaDTOResponse> findFacturasByEmpleado(
            @PathVariable(name = "idEmpleado", required = true) Long idEmpleado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws Exception{
        return service.findFacturasByEmpleado(idEmpleado, PageRequest.of(page, size));
    }
    
    @GetMapping("/all")
    public Page<FacturaVentaDTOResponse> getALL(
           @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws Exception{
        return service.getAll(PageRequest.of(page, size));
    }
}
