package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.converter.ConverterCaracterisitcaProducto;
import com.casa.san.roque.ferreteria.dao.CaracteristicaProductoRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import com.casa.san.roque.ferreteria.model.request.CaracteristicaProductoDTORequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matias Casco
 */
@Service
public class CaracteristicaProductoServiceImpl implements CaracteristicaProductoService {

    @Autowired
    private CaracteristicaProductoRepository repository;
    
    @Autowired
    private ConverterCaracterisitcaProducto converterCaracterisitcaProducto; 
    
    @Override
    public List<CaracteristicaProducto> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return repository.findAll();
    }

    @Override
    public CaracteristicaProducto findByCaracteristicaId(Long caracteristicaProductoId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return repository.findById(caracteristicaProductoId).orElse(new CaracteristicaProducto());
    }

    @Transactional
    @Override
    public CaracteristicaProducto addCaracteristicaProducto(CaracteristicaProductoDTORequest caracteristicaProductoRequest) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return repository.save(converterCaracterisitcaProducto.toCaracteristicaProducto(caracteristicaProductoRequest));
    }

    @Transactional
    @Override
    public List<CaracteristicaProducto> addCaracteristicaProductos(List<CaracteristicaProductoDTORequest> productos) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<CaracteristicaProducto> list = new ArrayList<>();
        for (CaracteristicaProductoDTORequest producto : productos) {
            list.add(converterCaracterisitcaProducto.toCaracteristicaProducto(producto));
        }
        return repository.saveAll(list);
    }

    @Transactional
    @Override
    public CaracteristicaProducto updateCaracteristicaProducto(CaracteristicaProductoDTORequest caracteristicaProductoRequest) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        CaracteristicaProducto oldCaracteristicaProducto = new CaracteristicaProducto();
        Optional<CaracteristicaProducto> optionalCaracteristicaProducto = repository.findById(caracteristicaProductoRequest.getCaracteristicasProductoId());
        CaracteristicaProducto converter = converterCaracterisitcaProducto.toCaracteristicaProducto(caracteristicaProductoRequest);
        if (optionalCaracteristicaProducto.isPresent()){
            oldCaracteristicaProducto = optionalCaracteristicaProducto.get();
            oldCaracteristicaProducto.setMarcaId(converter.getMarcaId());
            oldCaracteristicaProducto.setMarcaNombre(converter.getMarcaNombre());
            oldCaracteristicaProducto.setOrigenProducto(converter.getOrigenProducto());
            oldCaracteristicaProducto.setProducto(converter.getProducto());
            oldCaracteristicaProducto.setProductoCosto(converter.getProductoCosto());
            oldCaracteristicaProducto.setProductoPrecio(converter.getProductoPrecio());
            oldCaracteristicaProducto.setProductoStockMin(converter.getProductoStockMin());
            oldCaracteristicaProducto.setProductoStockActual(converter.getProductoStockActual());
            oldCaracteristicaProducto.setProductoStockMax(converter.getProductoStockMax());
            repository.save(oldCaracteristicaProducto);
        } else {
            return new CaracteristicaProducto();
        }
        return oldCaracteristicaProducto;
    }

    @Transactional
    @Override
    public String deleteCaracteristicaProducto(Long caracteristicaProductoId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        repository.deleteById(caracteristicaProductoId);
        return "Eliminacion exitosa del item ".concat(caracteristicaProductoId.toString());
    }
    
}