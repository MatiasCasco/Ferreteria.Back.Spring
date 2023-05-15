package com.casa.san.roque.ferreteria.converter;

import com.casa.san.roque.ferreteria.model.entity.Caja;
import com.casa.san.roque.ferreteria.model.entity.DetalleCaja;
import com.casa.san.roque.ferreteria.model.entity.FacturaVenta;
import com.casa.san.roque.ferreteria.model.request.CajaDetalleDTORequest;
import com.casa.san.roque.ferreteria.model.response.CajaDetalleDTOResponse;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matias Casco
 */
@Component
public class ConverterDetalleCaja {
    
    public DetalleCaja toDetalleCaja(CajaDetalleDTORequest cajaDetalleDTORequest) {
        DetalleCaja detalleCaja = new DetalleCaja();
        Caja caja = new Caja();
        FacturaVenta facturaVenta = new FacturaVenta();
        caja.setCajaId(cajaDetalleDTORequest.getCajaId());
        facturaVenta.setFacturaVentaId(cajaDetalleDTORequest.getFacturaVentaId());
        detalleCaja.setCaja(caja);
        detalleCaja.setDetalleCajaFecha(LocalDateTime.now());
        detalleCaja.setFacturaVenta(facturaVenta);
        detalleCaja.setDetalleCajaMontoTotal(cajaDetalleDTORequest.getDetalleCajaMontoTotal());
        detalleCaja.setDetalleCajaMontoRecibido(cajaDetalleDTORequest.getDetalleCajaMontoRecibido());
        return detalleCaja;
    }
    
    public CajaDetalleDTOResponse toCajaDetalleDTOResponse(DetalleCaja detalleCaja) {
        CajaDetalleDTOResponse cajaDetalleDTOResponse = new CajaDetalleDTOResponse();
        cajaDetalleDTOResponse.setCajaId(detalleCaja.getCaja().getCajaId());
        cajaDetalleDTOResponse.setDetalleCajaFecha(detalleCaja.getDetalleCajaFecha());
        cajaDetalleDTOResponse.setFacturaVentaId(detalleCaja.getFacturaVenta().getFacturaVentaId());
        cajaDetalleDTOResponse.setDetalleCajaMontoTotal(detalleCaja.getDetalleCajaMontoTotal());
        cajaDetalleDTOResponse.setDetalleCajaMontoRecibido(detalleCaja.getDetalleCajaMontoRecibido());
        return cajaDetalleDTOResponse;
    }
    
}
