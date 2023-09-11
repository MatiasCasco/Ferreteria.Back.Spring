package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.TimbradoRepository;
import com.casa.san.roque.ferreteria.model.entity.Timbrado;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matias Casco
 */
@Service
public class TimbradoServiceImpl implements TimbradoService{
    
    @Autowired
    private TimbradoRepository repository;
    
    @Override
    public Timbrado addTimbrado(Timbrado timbrado) {
        return repository.save(timbrado);
    }

    @Override
    public List<Timbrado> addTimbrados(List<Timbrado> timbrados) {
        return repository.saveAll(timbrados);
    }

    @Override
    public Timbrado updateTimbrado(Timbrado timbrado) {
        Timbrado oldTimbrado = null;
        Optional<Timbrado> optionalTimbrado = repository.findById(timbrado.getTimbradoId());
        if (optionalTimbrado.isPresent()){
            oldTimbrado = optionalTimbrado.get();
            if (timbrado.getTimbradoNro() != null)
                oldTimbrado.setTimbradoNro(timbrado.getTimbradoNro());
            if (timbrado.getFechaInicio() != null)
                oldTimbrado.setFechaInicio(timbrado.getFechaInicio());
            if (timbrado.getFechaFin()!= null)
                oldTimbrado.setFechaFin(timbrado.getFechaFin());
            if (timbrado.getTimbradoEstado() != null)
                oldTimbrado.setTimbradoEstado(timbrado.getTimbradoEstado());
            repository.save(oldTimbrado);
        } else {
            return new Timbrado();
        }
        return oldTimbrado;
    }

    @Override
    public String deleteTimbrado(Long timbradoId) {
        repository.deleteById(timbradoId);
        return "Eliminacion exitosa del item ".concat(timbradoId.toString()); 
    }

    @Override
    public Page<Timbrado> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Timbrado findByTimbradoId(Long timbradoId) {
        Timbrado response = null;
        Optional<Timbrado> result = repository.findById(timbradoId);
        if (result.isPresent()) {
            response = result.get();
        }
        return response;
    }
    
}
