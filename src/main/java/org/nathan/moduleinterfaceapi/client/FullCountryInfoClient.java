package org.nathan.moduleinterfaceapi.client;

import jakarta.xml.ws.Service;
import org.nathan.moduleinterfaceapi.model.ArrayOftCountryInfo;
import org.nathan.moduleinterfaceapi.model.CountryInfoServiceSoapType;
import org.nathan.moduleinterfaceapi.model.TCountryInfo;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@org.springframework.stereotype.Service
public class FullCountryInfoClient extends WebServiceGatewaySupport {

    private static String URL_WSDL = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?wsdl";
    private static String URL_QNAME = "http://www.oorsprong.org/websamples.countryinfo";
    private static String NAME_SERVICE = "CountryInfoService";

    public TCountryInfo getCountryInfoByISO(String isoCode) throws MalformedURLException {
        return getInterface().fullCountryInfo(isoCode);
    }

    public ArrayOftCountryInfo getAllCountries() throws MalformedURLException {
        return getInterface().fullCountryInfoAllCountries();
    }

    private CountryInfoServiceSoapType getInterface() throws MalformedURLException {
        URL urlFullCountryInfo = new URL(URL_WSDL);
        QName qnameCountryInfo = new QName(URL_QNAME, NAME_SERVICE);
        Service service =Service.create(urlFullCountryInfo, qnameCountryInfo);
        return service.getPort(CountryInfoServiceSoapType.class);
    }
}
