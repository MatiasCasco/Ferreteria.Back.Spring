package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.request.FacturaVentaDTORequest;
import com.casa.san.roque.ferreteria.model.response.FacturaVentaDTOResponse;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface FacturaVentaService {
    
    public List<FacturaVentaDTOResponse> FacturasPendientesBYEmpleado(Long idEmpleado) throws Exception;
     
    public FacturaVentaDTOResponse findFacturaById(Long idFactura) throws Exception;
     
    public List<FacturaVentaDTOResponse> findLast(Long idEmpleado, Long idCliente) throws Exception;
     
    public List<FacturaVentaDTOResponse> getFacturasByCliente(Long idCliente) throws Exception;
     
    public List<FacturaVentaDTOResponse> findFacturasByEmpleado(Long idEmpleado) throws Exception;
     
    public List<FacturaVentaDTOResponse> getAll() throws Exception;
     
    public FacturaVenta addFacturaVenta (FacturaVentaDTORequest facturaVentaDTO) throws Exception;
     
    public void removeFacturaVenta(Long idFacturaVenta) throws Exception;
     
    public void updateFacturaVenta(FacturaVenta FacturaVenta) throws Exception;
}
