package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.converter.ConverterRecepcion;
import com.casa.san.roque.ferreteria.dao.RecepcionRepository;
import com.casa.san.roque.ferreteria.model.entity.Recepcion;
import com.casa.san.roque.ferreteria.model.request.RecepcionDTORequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matias Casco
 */
@Service
public class RecepcionServiceImpl implements RecepcionService {
    
    @Autowired
    private RecepcionRepository repository;
    
    @Autowired
    private ConverterRecepcion converterRecepcion;
    
    @Transactional
    @Override
    public Recepcion addRecepcion(RecepcionDTORequest recepcion) {
        Recepcion converter = converterRecepcion.toRecepcion(recepcion);
        return repository.save(converter);
    }
    
    @Transactional
    @Override
    public List<Recepcion> addRecepciones(List<RecepcionDTORequest> recepciones) {
        List<Recepcion> list = new ArrayList<>();
        for (RecepcionDTORequest request : recepciones) {
            Recepcion converter = converterRecepcion.toRecepcion(request);
            list.add(converter);
        }
        return repository.saveAll(list);
    }

    @Transactional
    @Override
    public Recepcion updateRecepcion(RecepcionDTORequest recepcion) {
        Recepcion oldRecepcion = null;
        Optional<Recepcion> optionalRecepcion = repository.findById(recepcion.getRecepcionId());
        Recepcion converter = converterRecepcion.toRecepcion(recepcion);
        if (optionalRecepcion.isPresent()){
            oldRecepcion = optionalRecepcion.get();
            oldRecepcion.setRecepcionId(converter.getRecepcionId());
            oldRecepcion.setCaracteristicaProducto(converter.getCaracteristicaProducto());
            oldRecepcion.setCantidadEsperada(converter.getCantidadEsperada());
            oldRecepcion.setCantidadRecibida(converter.getCantidadRecibida());
            oldRecepcion.setFechaRecepcion(converter.getFechaRecepcion());
            repository.save(oldRecepcion);
        } else {
            return new Recepcion();
        }
        return oldRecepcion;
    }
    
    @Transactional
    @Override
    public String deleteRecepcion(Long recepcionId) {
        repository.deleteById(recepcionId);
        return "Eliminacion exitosa del item ".concat(recepcionId.toString()); 
    }

    @Override
    public Page<Recepcion> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Recepcion findByRecepcionId(Long recepcionId) {
        Recepcion response = null;
        Optional<Recepcion> result = repository.findById(recepcionId);
        if (result.isPresent()) {
            response = result.get();
        }
        return response;
    }
    
    
    
}
