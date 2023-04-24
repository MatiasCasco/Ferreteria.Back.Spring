package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.response.FacturaVentaDTO;
import java.util.List;

/**
 *
 * @author Matias Casco
 */
public interface FacturaVentaService {
    
    public List<FacturaVentaDTO> FacturasPendientes(Long idEmpleado) throws Exception;
     
     public FacturaVentaDTO getFactura(Long idFactura) throws Exception;
     
     public List<FacturaVentaDTO> findLast(Long idEmpleado, Long idCliente) throws Exception;
     
     public List<FacturaVentaDTO> getFacturasByCliente(Long idCliente) throws Exception;
     
     public List<FacturaVentaDTO> findFacturasByEmpleado(Long idEmpleado) throws Exception;
     
     public List<FacturaVentaDTO> getAll() throws Exception;
     
     public void addFacturaVenta (FacturaVenta facturaVenta) throws Exception;
     
     public void removeFacturaVenta(Long idFacturaVenta) throws Exception;
     
     public void updateFacturaVenta(FacturaVenta FacturaVenta) throws Exception;
}
