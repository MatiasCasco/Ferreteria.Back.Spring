package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.converter.ConverterFacturaVenta;
import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.request.FacturaVentaDTORequest;
import com.casa.san.roque.ferreteria.model.response.FacturaVentaDTOResponse;
import com.casa.san.roque.ferreteria.service.FacturaVentaService;
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
    public List<FacturaVentaDTOResponse> findFacturaByClienteByEmpleado(
            @PathVariable(name = "idCliente", required = true) Long idCliente,
            @PathVariable(name = "idEmpleado", required = true) Long idEmpleado
            ) throws Exception{
        return service.findLast(idEmpleado, idCliente);
    }
    
    @GetMapping("/FacturasByCliente/{idCliente}")
    public List<FacturaVentaDTOResponse> findFacturasByCliente(@PathVariable(name = "idCliente", required = true) Long idCliente) throws Exception{
        return service.getFacturasByCliente(idCliente);
    }
    
    @GetMapping("/FacturasPendientesByEmpleado/{idEmpleado}")
    public List<FacturaVentaDTOResponse> findFacturasPendientesByEmpleado(@PathVariable(name = "idEmpleado", required = true) Long idEmpleado) throws Exception{
        return service.FacturasPendientesBYEmpleado(idEmpleado);
    }
    
    @GetMapping("/FacturasByEmpleado/{idEmpleado}")
    public List<FacturaVentaDTOResponse> findFacturasByEmpleado(@PathVariable(name = "idEmpleado", required = true) Long idEmpleado) throws Exception{
        return service.findFacturasByEmpleado(idEmpleado);
    }
    
    @GetMapping("/all")
    public List<FacturaVentaDTOResponse> getALL() throws Exception{
        return service.getAll();
    }
}
