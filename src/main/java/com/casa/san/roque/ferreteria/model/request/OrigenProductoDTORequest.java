package com.casa.san.roque.ferreteria.model.request;

import java.util.Calendar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Matias Casco
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrigenProductoDTORequest { 
    private Long OrigenProductoId;
    private Long empresaId; 
    private Long caracteristicasProductoId;
    private double precioVentaProveedor;
    private Calendar ultimaCompra;
}
