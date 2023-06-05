package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.converter.ConverterDetalleVenta;
import com.casa.san.roque.ferreteria.dao.DetalleVentaRepository;
import com.casa.san.roque.ferreteria.dao.FacturaVentaRepository;
import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.entity.DetalleVenta;
import com.casa.san.roque.ferreteria.converter.ConverterFacturaVenta;
import com.casa.san.roque.ferreteria.dao.PersonaRepository;
import com.casa.san.roque.ferreteria.model.request.DetalleVentaDTORequest;
import com.casa.san.roque.ferreteria.model.request.FacturaVentaDTORequest;
import com.casa.san.roque.ferreteria.model.response.FacturaVentaDTOResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
@Service
public class FacturaVentaServiceImpl implements FacturaVentaService {
    
    @Autowired
    private FacturaVentaRepository repository;
    
    @Autowired
    private DetalleVentaRepository repositoryDetalleVenta;
    
    @Autowired
    private PersonaRepository repositoryPersona;
    
    @Autowired
    private ConverterFacturaVenta converterFacturaVenta;
    
    @Autowired
    private ConverterDetalleVenta converterDetalleVenta;
    
    private static final String estadoFactura = "INSERTANDO";
    
    @Override
    public Page<FacturaVentaDTOResponse> FacturasPendientesBYEmpleado(Long idEmpleado, Pageable pageable) throws Exception {
        List<FacturaVentaDTOResponse> listFacturas = new ArrayList<FacturaVentaDTOResponse>();
        Page<FacturaVenta> page = repository.FacturasPendientesBYEmpleado(idEmpleado, pageable);
        List<FacturaVenta> list = page.getContent();
        for (FacturaVenta factura : list) {
            listFacturas.add(converterFacturaVenta.toFacturaVentaDTO(factura));
        }
        Page<FacturaVentaDTOResponse> responsePage = new PageImpl<>(listFacturas, pageable, page.getTotalElements());
        return responsePage;
    }

    @Override
    public FacturaVentaDTOResponse findFacturaById(Long idFactura) throws Exception {
        FacturaVentaDTOResponse  facturaVentaDTO = null;
        Optional<FacturaVenta> optionalFactura = repository.findById(idFactura);
        if (optionalFactura.isPresent()) {
            facturaVentaDTO = converterFacturaVenta.toFacturaVentaDTO(optionalFactura.get());
        }
        return facturaVentaDTO;
    }

    @Override
    public Page<FacturaVentaDTOResponse> findLast(Long idEmpleado, Long idCliente, Pageable pageable) throws Exception {
        List<FacturaVentaDTOResponse> listFacturas = new ArrayList<FacturaVentaDTOResponse>();
        Page<FacturaVenta> page = repository.findLast(idEmpleado, idCliente, pageable);
        List<FacturaVenta> list = page.getContent();
        for (FacturaVenta factura : list) {
            listFacturas.add(converterFacturaVenta.toFacturaVentaDTO(factura));
        }
        Page<FacturaVentaDTOResponse> responsePage = new PageImpl<>(listFacturas, pageable, page.getTotalElements());
        return responsePage;
    }

    @Override
    public Page<FacturaVentaDTOResponse> getFacturasByCliente(Long idCliente, Pageable pageable) throws Exception {
        List<FacturaVentaDTOResponse> listFacturas = new ArrayList<FacturaVentaDTOResponse>();
        Page<FacturaVenta> page = repository.findFacturasByCliente(idCliente, pageable);
        List<FacturaVenta> list = page.getContent();
        for (FacturaVenta factura : list) {
            listFacturas.add(converterFacturaVenta.toFacturaVentaDTO(factura));
        }
        Page<FacturaVentaDTOResponse> responsePage = new PageImpl<>(listFacturas, pageable, page.getTotalElements());
        return responsePage;
    }

    @Override
    public Page<FacturaVentaDTOResponse> getAll(Pageable pageable) throws Exception {
        List<FacturaVentaDTOResponse> listFacturas = new ArrayList<FacturaVentaDTOResponse>();
        Page<FacturaVenta> page = repository.findAll(pageable);
        List<FacturaVenta> list = page.getContent();
        for (FacturaVenta factura : list) {
            listFacturas.add(converterFacturaVenta.toFacturaVentaDTO(factura));
        }
        Page<FacturaVentaDTOResponse> responsePage = new PageImpl<>(listFacturas, pageable, page.getTotalElements());
        return responsePage;
    }
    
    @Transactional
    @Override
    public FacturaVenta addFacturaVenta(FacturaVentaDTORequest facturaVentaDTO) throws Exception {
        List<DetalleVenta> detalle = new ArrayList<DetalleVenta>(); 
        FacturaVenta facturaVenta = new FacturaVenta();
        facturaVenta = converterFacturaVenta.toFacturaVenta(facturaVentaDTO);
        repository.save(facturaVenta);
//        repository.findLastFacturaVenta(facturaVentaDTO.getEmpleadoId(), estadoFactura);
        facturaVenta = repository.findLastInsertedByEmpleadoId(facturaVentaDTO.getEmpleadoId());
        for (DetalleVentaDTORequest detalleVentaDTORequest : facturaVentaDTO.getDetalleVenta()) {
            detalle.add(converterDetalleVenta.toDetalleVenta(detalleVentaDTORequest, facturaVenta.getFacturaVentaId()));
        }
        repositoryDetalleVenta.saveAll(detalle);
        facturaVenta.setFacturaVentaEstado("PAGADO");
        facturaVenta.setDetalleVenta(detalle);
        repository.save(facturaVenta);
        return facturaVenta;
    }
    
    @Transactional
    @Override
    public void removeFacturaVenta(Long idFacturaVenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    @Override
    public void updateFacturaVenta(FacturaVenta FacturaVenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<FacturaVentaDTOResponse> findFacturasByEmpleado(Long idEmpleado, Pageable pageable) throws Exception {
        List<FacturaVentaDTOResponse> listFacturas = new ArrayList<FacturaVentaDTOResponse>();
        Page<FacturaVenta> page = repository.findFacturasByEmpleado(idEmpleado, pageable);
        List<FacturaVenta> list = page.getContent();
        for (FacturaVenta factura : list) {
            listFacturas.add(converterFacturaVenta.toFacturaVentaDTO(factura));
        }
        Page<FacturaVentaDTOResponse> responsePage = new PageImpl<>(listFacturas, pageable, page.getTotalElements());
        return responsePage;
    }
    
}
