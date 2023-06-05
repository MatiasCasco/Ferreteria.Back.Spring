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
import com.casa.san.roque.ferreteria.dao.EmpresaContactoRepository;
import com.casa.san.roque.ferreteria.dao.ProductoRepository;
import com.casa.san.roque.ferreteria.model.entity.CaracteristicaProducto;
import com.casa.san.roque.ferreteria.model.entity.EmpresaContacto;
import com.casa.san.roque.ferreteria.model.entity.Producto;
import com.casa.san.roque.ferreteria.model.request.OrigenProductoDTORequest;
import java.util.ArrayList;
import java.util.Calendar;
import org.springframework.transaction.annotation.Transactional;
import com.casa.san.roque.ferreteria.dao.CaracteristicaProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    private CaracteristicaProductoRepository repositoryCaracteristicasProducto;
    
    @Autowired
    private ProductoRepository repositoryProducto;
    
    @Autowired
    private ConverterOrigenProducto converterOrigenProducto;
    
    @Override
    public Page<OrigenProducto> findByCaracteristicasProductoId(Long caracteristicasProductoId, Pageable pageable) {
        return repository.findByIdCaracteristicasWithEmpresaAndCaracteristicasProducto(caracteristicasProductoId, pageable);
    }

    @Override
    public Page<OrigenProducto> findByProductoId(Long productoId, Pageable pageable) {
        return repository.findBYIdProductoWithEmpresaAndCaracteristicasProducto(productoId, pageable);
    }

    @Override
    public Page<OrigenProducto> findByEmpresaId(Long empresaId, Pageable pageable) {
        return repository.findBYIdEmpresaWithEmpresaAndCaracteristicasProducto(empresaId, pageable);
    }

    @Override
    public Page<OrigenProducto> findByEmpresaIdAndProductoId(Long empresaId, Long productoId, Pageable pageable) {
        return repository.findBYIdEmpresaAndIdProductoWithEmpresaAndCaracteristicasProducto(empresaId, productoId, pageable);
    }
    
    @Transactional
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
        CaracteristicaProducto caracteristicasProducto = repositoryCaracteristicasProducto.findById(origenProducto.getCaracteristicasProducto().getCaracteristicasProductoId())
                .orElseThrow(() -> new IllegalArgumentException("CaracteristicasProducto cannot be null"));
        caracteristicasProducto.setProducto(producto);
        origenProducto.setCaracteristicasProducto(caracteristicasProducto);

        if (origenProducto.getUltimaCompra() == null) {
            origenProducto.setUltimaCompra(Calendar.getInstance());
        }

        return repository.save(origenProducto);
    }
    
    @Transactional
    @Override
    public List<OrigenProducto> addOrigenProductos(List<OrigenProducto> origenProductos) {
        return repository.saveAll(origenProductos);
    }

    @Transactional
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

    @Transactional
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
    
    @Transactional
    @Override
    public OrigenProducto addOrigenProduct(OrigenProductoDTORequest origenProductoDTO) {
        OrigenProducto origenProducto = converterOrigenProducto.convertToEntity(origenProductoDTO);
        return repository.save(origenProducto);
    }

    @Transactional
    @Override
    public List<OrigenProducto> addOrigenProducts(List<OrigenProductoDTORequest> origenProductosDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Page<OrigenProducto> getAll(Pageable pageable){
        return repository.getAll(pageable);
    }
}