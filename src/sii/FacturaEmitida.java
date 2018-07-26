/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii;

import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.respuestasuministro.RespuestaExpedidaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.respuestasuministro.RespuestaLRFEmitidasType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.CabeceraSii;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.CausaExencionType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.ClaveTipoComunicacionType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.ClaveTipoFacturaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.DatosPresentacionType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.FacturaExpedidaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.FacturaExpedidaType.TipoDesglose;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.IDFacturaExpedidaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.IDFacturaExpedidaType.IDEmisorFactura;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.IDOtroType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.PersonaFisicaJuridicaESType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.PersonaFisicaJuridicaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.RegistroSii.PeriodoImpositivo;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.SujetaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.SujetaType.Exenta;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.TipoConDesgloseType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.TipoSinDesgloseType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrolr.LRfacturasEmitidasType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrolr.SuministroLRFacturasEmitidas;
import java.math.BigInteger;

import java.util.List;
import es.gorina.sqlobjects.*;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.respuestasuministro.RespuestaLRFRecibidasType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.CountryType2;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.DetalleIVAEmitidaType;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.SujetaType.NoExenta;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.SujetaType.NoExenta.DesgloseIVA;
import https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministroinformacion.TipoOperacionSujetaNoExentaType;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;


/**
 *
 * @author paco
 */

public class FacturaEmitida {
    String ejercicio;
    String periodoEj;
    String idEmisorFactura;
    String numSerieFacturaEmisor;
    String fechaExpFacturaEmisor;
    String tipoFactura;
    String claveRegEspoTrascendencia;
    String importeTotal;
    String descripcionOperacion;
    String contraparteNombreRazon;
    String nif;
    String idOtroCodigoPais;
    String idOtroIdType;
    String idOtroId;
    String noExentaTipoNoExenta;
    String causaExencion;
    String tipoImpositivo;
    String baseImponible;
    String cuotaRepercutida;
    String tipoRecargoEquivalencia;
    String cuotaRecargoEquivalencia;
    String tipoFra;
    Date fecha;
    String serie;
    BigDecimal codigo;
    BigDecimal eqv;
    
    /**
     * Retorna una factua emitida descarregant-la de la base de dades
     * 
     * @param dc es la DataConnection a la base de dades
     * @param factura   es el codi de factura de la forma 'Snnnnn' a on S es la serie (A o B) i nnnnn es el numero
     * @return 
     */  
    static public FacturaEmitida getFacturaEmitida (DataConnection dc, String factura) throws SQLException, ClassNotFoundException{
        
        Vector<Object[]>result = dc.lookupOne("select EJERCICIO, PERIODO, IDEMISORFACTURA, NUMSERIEFACTURAEMISOR, FECHAEXPFACTURAEMISOR, TIPOFACTURA, \n" +
            "CLAVEREGESPOTRASCENDENCIA, IMPORTETOTAL, DESCRIPCIONOPERACION, CONTRAPARTENOMBRERAZON, NIF, \n" +
            "IDOTROCODIGOPAIS, IDOTROIDTYPE, IDOTROID, NOEXENTATIPONOEXENTA, CAUSAEXENCION, TIPOIMPOSITIVO, \n" +
            "BASEIMPONIBLE, CUOTAREPERCUTIDA, TIPORECARGOEQUIVALENCIA, CUOTARECARGOEQUIVALENCIA, TIPOFRA, FECHA, SERIE, CODIGO, EQV "
                + "FROM FACTURES_EMESES_SII "
                + "WHERE NUMSERIEFCTURAEMISOR = ? ",
                new Object[]{factura});
        
        if (result.size() == 1){    // SOLO PUEDE QUEDAR UNA
            Object[] datos = result.firstElement();
            return new FacturaEmitida(datos);
        }
        
        return null;
    }
    
    /**
     * Genera i envia el fitxer a la AEAT
     * 
     * @param facturas 
     */
    static public RespuestaLRFEmitidasType sendFacturas(Vector<Object[]> facturas, PersonaFisicaJuridicaESType jo){
        
        // Construcció de les dades
        if (facturas.size() == 0){
            return null;
        }
 
        CabeceraSii cabecera = new CabeceraSii();
        cabecera.setIDVersionSii("1.0");
        cabecera.setTipoComunicacion(ClaveTipoComunicacionType.A_0);
        cabecera.setTitular(jo);
        
        SuministroLRFacturasEmitidas suministro = new SuministroLRFacturasEmitidas();
        
        suministro.setCabecera(cabecera);
        
        for (int i = 0; i < facturas.size(); i++){
            Object[] datos = facturas.elementAt(i);
            FacturaEmitida factura = new FacturaEmitida(datos);
            suministro.getRegistroLRFacturasEmitidas().add(factura.getLRFactura());
        }
         
        // Enviament a la AEAT
        RespuestaLRFEmitidasType resposta;    
        
   
        resposta = suministroLRFacturasEmitidas(suministro);
        return resposta;
    
    }
    
    static public int procesaRespuesta(DataConnection dc, RespuestaLRFEmitidasType resposta) throws SQLException, ClassNotFoundException{
        
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
                new Object[]{id, "E", tipoComunicacion, estado, csv, whenPresentada});
        
            
            List<RespuestaExpedidaType> respuestasLinea = resposta.getRespuestaLinea();
            for(RespuestaExpedidaType rlinea : respuestasLinea){
                
                String csvLinea = rlinea.getCSV();if (csvLinea == null){csvLinea = "";};
                String estadoRegistro = rlinea.getEstadoRegistro().value();if (estadoRegistro == null){estadoRegistro = "";}
                String descripcionRegistro = rlinea.getDescripcionErrorRegistro();if (descripcionRegistro == null){descripcionRegistro = "";}
                String facturaRegistro = rlinea.getIDFactura().getNumSerieFacturaEmisor();if (facturaRegistro == null){facturaRegistro = "";}
                BigInteger errorRegistro = rlinea.getCodigoErrorRegistro();if (errorRegistro == null){errorRegistro = new BigInteger("-1");}
                String fechaEmision = rlinea.getIDFactura().getFechaExpedicionFacturaEmisor(); if (fechaEmision == null){fechaEmision = "01-01-2017";}
                
                // Extraccio dads factura
                
                String serie = facturaRegistro.substring(0, 1);
                BigDecimal codigo = new BigDecimal(facturaRegistro.substring(1));
                BigDecimal ejercicio = new BigDecimal(fechaEmision.substring(6));
                BigDecimal error = new BigDecimal(errorRegistro);
                
                dc.doUpdate("insert into SII_ENVIAMENTS_EMESES (enviament, ejercicio, serie, codigo, resultat, csv, codi_error, descripcio_error) "
                        + "values (?, ?, ?, ?, ?, ?, ?, ?)",
                        
                        new Object[]{id, ejercicio, serie, codigo, estadoRegistro, csvLinea, error, descripcionRegistro});
                
                // factures_client te l'ultim registre de la factura.
                // Per si fem modificacions,
                //
                // Sempre hauria de ser un amb estat "CORRECTO"
                
                if (estadoRegistro.equals("Correcto")){
                
                    dc.doUpdate("update facturas_client set sii = ? where ejercicio = ? and serie = ? and codigo = ?",
                        new Object[]{id, ejercicio, serie, codigo});
                
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
    
    static public int procesaFacturesPendentsFinsAl(DataConnection dc, String when) throws SQLException, ClassNotFoundException{
        
        Vector<Object[]> factures = dc.lookup("select EJERCICIO, PERIODO, IDEMISORFACTURA, NUMSERIEFACTURAEMISOR, FECHAEXPFACTURAEMISOR, TIPOFACTURA, \n" +
            "CLAVEREGESPOTRASCENDENCIA, IMPORTETOTAL, DESCRIPCIONOPERACION, CONTRAPARTENOMBRERAZON, NIF, \n" +
            "IDOTROCODIGOPAIS, IDOTROIDTYPE, IDOTROID, NOEXENTATIPONOEXENTA, CAUSAEXENCION, TIPOIMPOSITIVO, \n" +
            "BASEIMPONIBLE, CUOTAREPERCUTIDA, TIPORECARGOEQUIVALENCIA, CUOTARECARGOEQUIVALENCIA, TIPOFRA, FECHA, SERIE, CODIGO, EQV "
                + "FROM FACTURES_EMESES_SII "
                + "WHERE FECHA <= to_date(?, 'DD/MM/YY') and SII is null and fecha >= to_date('01/07/17', 'DD/MM/YY') ", 
               new Object[]{when});
        
        PersonaFisicaJuridicaESType jo = new PersonaFisicaJuridicaESType();
        jo.setNIF("B65817041");
        jo.setNombreRazon("EVERCLOTH S.L.");

        
        RespuestaLRFEmitidasType resposta = sendFacturas(factures, jo);
        
        if (resposta != null){
            return procesaRespuesta(dc, resposta);
        }
        
        return 0;
     }
    
    /**
     * FacturaEmitida reb un array d'objectes de la base de dades i es guarda als seus camps respectius
     * @param datos 
     */
    public FacturaEmitida(Object[] datos){
        
        int i = 0;
        
        ejercicio = (String) datos[i++];
        periodoEj = (String) datos[i++];
        idEmisorFactura = (String) datos[i++];
        numSerieFacturaEmisor = (String) datos[i++];
        fechaExpFacturaEmisor = (String) datos[i++];
        tipoFactura = (String) datos[i++];
        claveRegEspoTrascendencia = (String) datos[i++];
        importeTotal = (String) datos[i++];
        descripcionOperacion = (String) datos[i++];
        contraparteNombreRazon = (String) datos[i++];
        nif = (String) datos[i++];
        idOtroCodigoPais = (String) datos[i++];
        idOtroIdType = (String) datos[i++];
        idOtroId = (String) datos[i++];
        noExentaTipoNoExenta = (String) datos[i++];
        causaExencion = (String) datos[i++];
        tipoImpositivo = (String) datos[i++];
        baseImponible = (String) datos[i++];
        cuotaRepercutida = (String) datos[i++];
        tipoRecargoEquivalencia = (String) datos[i++];
        cuotaRecargoEquivalencia = (String) datos[i++];
        tipoFra = (String) datos[i++];
        fecha = new Date(((Timestamp)datos[i++]).getTime());
        serie = (String) datos[i++];
        codigo = (BigDecimal) datos[i++];
        eqv = (BigDecimal)datos[i++];

      }
    
    
    // Retorna un registre per el llibre de factures emeses.
    // Fa el switch entre les factures nacionals amb desglose de IVA
    // i les intracomunitaries i de exportació sense desglose de IVA i tan sols
    // informació de l'operació
    //
    // A mes a mes canvia la forma de la contraparte de NIF a Num IVA
    //
    // Els tipus i dades es treuen de la view amb lo que podem canviar-los per la view
    // i el mateix codi ens serveix per les factures de esportació i les intracomunitaries
    
    public LRfacturasEmitidasType getLRFactura(){
            
        IDEmisorFactura emisor = new IDEmisorFactura();
        emisor.setNIF(this.idEmisorFactura);

        if (tipoFra.equals("1")){   // Factura espanyola
            return getLRfacturaNacional(emisor);
        } else {
            return getLRfacturaExport(emisor);
        }
         
    }
    public LRfacturasEmitidasType getLRfacturaNacional(IDEmisorFactura emisor){
        
          
        LRfacturasEmitidasType factura = new LRfacturasEmitidasType();
        
        PeriodoImpositivo periodo = new PeriodoImpositivo();
        periodo.setEjercicio(ejercicio);
        periodo.setPeriodo(periodoEj);
          
        IDFacturaExpedidaType idFactura = new IDFacturaExpedidaType();
        idFactura.setIDEmisorFactura(emisor);
        idFactura.setFechaExpedicionFacturaEmisor(fechaExpFacturaEmisor);
        idFactura.setNumSerieFacturaEmisor(numSerieFacturaEmisor);
        
        FacturaExpedidaType dadesFactura = new FacturaExpedidaType();
        dadesFactura.setTipoFactura(ClaveTipoFacturaType.fromValue(tipoFactura));
        dadesFactura.setClaveRegimenEspecialOTrascendencia(claveRegEspoTrascendencia);
        dadesFactura.setImporteTotal(importeTotal);
        dadesFactura.setDescripcionOperacion(descripcionOperacion);
        
        if (!tipoFactura.equals("F2")){
            PersonaFisicaJuridicaType cliente = new PersonaFisicaJuridicaType();
            cliente.setNombreRazon(contraparteNombreRazon);
            cliente.setNIF(nif);
             dadesFactura.setContraparte(cliente);
        }
            
        
        TipoDesglose tipo = new TipoDesglose();
          
        NoExenta noexenta = new NoExenta();
        noexenta.setTipoNoExenta(TipoOperacionSujetaNoExentaType.fromValue(noExentaTipoNoExenta));
        
        DetalleIVAEmitidaType detalleiva = new DetalleIVAEmitidaType();
        detalleiva.setBaseImponible(baseImponible);
        detalleiva.setTipoImpositivo(tipoImpositivo);
        detalleiva.setCuotaRepercutida(cuotaRepercutida);
        
        if (eqv.intValue() != 0){
            detalleiva.setTipoRecargoEquivalencia(tipoRecargoEquivalencia);
            detalleiva.setCuotaRecargoEquivalencia(cuotaRecargoEquivalencia);
         }
        
        
        DesgloseIVA desgloseiva = new DesgloseIVA();
        desgloseiva.getDetalleIVA().add(detalleiva);
        
        noexenta.setDesgloseIVA(desgloseiva);
           
        SujetaType sujeta = new SujetaType();
        sujeta.setNoExenta(noexenta);
          
        TipoSinDesgloseType entrega = new TipoSinDesgloseType();
        entrega.setSujeta(sujeta);
        
        TipoConDesgloseType tipoConDesglose = new TipoConDesgloseType();
        tipoConDesglose.setEntrega(entrega);
        
        tipo.setDesgloseTipoOperacion(tipoConDesglose);
        dadesFactura.setTipoDesglose(tipo);
          
        factura.setPeriodoImpositivo(periodo);
        factura.setIDFactura(idFactura);
        factura.setFacturaExpedida(dadesFactura);
        
        return factura;
    }
   
    
    
    public LRfacturasEmitidasType getLRfacturaExport(IDEmisorFactura emisor){
        
          
        LRfacturasEmitidasType factura = new LRfacturasEmitidasType();
        
        PeriodoImpositivo periodo = new PeriodoImpositivo();
        periodo.setEjercicio(this.ejercicio);
        periodo.setPeriodo(this.periodoEj);
        
       
        PersonaFisicaJuridicaType cliente = new PersonaFisicaJuridicaType();
        IDOtroType idOtro = new IDOtroType();
        idOtro.setIDType(this.idOtroIdType);
        idOtro.setID(this.idOtroId);
        idOtro.setCodigoPais(CountryType2.valueOf(this.idOtroCodigoPais));
        
        cliente.setNombreRazon(this.contraparteNombreRazon);
        cliente.setIDOtro(idOtro);
        
        
        
        IDFacturaExpedidaType idFactura = new IDFacturaExpedidaType();
        idFactura.setIDEmisorFactura(emisor);
        idFactura.setFechaExpedicionFacturaEmisor(this.fechaExpFacturaEmisor);
        idFactura.setNumSerieFacturaEmisor(this.numSerieFacturaEmisor);
        
        FacturaExpedidaType dadesFactura = new FacturaExpedidaType();
        dadesFactura.setTipoFactura(ClaveTipoFacturaType.fromValue(this.tipoFactura));
        dadesFactura.setClaveRegimenEspecialOTrascendencia(this.claveRegEspoTrascendencia);
        dadesFactura.setImporteTotal(this.importeTotal);
        dadesFactura.setDescripcionOperacion(this.descripcionOperacion);
        
        dadesFactura.setContraparte(cliente);
            
        
        TipoDesglose tipo = new TipoDesglose();
          
        Exenta exenta = new Exenta();
        exenta.setCausaExencion(CausaExencionType.fromValue(this.causaExencion));
        exenta.setBaseImponible(this.baseImponible);
        
        SujetaType sujeta = new SujetaType();
        sujeta.setExenta(exenta);
        
        TipoSinDesgloseType entrega = new TipoSinDesgloseType();
        entrega.setSujeta(sujeta);
        
        TipoConDesgloseType tipoConDesglose = new TipoConDesgloseType();
        tipoConDesglose.setEntrega(entrega);
        
        tipo.setDesgloseTipoOperacion(tipoConDesglose);
        dadesFactura.setTipoDesglose(tipo);
          
        factura.setPeriodoImpositivo(periodo);
        factura.setIDFactura(idFactura);
        factura.setFacturaExpedida(dadesFactura);
        
        return factura;
    }

    // OJO BUENA
 
    private static RespuestaLRFEmitidasType suministroLRFacturasEmitidas(https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrolr.SuministroLRFacturasEmitidas suministroLRFacturasEmitidas) {
        https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactemitidas.SiiService service = new https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactemitidas.SiiService();
        https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactemitidas.SiiSOAP port = service.getSuministroFactEmitidas();
        
         
        return port.suministroLRFacturasEmitidas(suministroLRFacturasEmitidas);
    }
    
    /**
     * Envia i retorna la resposta de la AEAT 
     * 
     * @param suministroLRFacturasEmitidas
     * @return 
     
    private static RespuestaLRFEmitidasType suministroLRFacturasEmitidas(SuministroLRFacturasEmitidas suministroLRFacturasEmitidas) {
        https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactemitidas.SiiService service = new https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactemitidas.SiiService();
        https.www2_agenciatributaria_gob_es.static_files.common.internet.dep.aplicaciones.es.aeat.ssii.fact.ws.suministrofactemitidas.SiiSOAP port = service.getSuministroFactEmitidasPruebas();
        return port.suministroLRFacturasEmitidas(suministroLRFacturasEmitidas);
    }
    * */


    
}
