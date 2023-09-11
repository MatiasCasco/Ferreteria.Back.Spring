package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.model.entity.Recepcion;
import com.casa.san.roque.ferreteria.model.request.RecepcionDTORequest;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Matias Casco
 */
public interface RecepcionService {
    public Recepcion addRecepcion(RecepcionDTORequest recepcion);
    
    public List<Recepcion> addRecepciones(List<RecepcionDTORequest> recepciones);

    public Recepcion updateRecepcion(RecepcionDTORequest recepcion);
    
    public String deleteRecepcion(Long recepcionId);
    
    public Page<Recepcion> getAll(Pageable pageable);
    
    public Recepcion findByRecepcionId(Long recepcionId);
}
