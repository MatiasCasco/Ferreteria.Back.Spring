package com.casa.san.roque.ferreteria.controller;

import com.casa.san.roque.ferreteria.converter.ConverterFacturaCompra;
import com.casa.san.roque.ferreteria.model.entity.FacturaCompra;
import com.casa.san.roque.ferreteria.model.request.FacturaCompraDTORequest;
import com.casa.san.roque.ferreteria.model.response.FacturaCompraDTOResponse;
import com.casa.san.roque.ferreteria.service.FacturaCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matias Casco
 */
@RestController
@RequestMapping("/FacturaCompra")
public class FacturaCompraController {
    
    @Autowired
    private FacturaCompraService service;
    
    @Autowired
    private ConverterFacturaCompra converterFacturaCompra;
    
    @PostMapping("/addFacturaCompra")
    public FacturaCompraDTOResponse addFacturaCompra(@RequestBody FacturaCompraDTORequest facturaCompraDTO) throws Exception {
        FacturaCompra facturaCompra = new FacturaCompra();
        facturaCompra = service.addFacturaCompra(facturaCompraDTO);
        FacturaCompraDTOResponse facturaCompraDTOResponse = converterFacturaCompra.toFacturaCompraDTO(facturaCompra);
        return facturaCompraDTOResponse;
    }
    
    @PutMapping("/updateFacturaCompra")
    public FacturaCompra updateFacturaCompra(@RequestBody FacturaCompraDTORequest facturaCompraDTO) throws Exception {
        return service.updateFacturaCompra(facturaCompraDTO);
    }
        
    @GetMapping("/FacturaById/{idFactura}")
    public FacturaCompraDTOResponse findFacturaById(
            @PathVariable(name = "idFactura", required = true) Long idFactura
    ) throws Exception{
        return service.findFacturaById(idFactura);
    }
    
    @GetMapping("/all")
    public Page<FacturaCompraDTOResponse> getALL(
           @RequestParam(defaultValue = "0") int page,
           @RequestParam(defaultValue = "10") int size) throws Exception{
        return service.getAll(PageRequest.of(page, size));
    }
    
    @GetMapping("/FacturasPendientesByEmpresa/{idEmpresa}")
    public Page<FacturaCompraDTOResponse> findFacturasPendientesByEmpresa(
            @PathVariable(name = "idEmpresa", required = true) Long idEmpresa,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws Exception{
        return service.findPendingInvoicesByEmpresa(idEmpresa, PageRequest.of(page, size));
    }
    
    @GetMapping("/FacturasByEmpleado/{idEmpleado}")
    public Page<FacturaCompraDTOResponse> findFacturasByEmpleado(
            @PathVariable(name = "idEmpleado", required = true) Long idEmpleado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws Exception{
        return service.findInvoicesByEmpleado(idEmpleado, PageRequest.of(page, size));
    }
}
