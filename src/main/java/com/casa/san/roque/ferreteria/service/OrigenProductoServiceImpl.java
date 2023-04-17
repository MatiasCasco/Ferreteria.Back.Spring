package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.converter.ConverterOrigenProducto;
import com.casa.san.roque.ferreteria.dao.EmpresaRepository;
import com.casa.san.roque.ferreteria.dao.OrigenProductoRepository;
import com.casa.san.roque.ferreteria.model.entity.Empresa;
import com.casa.san.roque.ferreteria.model.entity.OrigenProducto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.casa.san.roque.ferreteria.dao.CaracteristicasProductoRepository;
import com.casa.san.roque.ferreteria.dao.EmpresaContactoRepository;
import com.casa.san.roque.ferreteria.dao.ProductoRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicasProducto;
import com.casa.san.roque.ferreteria.model.entity.EmpresaContacto;
import com.casa.san.roque.ferreteria.model.entity.Producto;
import com.casa.san.roque.ferreteria.model.request.OrigenProductoDTO;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Matias Casco
 */
@Service
public class OrigenProductoServiceImpl implements OrigenProductoService{
    
    @Autowired
    private OrigenProductoRepository repository;
    
    @Autowired
    private EmpresaRepository repositoryEmpresa;
    
    @Autowired
    private EmpresaContactoRepository repositoryEmpresaContactoRepository;
    
    @Autowired
    private CaracteristicasProductoRepository repositoryCaracteristicasProducto;
    
    @Autowired
    private ProductoRepository repositoryProducto;
    
    @Autowired
    private ConverterOrigenProducto converterOrigenProducto;
    
    @Override
    public List<OrigenProducto> findByCaracteristicasProductoId(Long caracteristicasProductoId) {
        return repository.findByIdCaracteristicasWithEmpresaAndCaracteristicasProducto(caracteristicasProductoId);
    }

    @Override
    public List<OrigenProducto> findByProductoId(Long productoId) {
        return repository.findBYIdProductoWithEmpresaAndCaracteristicasProducto(productoId);
    }

    @Override
    public List<OrigenProducto> findByEmpresaId(Long empresaId) {
        return repository.findBYIdEmpresaWithEmpresaAndCaracteristicasProducto(empresaId);
    }

    @Override
    public List<OrigenProducto> findByEmpresaIdAndProductoId(Long empresaId, Long productoId) {
        return repository.findBYIdEmpresaAndIdProductoWithEmpresaAndCaracteristicasProducto(empresaId, productoId);
    }

    @Override
    public OrigenProducto addOrigenProducto(OrigenProducto origenProducto) {
        
        List<EmpresaContacto> empresaContactos = new ArrayList<>();
        for (EmpresaContacto empresasContacto : origenProducto.getEmpresa().getEmpresasContactos()) { 
            EmpresaContacto empresaContacto = repositoryEmpresaContactoRepository.findById(empresasContacto.getEmpresaContactoId())
                    .orElseThrow(() -> new IllegalArgumentException("EmpresaContacto cannot be null"));
            empresaContactos.add(empresaContacto);
        }
        
        Empresa empresa = repositoryEmpresa.findById(origenProducto.getEmpresa().getEmpresaId())
                .orElseThrow(() -> new IllegalArgumentException("Empresa cannot be null"));
        origenProducto.setEmpresa(empresa);
        empresa.setEmpresasContactos(empresaContactos);
        Producto producto = repositoryProducto.findById(origenProducto.getCaracteristicasProducto().getProducto().getProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Producto cannot be null"));
        CaracteristicasProducto caracteristicasProducto = repositoryCaracteristicasProducto.findById(origenProducto.getCaracteristicasProducto().getCaracteristicasProductoId())
                .orElseThrow(() -> new IllegalArgumentException("CaracteristicasProducto cannot be null"));
        caracteristicasProducto.setProducto(producto);
        origenProducto.setCaracteristicasProducto(caracteristicasProducto);

        if (origenProducto.getUltimaCompra() == null) {
            origenProducto.setUltimaCompra(Calendar.getInstance());
        }

        return repository.save(origenProducto);
    }

    @Override
    public List<OrigenProducto> addOrigenProductos(List<OrigenProducto> origenProductos) {
        return repository.saveAll(origenProductos);
    }

    @Override
    public OrigenProducto updateOrigenProducto(OrigenProducto origenProducto) {
        OrigenProducto oldOrigenProducto = null;
        Optional<OrigenProducto> optionalOrigenProducto = repository.findById(origenProducto.getOrigenProductoId());
        if (optionalOrigenProducto.isPresent()){
            oldOrigenProducto = optionalOrigenProducto.get();
            oldOrigenProducto.setOrigenProductoId(origenProducto.getOrigenProductoId());
            oldOrigenProducto.setEmpresa(origenProducto.getEmpresa());
            oldOrigenProducto.setCaracteristicasProducto(origenProducto.getCaracteristicasProducto());
            oldOrigenProducto.setPrecioVentaProveedor(origenProducto.getPrecioVentaProveedor());
            oldOrigenProducto.setUltimaCompra(origenProducto.getUltimaCompra());
            repository.save(oldOrigenProducto);
        } else {
            return new OrigenProducto();
        }
        return origenProducto;
    }

    @Override
    public String deleteOrigenProducto(Long origenProductoId) {
        repository.deleteById(origenProductoId);
        return "Eliminacion exitosa del item ".concat(origenProductoId.toString());
    }

    @Override
    public OrigenProducto findByOrigenProductoId(Long origenProductoId) {
        OrigenProducto response = null;
        Optional<OrigenProducto> result = repository.findById(origenProductoId);
        if(result.isPresent()){
            response = result.get();
        }
        return response;
    }

    @Override
    public OrigenProducto addOrigenProduct(OrigenProductoDTO origenProductoDTO) {
        OrigenProducto origenProducto = converterOrigenProducto.convertToEntity(origenProductoDTO);
        return repository.save(origenProducto);
    }

    @Override
    public List<OrigenProducto> addOrigenProducts(List<OrigenProductoDTO> origenProductosDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}