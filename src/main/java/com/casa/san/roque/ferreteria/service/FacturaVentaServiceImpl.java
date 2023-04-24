package com.casa.san.roque.ferreteria.service;

import com.casa.san.roque.ferreteria.dao.DetalleVentaRepository;
import com.casa.san.roque.ferreteria.dao.FacturaVentaRepository;
import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.mapper.FacturaVentaMapper;
import com.casa.san.roque.ferreteria.model.response.FacturaVentaDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matias Casco
 */
@Service
public class FacturaVentaServiceImpl implements FacturaVentaService {
    
    @Autowired
    private FacturaVentaRepository repository;
    
    @Autowired
    private FacturaVentaMapper mapperFactura;
    
    @Override
    public List<FacturaVentaDTO> FacturasPendientes(Long idEmpleado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FacturaVentaDTO getFactura(Long idFactura) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FacturaVentaDTO> findLast(Long idEmpleado, Long idCliente) throws Exception {
        List<FacturaVentaDTO> listFacturas = new ArrayList<FacturaVentaDTO>();
        List<FacturaVenta> list = repository.findLast(idEmpleado, idCliente);
        for (FacturaVenta factura : list) {
            listFacturas.add(mapperFactura.toFacturaVentaDTO(factura));
        }
        return listFacturas;
    }

    @Override
    public List<FacturaVentaDTO> getFacturasByCliente(Long idCliente) throws Exception {
        List<FacturaVentaDTO> listFacturas = new ArrayList<FacturaVentaDTO>();
        List<FacturaVenta> list = repository.findFacturasByCliente(idCliente);
        for (FacturaVenta factura : list) {
            listFacturas.add(mapperFactura.toFacturaVentaDTO(factura));
        }
        return listFacturas;
    }

    @Override
    public List<FacturaVentaDTO> getAll() throws Exception {
        List<FacturaVentaDTO> listFacturas = new ArrayList<FacturaVentaDTO>();
        List<FacturaVenta> list = repository.findAll();
        for (FacturaVenta factura : list) {
            listFacturas.add(mapperFactura.toFacturaVentaDTO(factura));
        }
        return listFacturas;
    }

    @Override
    public void addFacturaVenta(FacturaVenta facturaVenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeFacturaVenta(Long idFacturaVenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFacturaVenta(FacturaVenta FacturaVenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FacturaVentaDTO> findFacturasByEmpleado(Long idEmpleado) throws Exception {
        List<FacturaVentaDTO> listFacturas = new ArrayList<FacturaVentaDTO>();
        List<FacturaVenta> list = repository.findFacturasByEmpleado(idEmpleado);
        for (FacturaVenta factura : list) {
            listFacturas.add(mapperFactura.toFacturaVentaDTO(factura));
        }
        return listFacturas;
    }
    
}
