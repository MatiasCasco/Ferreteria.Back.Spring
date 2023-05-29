package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.MarcaRepository;
import com.casa.san.roque.ferreteria.model.entity.Marca;
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
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository repositoryMarca;
    
    @Override
    public Page<Marca> getAll(Pageable pageable) {
        return repositoryMarca.findAll(pageable);
    }

    @Override
    public Marca findByMarcaId(Long marcaId) {
        Marca response = null;
        Optional<Marca> result = repositoryMarca.findById(marcaId);
        if(result.isPresent()){
            response = result.get();
        }
        return response;
    }
    
    @Transactional
    @Override
    public Marca addMarca(Marca marca) {
        return repositoryMarca.save(marca);
    }
    
    @Transactional
    @Override
    public List<Marca> addMarcas(List<Marca> marcas) {
        return repositoryMarca.saveAll(marcas);
    }
    
    @Transactional
    @Override
    public Marca updateMarca(Marca marca) {
        Marca oldMarca = new Marca();
        Optional<Marca> optionalMarca = repositoryMarca.findById(marca.getMarcaId());
        if (optionalMarca.isPresent()){
            oldMarca = optionalMarca.get();
            oldMarca.setMarcaId(marca.getMarcaId());
            oldMarca.setMarcaDescripcion(marca.getMarcaDescripcion());
            repositoryMarca.save(oldMarca);
        } else {
            return new Marca();
        }
        return oldMarca;
    }
    
    @Transactional
    @Override
    public String deleteMarca(Long marcaId) {
        repositoryMarca.deleteById(marcaId);
        return "Eliminacion exitosa del item ".concat(marcaId.toString());
    }
    
}
