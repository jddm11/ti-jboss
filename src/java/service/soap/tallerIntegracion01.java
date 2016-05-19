/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;

/**
 *
 * @author jddm11
 */
@WebService(serviceName = "tallerIntegracion01")
public class tallerIntegracion01 {

    /**
     * This is a sample web service operation
     * @return Array [cities,airports]
     */
    @WebMethod(operationName = "citiesAndAirports")
    public String[] citiesAndAirports(@WebParam(name = "country") String country) {
        GlobalWeather globalWs         = new GlobalWeather();
        GlobalWeatherSoap globalSoap = globalWs.getGlobalWeatherSoap();
        Airport airportWs       = new Airport();
        AirportSoap airportSoap = airportWs.getAirportSoap();
        String[] result = new String[2];
        result[0] = globalSoap.getCitiesByCountry(country);
        result[1] = airportSoap.getAirportInformationByCountry(country);
        return result;
    }
}
