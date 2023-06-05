package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Descuento;
import com.casa.san.roque.ferreteria.model.request.DescuentoDTORequest;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface DescuentoService {
    
    public Page<Descuento> getAll(Pageable pageable);
    
    public Descuento findByDescuentoId(Long descuentoId);
    
    public Descuento findByDescuento(Long productoId, Long cantidad);
    
    public Descuento addDescuento(DescuentoDTORequest descuento);

    public List<Descuento> addDescuentos(List<DescuentoDTORequest> descuentos);

    public Descuento updateDescuento(DescuentoDTORequest descuento);

    public String deleteDescuentos(Long descuentoId);

}
