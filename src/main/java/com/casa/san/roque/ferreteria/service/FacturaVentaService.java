package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.request.FacturaVentaDTORequest;
import com.casa.san.roque.ferreteria.model.response.FacturaVentaDTOResponse;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface FacturaVentaService {
    
    public Page<FacturaVentaDTOResponse> FacturasPendientesBYEmpleado(Long idEmpleado, Pageable pageable) throws Exception;
     
    public FacturaVentaDTOResponse findFacturaById(Long idFactura) throws Exception;
     
    public Page<FacturaVentaDTOResponse> findLast(Long idEmpleado, Long idCliente, Pageable pageable) throws Exception;
     
    public Page<FacturaVentaDTOResponse> getFacturasByCliente(Long idCliente, Pageable pageable) throws Exception;
     
    public Page<FacturaVentaDTOResponse> findFacturasByEmpleado(Long idEmpleado, Pageable pageable) throws Exception;
     
    public Page<FacturaVentaDTOResponse> getAll(Pageable pageable) throws Exception;
     
    public FacturaVenta addFacturaVenta (FacturaVentaDTORequest facturaVentaDTO) throws Exception;
     
    public void removeFacturaVenta(Long idFacturaVenta) throws Exception;
     
    public void updateFacturaVenta(FacturaVenta FacturaVenta) throws Exception;
}
