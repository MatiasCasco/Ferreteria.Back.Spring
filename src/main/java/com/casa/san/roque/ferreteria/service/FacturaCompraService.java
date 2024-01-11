package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.FacturaCompra;
import com.casa.san.roque.ferreteria.model.request.FacturaCompraDTORequest;
import com.casa.san.roque.ferreteria.model.response.FacturaCompraDTOResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface FacturaCompraService {
    
    public FacturaCompraDTOResponse findFacturaById(Long idFactura) throws Exception;
    
    public Page<FacturaCompraDTOResponse> findPendingInvoicesByEmpresa(Long empresaId, Pageable pageable) throws Exception;
    
    public Page<FacturaCompraDTOResponse> findInvoicesByEmpleado(Long empleadoId, Pageable pageable) throws Exception;
    
    public Page<FacturaCompraDTOResponse> getAll(Pageable pageable) throws Exception;
     
    public FacturaCompra addFacturaCompra (FacturaCompraDTORequest facturaCompraDTO) throws Exception;
     
    public void removeFacturaCompra(Long idFacturaCompra) throws Exception;
     
    public FacturaCompra updateFacturaCompra(FacturaCompraDTORequest facturaCompraDTO) throws Exception;
}
