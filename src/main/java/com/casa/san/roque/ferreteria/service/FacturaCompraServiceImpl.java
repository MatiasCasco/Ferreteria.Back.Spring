package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.converter.ConverterDetalleCompra;
import com.casa.san.roque.ferreteria.converter.ConverterFacturaCompra;
import com.casa.san.roque.ferreteria.dao.CaracteristicaProductoRepository;
import com.casa.san.roque.ferreteria.dao.DetalleCompraRepository;
import com.casa.san.roque.ferreteria.dao.EmpresaRepository;
import com.casa.san.roque.ferreteria.dao.FacturaCompraRepository;
import com.casa.san.roque.ferreteria.dao.PersonaRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import com.casa.san.roque.ferreteria.model.entity.DetalleCompra;
import com.casa.san.roque.ferreteria.model.entity.Empresa;
import com.casa.san.roque.ferreteria.model.entity.FacturaCompra;
import com.casa.san.roque.ferreteria.model.entity.Persona;
import com.casa.san.roque.ferreteria.model.request.DetalleCompraDTORequest;
import com.casa.san.roque.ferreteria.model.request.FacturaCompraDTORequest;
import com.casa.san.roque.ferreteria.model.response.FacturaCompraDTOResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class FacturaCompraServiceImpl implements FacturaCompraService {

    @Autowired
    private FacturaCompraRepository repository;
    
    @Autowired
    private DetalleCompraRepository repositoryDetalleCompra;
    
    @Autowired
    private PersonaRepository repositoryPersona;
    
    @Autowired
    private EmpresaRepository repositoryEmpresa;
    
    @Autowired
    private CaracteristicaProductoRepository repositoryCaracteristicaProducto;
    
    @Autowired
    private ConverterFacturaCompra converterFacturaCompra;
    
    @Autowired
    private ConverterDetalleCompra converterDetalleCompra;
    
    private static final String estadoFactura = "INSERTANDO";
    
    @Override
    public Page<FacturaCompraDTOResponse> getAll(Pageable pageable) throws Exception {
        List<FacturaCompraDTOResponse> listFacturas = new ArrayList<FacturaCompraDTOResponse>();
        Page<FacturaCompra> page = repository.findAll(pageable);
        List<FacturaCompra> list = page.getContent();
        for (FacturaCompra factura : list) {
            listFacturas.add(converterFacturaCompra.toFacturaCompraDTO(factura));
        }
        Page<FacturaCompraDTOResponse> responsePage = new PageImpl<>(listFacturas, pageable, page.getTotalElements());
        return responsePage;
    }
    
    @Transactional
    @Override
    public FacturaCompra addFacturaCompra(FacturaCompraDTORequest facturaCompraDTO) throws Exception {
        List<DetalleCompra> detalle = new ArrayList<DetalleCompra>(); 
        FacturaCompra facturaCompra = new FacturaCompra();
        facturaCompra = converterFacturaCompra.toFacturaCompra(facturaCompraDTO);
        repository.save(facturaCompra);

        facturaCompra = repository.findLastInsertedByEmpleadoId(facturaCompraDTO.getEmpleadoId());
        for (DetalleCompraDTORequest detalleCompraDTORequest : facturaCompraDTO.getDetalleCompra()) {
            detalle.add(converterDetalleCompra.toDetalleCompra(detalleCompraDTORequest, facturaCompra.getFacturaCompraId()));
        }
        repositoryDetalleCompra.saveAll(detalle);
        facturaCompra.setFacturaCompraEstado(estadoFactura);
        facturaCompra.setDetalleCompra(detalle);
        repository.save(facturaCompra);
        return facturaCompra;
    }

    @Override
    public void removeFacturaCompra(Long idFacturaCompra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FacturaCompra updateFacturaCompra(FacturaCompraDTORequest facturaCompraDTORequest) throws Exception {
        FacturaCompra oldFacturaCompra = null;
         List<DetalleCompra> detalle = new ArrayList<DetalleCompra>(); 
        Optional<FacturaCompra> optionalFacturaCompra = repository.findById(facturaCompraDTORequest.getFacturaCompraId());
        if (optionalFacturaCompra.isPresent()){
            oldFacturaCompra = optionalFacturaCompra.get();
            
            Persona empleado = repositoryPersona.getReferenceById(facturaCompraDTORequest.getEmpleadoId());
            Empresa empresa = repositoryEmpresa.getReferenceById(facturaCompraDTORequest.getEmpresaId());
            
            oldFacturaCompra.setFacturaCompraEstado(facturaCompraDTORequest.getFacturaCompraEstado().toUpperCase());
            oldFacturaCompra.setFacturaCompraFecha(facturaCompraDTORequest.getFacturaCompraFecha());
            oldFacturaCompra.setFacturaCompraId(facturaCompraDTORequest.getFacturaCompraId());
            oldFacturaCompra.setFacturaCompraMontoTotal(facturaCompraDTORequest.getFacturaCompraMontoTotal());
            oldFacturaCompra.setFacturaCompraNroRecibo(facturaCompraDTORequest.getFacturaCompraNroRecibo());
            oldFacturaCompra.setFacturaCompraTotalIva(facturaCompraDTORequest.getFacturaCompraTotalIva());
            oldFacturaCompra.setFacturaCondicion(facturaCompraDTORequest.getFacturaCondicion());
            oldFacturaCompra.setEmpleado(empleado);
            oldFacturaCompra.setEmpresa(empresa);
            
            for (DetalleCompraDTORequest detalleCompraDTORequest : facturaCompraDTORequest.getDetalleCompra()) {
                DetalleCompra oldDetalleCompra = null;
                Optional<DetalleCompra> optionalDetalleCompra = repositoryDetalleCompra.findById(detalleCompraDTORequest.getDetalleCompraId());
                if(optionalDetalleCompra.isPresent()) {
                    oldDetalleCompra = optionalDetalleCompra.get();
                    CaracteristicaProducto caracteristicaProducto = repositoryCaracteristicaProducto.getReferenceById(detalleCompraDTORequest.getCaracteristicasProductoId());
                    oldDetalleCompra.setDetalleCompraId(detalleCompraDTORequest.getDetalleCompraId());
                    oldDetalleCompra.setDetalleCompraCantidad(detalleCompraDTORequest.getDetalleCompraCantidad());
                    oldDetalleCompra.setDetalleCompraPrecioUnit(detalleCompraDTORequest.getDetalleCompraPrecioUnit());
                    oldDetalleCompra.setCaracteristicasProducto(caracteristicaProducto);
                    oldDetalleCompra.setDetalleCompraSubTotal(detalleCompraDTORequest.getDetalleCompraSubTotal());
                    detalle.add(oldDetalleCompra);
                }
            }
            oldFacturaCompra.setDetalleCompra(detalle);
            repository.save(oldFacturaCompra);
        } else {
            return new FacturaCompra();
        }
        return oldFacturaCompra;
    }

    @Override
    public Page<FacturaCompraDTOResponse> findPendingInvoicesByEmpresa(Long empresaId, Pageable pageable) throws Exception {
        List<FacturaCompraDTOResponse> listFacturas = new ArrayList<FacturaCompraDTOResponse>();
        Page<FacturaCompra> page = repository.findPendingInvoicesByEmpresa(empresaId, pageable);
        List<FacturaCompra> list = page.getContent();
        for (FacturaCompra factura : list) {
            listFacturas.add(converterFacturaCompra.toFacturaCompraDTO(factura));
        }
        Page<FacturaCompraDTOResponse> responsePage = new PageImpl<>(listFacturas, pageable, page.getTotalElements());
        return responsePage;
    }

    @Override
    public Page<FacturaCompraDTOResponse> findInvoicesByEmpleado(Long empleadoId, Pageable pageable) throws Exception {
        List<FacturaCompraDTOResponse> listFacturas = new ArrayList<FacturaCompraDTOResponse>();
        Page<FacturaCompra> page = repository.findInvoicesByEmpleado(empleadoId, pageable);
        List<FacturaCompra> list = page.getContent();
        for (FacturaCompra factura : list) {
            listFacturas.add(converterFacturaCompra.toFacturaCompraDTO(factura));
        }
        Page<FacturaCompraDTOResponse> responsePage = new PageImpl<>(listFacturas, pageable, page.getTotalElements());
        return responsePage;
    }

    @Override
    public FacturaCompraDTOResponse findFacturaById(Long idFactura) throws Exception {
        FacturaCompraDTOResponse  facturaCompraDTO = null;
        Optional<FacturaCompra> optionalFactura = repository.findById(idFactura);
        if (optionalFactura.isPresent()) {
            facturaCompraDTO = converterFacturaCompra.toFacturaCompraDTO(optionalFactura.get());
        }
        return facturaCompraDTO;
    }
    
}
