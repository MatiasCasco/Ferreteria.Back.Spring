package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.converter.ConverterDescuento;
import com.casa.san.roque.ferreteria.model.entity.Descuento;
import com.casa.san.roque.ferreteria.model.request.DescuentoDTORequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.casa.san.roque.ferreteria.dao.DescuentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 *
 * @author Matias Casco
 */
@Service
public class DescuentoServiceImpl implements  DescuentoService {
    
    @Autowired
    private DescuentoRepository repository;
    
    @Autowired
    private ConverterDescuento converterDescuento;
    
    @Override
    public Page<Descuento> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Descuento findByDescuentoId(Long descuentoId) {
        Descuento response = null;
        Optional<Descuento> result = repository.findById(descuentoId);
        if(result.isPresent()){
            response = result.get();
        }
        return response; 
    }

    @Transactional
    @Override
    public Descuento addDescuento(DescuentoDTORequest descuento) {
        return repository.save(converterDescuento.toDescuento(descuento));
    }

    @Transactional
    @Override
    public List<Descuento> addDescuentos(List<DescuentoDTORequest> descuentos) {
        List<Descuento> list = new ArrayList<>();
        for (DescuentoDTORequest descuento : descuentos) {
            list.add(converterDescuento.toDescuento(descuento));
        }
        return repository.saveAll(list);
    }

    @Transactional
    @Override
    public Descuento updateDescuento(DescuentoDTORequest descuento) {
        Descuento oldDescuento = null;
        Optional<Descuento> optionalDescuento = repository.findById(descuento.getDescuentoId());
        Descuento convertDescuento = new Descuento();
        convertDescuento = converterDescuento.toDescuento(descuento);
        if (optionalDescuento.isPresent()){
            oldDescuento = optionalDescuento.get();
            oldDescuento.setPorcentajeDescuento(convertDescuento.getPorcentajeDescuento());
            oldDescuento.setProducto(convertDescuento.getProducto());
            oldDescuento.setRangoInferior(convertDescuento.getRangoInferior());
            oldDescuento.setRangoSuperior(convertDescuento.getRangoSuperior());
            repository.save(oldDescuento);
        } else {
            return new Descuento();
        }
        return convertDescuento;
    }

    @Transactional
    @Override
    public String deleteDescuentos(Long descuentoId) {
        repository.deleteById(descuentoId);
        return "Eliminacion exitosa del item ".concat(descuentoId.toString()); 
    }

    @Override
    public Descuento findByDescuento(Long productoId, Long cantidad) {
        return repository.findByDescuento(productoId, cantidad);
    }
    
}
