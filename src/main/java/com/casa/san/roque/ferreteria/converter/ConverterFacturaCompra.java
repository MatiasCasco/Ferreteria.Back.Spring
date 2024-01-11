package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.dao.EmpresaRepository;
import com.casa.san.roque.ferreteria.dao.PersonaRepository;
import com.casa.san.roque.ferreteria.model.entity.DetalleCompra;
import com.casa.san.roque.ferreteria.model.entity.Empresa;
import com.casa.san.roque.ferreteria.model.entity.FacturaCompra;
import com.casa.san.roque.ferreteria.model.entity.Persona;
import com.casa.san.roque.ferreteria.model.request.FacturaCompraDTORequest;
import com.casa.san.roque.ferreteria.model.response.DetalleCompraDTOResponse;
import com.casa.san.roque.ferreteria.model.response.FacturaCompraDTOResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterFacturaCompra {
   
    @Autowired
    private ConverterDetalleCompra detalleCompraMapper;
    
    @Autowired
    private PersonaRepository repositoryPersona;
    
    @Autowired
    private EmpresaRepository repositoryEmpresa;
    
    private static final String Estado = "INSERTANDO"; 
    
    public FacturaCompraDTOResponse toFacturaCompraDTO(FacturaCompra facturaCompra) {
        List<DetalleCompraDTOResponse> list = new ArrayList<DetalleCompraDTOResponse>();
        FacturaCompraDTOResponse facturaCompraDTO = new FacturaCompraDTOResponse();
        facturaCompraDTO.setFacturaCompraId(facturaCompra.getFacturaCompraId());
        facturaCompraDTO.setEmpresaId(facturaCompra.getEmpresa().getEmpresaId());
        facturaCompraDTO.setEmpleadoId(facturaCompra.getEmpleado().getPersonaId());
//        facturaCompraDTO.setCajaId(facturaCompra.getCaja().getCajaId());
        facturaCompraDTO.setFacturaCondicion(facturaCompra.getFacturaCondicion());
        facturaCompraDTO.setFacturaCompraEstado(facturaCompra.getFacturaCompraEstado());
        facturaCompraDTO.setFacturaCompraFecha(facturaCompra.getFacturaCompraFecha());
//        facturaCompraDTO.setFacturaCompraExentas(facturaCompra.getFacturaCompraTotalExentas());
//        facturaCompraDTO.setFacturaCompraIva5(facturaCompra.getFacturaCompraTotalIva5());
//        facturaCompraDTO.setFacturaCompraIva10(facturaCompra.getFacturaCompraTotalIva10());
        facturaCompraDTO.setFacturaCompraTotalIva(facturaCompra.getFacturaCompraTotalIva());
        facturaCompraDTO.setFacturaCompraNroRecibo(facturaCompra.getFacturaCompraNroRecibo());
        facturaCompraDTO.setFacturaCompraMontoTotal(facturaCompra.getFacturaCompraMontoTotal());
        for (DetalleCompra detalleCompra : facturaCompra.getDetalleCompra()) {
            list.add(detalleCompraMapper.toDetalleCompraDTO(detalleCompra));
        }
        facturaCompraDTO.setDetalleCompra(list);
        return facturaCompraDTO;
    }
    
    public FacturaCompra toFacturaCompra(FacturaCompraDTORequest facturaCompraDTO) {
        FacturaCompra facturaCompra = new FacturaCompra();
        Empresa empresa = new Empresa();
        Persona empleado = new Persona();
//        cliente = repositoryPersona.findById(facturaCompraDTO.getClienteId()).orElse(new Persona());
        empleado = repositoryPersona.findById(facturaCompraDTO.getEmpleadoId()).orElseThrow(() -> new IllegalArgumentException("Empleado cannot be null"));
        empresa = repositoryEmpresa.findById(facturaCompraDTO.getEmpresaId()).orElseThrow(() -> new IllegalArgumentException("Empresa cannot be null"));
//        caja = repositoryCaja.findById(facturaCompraDTO.getCajaId()).orElse(new Caja());
        facturaCompra.setFacturaCompraFecha(facturaCompraDTO.getFacturaCompraFecha());
        facturaCompra.setFacturaCompraNroRecibo(facturaCompraDTO.getFacturaCompraNroRecibo());
        facturaCompra.setFacturaCondicion(facturaCompraDTO.getFacturaCondicion());
        facturaCompra.setFacturaCompraEstado(Estado);
        facturaCompra.setEmpleado(empleado);
        facturaCompra.setEmpresa(empresa); 
//        facturaCompra.setCaja(caja);
//        facturaCompra.setFacturaCompraTotalExentas(facturaCompraDTO.getFacturaCompraExentas());
//        facturaCompra.setFacturaCompraTotalIva5(facturaCompraDTO.getFacturaCompraIva5());
//        facturaCompra.setFacturaCompraTotalIva10(facturaCompraDTO.getFacturaCompraIva10());
        facturaCompra.setFacturaCompraTotalIva(facturaCompraDTO.getFacturaCompraTotalIva());      
        facturaCompra.setFacturaCompraMontoTotal(facturaCompraDTO.getFacturaCompraMontoTotal());
        return facturaCompra;
    }   
}
