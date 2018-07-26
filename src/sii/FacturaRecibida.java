/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii;

import es.gorina.sqlobjects.DataConnection;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.respuestasuministro.RespuestaLRFRecibidasType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.respuestasuministro.RespuestaRecibidaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactrecibidas.SiiSOAP;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactrecibidas.SiiService;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.CabeceraSii;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.ClaveTipoComunicacionType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.ClaveTipoFacturaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.CountryType2;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.DatosPresentacionType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.DesgloseFacturaRecibidasType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.DesgloseFacturaRecibidasType.DesgloseIVA;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.DetalleIVARecibidaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.FacturaRecibidaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.IDFacturaRecibidaType.IDEmisorFactura;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.RegistroSii.PeriodoImpositivo;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrolr.LRFacturasRecibidasType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrolr.SuministroLRFacturasRecibidas;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.IDOtroType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.IDFacturaRecibidaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.PersonaFisicaJuridicaESType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.PersonaFisicaJuridicaType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author paco
 */
public class FacturaRecibida {
    
    String ejercicio;//*
    String periodoEj;//*
    String idEmisorFactura;
    String numSerieFacturaEmisor;
    String fechaExpFacturaEmisor;
    String fechaRegContable;
    String tipoFactura;
    String claveRegEspoTrascendencia;
    String importeTotal;
    String descripcionOperacion;
    String contraparteNombreRazon;
    String nif; //*  
    String idOtroCodigoPais;
    String idOtroIdType;
    String idOtroId;
    String fraIva;
    String base_0;
    String base_1;
    String tipo_1;
    String cuota_1;
    String base_2;
    String tipo_2;
    String cuota_2;
    String base_3;
    String tipo_3;
    String cuota_3;
    String base_importacion;
    String tipo_importacion;
    String cuota_importacion;
    String cuotaDeducible;
    Date fecha;
    String proveedor;
    BigDecimal codigo;
    
    
       static public int procesaFacturesPendentsFinsAl(DataConnection dc, String when) throws SQLException, ClassNotFoundException{
        
        Vector<Object[]> factures = dc.lookup("select\n" +
                "ejercicio, periodo, idEmisorFactura, numSerieFacturaEmisor, fechaExpFacturaEmisor, fechaRegContable, \n" +
                "tipoFactura, claveRegEspoTrascendencia, importeTotal, descripcionOperacion, contraparteNombreRazon, nif,\n" +
                "idOtroCodigoPais, idOtroIdType, idOtroId, fraIva, \n" +
                "base_0, base_1, tipo_1, iva_1, base_2, tipo_2, iva_2, base_3, tipo_3, iva_3, \n" +
                "base_importac, tipo_i, iva_importac, cuotaDeducible, fecha, proveedor, codigo\n" +
                "from factures_rebudes_sii\n" +
                "WHERE FECHA <= to_date(?, 'DD/MM/YY') and SII is  null and fecha >= to_date('01/07/17', 'DD/MM/YY')", 
                new Object[]{when});
        
        PersonaFisicaJuridicaESType jo = new PersonaFisicaJuridicaESType();
        
      
        jo.setNIF("B65817041");
        jo.setNombreRazon("EVERCLOTH S.L.");

        
        RespuestaLRFRecibidasType resposta = sendFacturas(factures, jo);
        
        if (resposta != null){
            return procesaRespuesta(dc, resposta);
        }
        
        return 0;
     }
 
       
         /**
     * Genera i envia el fitxer a la AEAT
     * 
     * @param facturas 
     */
    static public RespuestaLRFRecibidasType sendFacturas(Vector<Object[]> facturas, PersonaFisicaJuridicaESType jo){
        
        // Construcció de les dades
        if (facturas.size() == 0){
            return null;
        }
 
        CabeceraSii cabecera = new CabeceraSii();
        cabecera.setIDVersionSii("1.0");
        cabecera.setTipoComunicacion(ClaveTipoComunicacionType.A_0);
         
        cabecera.setTitular(jo);
        
        SuministroLRFacturasRecibidas suministro = new SuministroLRFacturasRecibidas();
        
        suministro.setCabecera(cabecera);
        
        for (int i = 0; i < facturas.size(); i++){
            Object[] datos = facturas.elementAt(i);
            FacturaRecibida factura = new FacturaRecibida(datos);
            suministro.getRegistroLRFacturasRecibidas().add(factura.getLRfacturaRecibida());
    
        }
         
        // Enviament a la AEAT
        RespuestaLRFRecibidasType resposta;    
        
   
        resposta = suministroLRFacturasRecibidas(suministro);
        return resposta;
    
    }
  
    
    public FacturaRecibida(Object[] datos){
        
              int i = 0;
        
            ejercicio = (String)datos[i++];
            periodoEj = (String)datos[i++];
            idEmisorFactura = (String)datos[i++];
            numSerieFacturaEmisor = (String)datos[i++];
            fechaExpFacturaEmisor = (String)datos[i++];
            fechaRegContable = (String)datos[i++];
            tipoFactura = (String)datos[i++];
            claveRegEspoTrascendencia = (String)datos[i++];
            importeTotal = (String)datos[i++];
            descripcionOperacion = (String)datos[i++];
            contraparteNombreRazon = (String)datos[i++];
            nif = (String)datos[i++]; //*  
            idOtroCodigoPais = (String)datos[i++];
            idOtroIdType = (String)datos[i++];
            idOtroId = (String)datos[i++];
            fraIva = (String)datos[i++];
            base_0 = (String)datos[i++];
            base_1 = (String)datos[i++];
            tipo_1 = (String)datos[i++];
            cuota_1 = (String)datos[i++];
            base_2 = (String)datos[i++];
            tipo_2 = (String)datos[i++];
            cuota_2 = (String)datos[i++];
            base_3 = (String)datos[i++];
            tipo_3 = (String)datos[i++];
            cuota_3 = (String)datos[i++];
            base_importacion = (String)datos[i++];
            tipo_importacion = (String)datos[i++];
            cuota_importacion = (String)datos[i++];
            cuotaDeducible = (String)datos[i++];
            fecha = new Date(((Timestamp)datos[i++]).getTime());
            proveedor = (String)datos[i++];
            codigo = (BigDecimal)datos[i++];        
    
    
    }
    
    public LRFacturasRecibidasType getLRfacturaRecibida(){
        
          
        LRFacturasRecibidasType factura = new LRFacturasRecibidasType();
        
        
        
        PeriodoImpositivo periodo = new PeriodoImpositivo();
        periodo.setEjercicio(ejercicio);
        periodo.setPeriodo(periodoEj);
        
        factura.setPeriodoImpositivo(periodo);
        
       
        
        IDEmisorFactura emisorFactura = new IDEmisorFactura();
        
        if (this.idOtroCodigoPais.equals("ES")){
            emisorFactura.setNIF(nif);
        } else {
            IDOtroType idOtro = new IDOtroType();
            idOtro.setIDType(this.idOtroIdType);
            idOtro.setID(this.idOtroId);
            idOtro.setCodigoPais(CountryType2.valueOf(this.idOtroCodigoPais));
            emisorFactura.setIDOtro(idOtro);
            
        }
        
        IDFacturaRecibidaType idFactura = new IDFacturaRecibidaType();
        idFactura.setIDEmisorFactura(emisorFactura);
        idFactura.setNumSerieFacturaEmisor(numSerieFacturaEmisor);
        idFactura.setFechaExpedicionFacturaEmisor(fechaExpFacturaEmisor);
        
        factura.setIDFactura(idFactura);
        
        
        FacturaRecibidaType dadesFactura = new FacturaRecibidaType();
        
        dadesFactura.setTipoFactura(ClaveTipoFacturaType.fromValue(tipoFactura));
        dadesFactura.setClaveRegimenEspecialOTrascendencia(claveRegEspoTrascendencia);
        dadesFactura.setImporteTotal(importeTotal);
        dadesFactura.setDescripcionOperacion(descripcionOperacion);
        dadesFactura.setFechaRegContable(fechaRegContable);
        dadesFactura.setCuotaDeducible(cuotaDeducible);
        
        DesgloseFacturaRecibidasType desglose = new DesgloseFacturaRecibidasType();
        
        DesgloseIVA desgloseIva = new DesgloseIVA();
         
        
        if (! base_0.equals("0")){
            DetalleIVARecibidaType detalle = new DetalleIVARecibidaType();
            detalle.setBaseImponible(base_0);
            detalle.setTipoImpositivo("0");
            detalle.setCuotaSoportada("0");
            desgloseIva.getDetalleIVA().add(detalle);
        }
        if (! base_1.equals("0")){
            DetalleIVARecibidaType detalle = new DetalleIVARecibidaType();
            detalle.setBaseImponible(base_1);
            detalle.setTipoImpositivo(tipo_1);
            detalle.setCuotaSoportada(cuota_1);
            desgloseIva.getDetalleIVA().add(detalle);
        }
        
          if (! base_2.equals("0")){
            DetalleIVARecibidaType detalle = new DetalleIVARecibidaType();
            detalle.setBaseImponible(base_2);
            detalle.setTipoImpositivo(tipo_2);
            detalle.setCuotaSoportada(cuota_2);
            desgloseIva.getDetalleIVA().add(detalle);
        }
        if (! base_3.equals("0")){
            DetalleIVARecibidaType detalle = new DetalleIVARecibidaType();
            detalle.setBaseImponible(base_3);
            detalle.setTipoImpositivo(tipo_3);
            detalle.setCuotaSoportada(cuota_3);
            desgloseIva.getDetalleIVA().add(detalle);
        }
        
        desglose.setDesgloseIVA(desgloseIva);
        dadesFactura.setDesgloseFactura(desglose);
        
        PersonaFisicaJuridicaType contraparte = new PersonaFisicaJuridicaType();
        contraparte.setNombreRazon(contraparteNombreRazon);
        if (this.idOtroCodigoPais.equals("ES")){
            contraparte.setNIF(nif);
        } else {
            IDOtroType idOtro = new IDOtroType();
            idOtro.setIDType(this.idOtroIdType);
            idOtro.setID(this.idOtroId);
            idOtro.setCodigoPais(CountryType2.valueOf(this.idOtroCodigoPais));
            contraparte.setIDOtro(idOtro);
            
        }
        
        dadesFactura.setContraparte(contraparte);
        
        factura.setFacturaRecibida(dadesFactura);
         
        return factura;
    }

    
    static public int procesaRespuesta(DataConnection dc, RespuestaLRFRecibidasType resposta) throws SQLException, ClassNotFoundException{
        
        int acum = 0;
        
        String csv = resposta.getCSV(); if (csv == null){csv = "";}
        DatosPresentacionType datosPresentacion = resposta.getDatosPresentacion();
            
        String nifPresentador = " ";
        String whenPresentada = " ";
        if (datosPresentacion != null){
            nifPresentador = resposta.getDatosPresentacion().getNIFPresentador(); if (nifPresentador == null){nifPresentador = "";}
            whenPresentada = resposta.getDatosPresentacion().getTimestampPresentacion();if (whenPresentada == null){whenPresentada = "";}
                
        }
        String titular = resposta.getCabecera().getTitular().getNombreRazon();if (titular == null){titular = "";}
        String nifTitular = resposta.getCabecera().getTitular().getNIF();if (nifTitular == null){nifTitular = "";}
        String tipoComunicacion = resposta.getCabecera().getTipoComunicacion().value();if (tipoComunicacion == null){tipoComunicacion = "";}
        String estado = resposta.getEstadoEnvio().value();if (estado == null){estado = "";}
            
            
        System.out.println("=================================================");
        System.out.println("CSV " + csv);
        System.out.println("Nif Presentador " + nifPresentador);
        System.out.println("presentada el " + whenPresentada);
        System.out.println("Titular " + nifTitular + "  " + titular);
        System.out.println("Tipo Comunicacion " + tipoComunicacion);
        System.out.println("Estado " + estado);
        System.out.println("-------------------------------------------------");
            
        // Llegim una id de la sequencia SII_ID_ENVIAMENTS
        
        BigDecimal id = dc.getNextVal("sii_id_enviament");
        
        // Inserim la capçalera
        
        dc.doUpdate("insert into SII_ENVIAMENTS (ENVIAMENT, DATA_ENVIAMENT, TIPUS, OPERACIO, RESULTAT, CSV, DATA_AEAT) VALUES (?, sysdate,  ?, ?, ?, ?, ?)", 
                new Object[]{id, "R", tipoComunicacion, estado, csv, whenPresentada});
        
            
            List<RespuestaRecibidaType> respuestasLinea = resposta.getRespuestaLinea();
            for(RespuestaRecibidaType rlinea : respuestasLinea){
                
                String csvLinea = rlinea.getCSV();if (csvLinea == null){csvLinea = "";};
                String estadoRegistro = rlinea.getEstadoRegistro().value();if (estadoRegistro == null){estadoRegistro = "";}
                String descripcionRegistro = rlinea.getDescripcionErrorRegistro();if (descripcionRegistro == null){descripcionRegistro = "";}
                String facturaRegistro = rlinea.getIDFactura().getNumSerieFacturaEmisor();if (facturaRegistro == null){facturaRegistro = "";}
                BigInteger errorRegistro = rlinea.getCodigoErrorRegistro();if (errorRegistro == null){errorRegistro = new BigInteger("-1");}
                String fechaEmision = rlinea.getIDFactura().getFechaExpedicionFacturaEmisor(); if (fechaEmision == null){fechaEmision = "01-01-2017";}
                
                String nif = rlinea.getIDFactura().getIDEmisorFactura().getNIF();
                
                if (nif != null && nif.length() > 0){
                    nif = "ES" + nif;
                } else {
                    nif = rlinea.getIDFactura().getIDEmisorFactura().getIDOtro().getID();
                }
               
                System.out.println("NIF :" + nif);
                
                
                // Extraccio dads factura
                
                String codigoPro = facturaRegistro;
                BigDecimal ejercicio = new BigDecimal(fechaEmision.substring(6));
                BigDecimal error = new BigDecimal(errorRegistro);
                
                BigDecimal codigo;
                
                if (nif.equals("ESB65817041")){
                    codigo = (BigDecimal) dc.lookupValue("select f.codigo from facturas_provee f "
                        + "where f.ref_prov = ? "
                        + "and trunc(f.fecha_emision) = to_date(?, 'DD-MM-YYYY') "
                        , new Object[]{codigoPro, fechaEmision});
                   
                } else {                
                    codigo = (BigDecimal) dc.lookupValue("select f.codigo from facturas_provee f, proveedores p "
                        + "where f.ref_prov = ? "
                        + "and trunc(f.fecha_emision) = to_date(?, 'DD-MM-YYYY') "
                        + "and p.codigo = f.proveedor "
                        + "and p.nif = ?", new Object[]{codigoPro, fechaEmision, nif});
                    
                }
                 
                //System.out.println("Error a la factura amb codi proveidor  " + ejercicio + "   " + codigoPro);
                
                dc.doUpdate("insert into SII_ENVIAMENTS_REBUDES (enviament, ejercicio, codigo_pro, resultat, csv, codi_error, descripcio_error, codigo, nif_proveidor) "
                        + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                         new Object[]{id, ejercicio, codigoPro, estadoRegistro, csvLinea, error, descripcionRegistro, codigo, nif});
                
                // factures_client te l'ultim registre de la factura.
                // Per si fem modificacions,
                //
                // Sempre hauria de ser un amb estat "CORRECTO" o IN CORRECTO però error registro = 3000. Document duplicat
                
                if (estadoRegistro.equals("Correcto") || error.equals(new BigDecimal(3000))){
                     dc.doUpdate("update facturas_provee set sii = ? where  codigo = ?",
                            new Object[]{id, codigo});
                }
                
                acum++;
                
                System.out.println("CSV linea " + csvLinea);
                System.out.println("Estado Registro " + estadoRegistro);
                System.out.println("Descripcion Registro" + descripcionRegistro);
                System.out.println("Factura Registro " + facturaRegistro);
                System.out.println("Error Registro " + errorRegistro.toString());
               
            }
            System.out.println("=================================================");
             
            return(acum);
     }  

    private static RespuestaLRFRecibidasType suministroLRFacturasRecibidas(https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrolr.SuministroLRFacturasRecibidas suministroLRFacturasRecibidas) {
        https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactrecibidas.SiiService service = new https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactrecibidas.SiiService();
        https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactrecibidas.SiiSOAP port = service.getSuministroFactRecibidas();
        --return port.suministroLRFacturasRecibidas(suministroLRFacturasRecibidas);
        return port.suministroLRFacturasRecibidas(cabecera, registroLRFacturasRecibidas, csv, datosPresentacion, estadoEnvio, respuestaLinea);
    }
 
    /**
     * private static RespuestaLRFRecibidasType suministroLRFacturasRecibidas(SuministroLRFacturasRecibidas suministroLRFacturasRecibidas) {
        SiiService service = new SiiService();
        SiiSOAP port = service.getSuministroFactRecibidasPruebas();
        return port.suministroLRFacturasRecibidas(suministroLRFacturasRecibidas);
    }

        */
    
    
}
