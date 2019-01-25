package com.step_definitions.api;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.DatatypeConverter;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.common.helpers.BrowserHelper;
import com.common.helpers.DatabaseHelper;
import com.common.helpers.ReporterHelper;
import com.common.helpers.Utils;
import com.step_definitions.optimus.Optimus_Hooks;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Api_StepDefinitions {


	private ReporterHelper reporterHelper = Optimus_Hooks.reporterHelper;
	private BrowserHelper browserHelper = Optimus_Hooks.browserHelper;
	private DatabaseHelper databaseHelper = Optimus_Hooks.databaseHelper;
	
	private static String kssToken;

	private URL obj;
	private HttpURLConnection con; 
	
	private String adminUsername;
	private String adminPassword;

	private StringBuffer response;
	private int responseCode;
	private String kssTokenToUse;
	private boolean useKssToken;
	private JSONArray jsonArray;
	
	@When("^valid credentials are used$")
	public void validCredentialsAreUsed() {
		
        adminUsername = Utils.getProperty("DEFAULT_ADMINISTRATOR_USERNAME");
        adminPassword = Utils.getProperty("DEFAULT_PASSWORD");
        
	}
	
	@When("^invalid credentials are used$")
	public void invalidCredentialsAreUsed() {
		
        adminUsername = Utils.getProperty("DEFAULT_ADMINISTRATOR_USERNAME");
        adminPassword = "INCORRECT";
        
	}	


	@When("^a '(.*)' request is sent to '(.*)'$")
	public void aRequestIsSent(String requestType, String endpointIdentifier) {
	    // Write code here that turns the phrase above into concrete actions
        
		String applicationURL = Utils.getProperty(Optimus_Hooks.applicationName + "_URL");
		
		String endPointUrl = "";
		String authStringEncoded = "";
		String params = "";
		
    	switch(endpointIdentifier) {
    	case "GetUserSettings":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/useraccount/api/AccessControl/GetUserSettings";
			break;
    	case "GetAllUsers":
            authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + kssToken).getBytes());
    		endPointUrl = "/useraccount/api/AccessControl/GetAllUsers";
			break;
			
    	case "GetAllUserSettings":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/useraccount/api/AccessControl/GetAllUserSettings";
			break;
    	case "GetAllProfiles":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/useraccount/api/AccessControl/GetAllProfiles";
			break;
       	case "GetWorkspaceUsers":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/useraccount/api/AccessControl/GetWorkspaceUsers";
			break;
     	case "GetAllPrimaryRoles":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/useraccount/api/AccessControl/GetAllPrimaryRoles";
			break;
    	case "GetEmptyMultiUser":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/useraccount/api/AccessControl/GetEmptyMultiUser";
			break;
    	case "GetUserFilterTypes":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/useraccount/api/AccessControl/GetUserFilterTypes";
			break;
    	case "VerifyWindowsUser":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/useraccount/api/AccessControl/VerifyWindowsUser";
			break;
    	case "AcknowledgeLogin":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/useraccount/api/AccessControl/AcknowledgeLogin";
			break;
    	case "SaveWidgetData":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/WebApi/api/Workspace/SaveWidgetData";
    		params = "workspaceId=111 HTTP/1.1";
			break;
    	default:
	        reporterHelper.customFailScript("Unknown endpointIdentifier in method aRequestIsSent: " + endpointIdentifier);
		}
			
		String url = applicationURL + endPointUrl;
		
		reporterHelper.log("\nURL: " + url);
		
		try {
			
			obj = new URL(url);
			
            if (obj.getProtocol().toLowerCase().equals("https")) {
                trustAllHosts();
                HttpsURLConnection https = (HttpsURLConnection) obj.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                con = https;
            } else {
                con = (HttpURLConnection) obj.openConnection();
            }
            
			// set request method
			con.setRequestMethod(requestType);

            con.setDoInput(true);
            con.setDoOutput(true);

            reporterHelper.log("adminUsername: " + adminUsername);
            reporterHelper.log("adminPassword: " + adminPassword);
            
			//add request headers
            con.setRequestProperty("Accept","application/json, text/plain, */*");
            con.setRequestProperty("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8");
            con.setRequestProperty("Authorization","Basic " + authStringEncoded);
            con.setRequestProperty("Connection","keep-alive");
            con.setRequestProperty("Cookie","_hjIncludedInSample=1");
            con.setRequestProperty("Referer", applicationURL);
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

    		reporterHelper.log("\nSending '" + requestType + "requestMethod' request to: " + url);

			responseCode = con.getResponseCode();
			
		} catch (Exception e) {
			reporterHelper.log("Exception caught:" + e.toString());
			e.printStackTrace();
		}
		
	}	
	

//	@When("^a pen test '(.*)' request is sent to '(.*)'$")
	@When("^'(pen test .*)' '(.*)' request is sent to '(.*)'$")
	public void aPenTestRequestIsSent(String testType, String requestType, String endpointIdentifier) {
	    // Write code here that turns the phrase above into concrete actions
        
		String applicationURL = Utils.getProperty(Optimus_Hooks.applicationName + "_URL");
		
		String endPointUrl = "";
		String authStringEncoded = "";
		String params = "";
		String payloadString = "";
		String payloadSize = "";
		
		switch(testType) {
			case "pen test 1":
				payloadString = "[{\"id\":\"NSho31sa33eNO80493969' or '5756'='5756\",\"index\":1,\"parent\":\"container2\",\"obj\":\"market-pricing-widget\",\"colour\":\"colour-B\",\"title\":\"Market Pricing\",\"height\":3,\"data\":\"{\\\"searchData\\\":{\\\"queryId\\\":1,\\\"expressionString\\\":\\\"\\\",\\\"subSelectionQry\\\":\\\"\\\",\\\"basicSearch\\\":\\\"\\\",\\\"currentFilters\\\":[],\\\"lastBasicExpressionString\\\":\\\"\\\",\\\"showOwnSites\\\":true,\\\"showCompSites\\\":false,\\\"showLxSites\\\":false,\\\"showDealerTradeAreas\\\":false,\\\"disableBasicTab\\\":false,\\\"haveSFRFilter\\\":false,\\\"tabs\\\":{\\\"0\\\":{\\\"active\\\":false},\\\"2\\\":{\\\"active\\\":true},\\\"3\\\":{\\\"active\\\":false}},\\\"fresh\\\":true,\\\"includeLeadFollow\\\":true,\\\"groups\\\":[]},\\\"searchTypeId\\\":2,\\\"searchType\\\":\\\"Search_OwnSites\\\",\\\"selectedIds\\\":[6,4,5,8,7],\\\"nolink\\\":true,\\\"hasParent\\\":false,\\\"universityOpen\\\":\\\"market-pricing-widget\\\"}\",\"link\":null,\"collapsed\":false,\"deleted\":false,\"disableEdit\":false,\"uaPage\":\"market-pricing-widget\",\"subTitle\":\"\"}]";
				break;
			case "pen test 2":
				payloadString = "[{\"id\":\"NSho31sa33eNO\",\"index\":1,\"parent\":\"container216926803' or '4935'='4935\",\"obj\":\"market-pricing-widget\",\"colour\":\"colour-B\",\"title\":\"Market Pricing\",\"height\":3,\"data\":\"{\\\"searchData\\\":{\\\"queryId\\\":1,\\\"expressionString\\\":\\\"\\\",\\\"subSelectionQry\\\":\\\"\\\",\\\"basicSearch\\\":\\\"\\\",\\\"currentFilters\\\":[],\\\"lastBasicExpressionString\\\":\\\"\\\",\\\"showOwnSites\\\":true,\\\"showCompSites\\\":false,\\\"showLxSites\\\":false,\\\"showDealerTradeAreas\\\":false,\\\"disableBasicTab\\\":false,\\\"haveSFRFilter\\\":false,\\\"tabs\\\":{\\\"0\\\":{\\\"active\\\":false},\\\"2\\\":{\\\"active\\\":true},\\\"3\\\":{\\\"active\\\":false}},\\\"fresh\\\":true,\\\"includeLeadFollow\\\":true,\\\"groups\\\":[]},\\\"searchTypeId\\\":2,\\\"searchType\\\":\\\"Search_OwnSites\\\",\\\"selectedIds\\\":[6,4,5,8,7],\\\"nolink\\\":true,\\\"hasParent\\\":false,\\\"universityOpen\\\":\\\"market-pricing-widget\\\"}\",\"link\":null,\"collapsed\":false,\"deleted\":false,\"disableEdit\":false,\"uaPage\":\"market-pricing-widget\",\"subTitle\":\"\"}]";
				break;
			case "pen test 3":
				payloadString = "";
				break;
	    	default:
		        reporterHelper.customFailScript("Unknown testType in method aPenTestRequestIsSent: " + testType);
		}
		
		payloadSize = Integer.toString(payloadString.length());

		switch(endpointIdentifier) {

    	case "SaveWidgetData":
    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "/WebApi/api/Workspace/SaveWidgetData";
//    		params = "workspaceId=111 HTTP/1.1";
    		params = "workspaceId=111";
    		break;
    	default:
	        reporterHelper.customFailScript("Unknown endpointIdentifier in method aRequestIsSent: " + endpointIdentifier);
		}
			
		String url = applicationURL + endPointUrl + "?" + params;
		
		reporterHelper.log("\nURL: " + url);
		
		try {
			obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection(); 

			// set request method
			con.setRequestMethod(requestType);

            con.setDoInput(true);
            con.setDoOutput(true);

            reporterHelper.log("adminUsername: " + adminUsername);
            reporterHelper.log("adminPassword: " + adminPassword);
            reporterHelper.log("payloadString: " + payloadString);            
            
			//add request headers
            con.setRequestProperty("Authorization","Basic " + authStringEncoded);
            con.setRequestProperty("Accept","application/json, text/plain, */*");
            con.setRequestProperty("locale","en-US");
            con.setRequestProperty("Content-Type","application/json;charset=utf-8");
            con.setRequestProperty("Referer", applicationURL);
//            Accept-Language: en-US
            con.setRequestProperty("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8");
//            Accept-Encoding: gzip, deflate
//            User-Agent: Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; WOW64; Trident/6.0)
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
//            Host: bit04-az.cloud.kalibrate.com
//            Content-Length: 879

            reporterHelper.log("Setting Content-Length to: " + payloadSize);
            con.setRequestProperty("Content-Length", payloadSize);
            
            con.setRequestProperty("DNT","1");
            con.setRequestProperty("Connection","close");
//            con.setRequestProperty("Cache-Control","no-cache");
//            Cookie: ASP.NET_SessionId=ayxrly4iaxbhzqmseh4cgkpp; PriceNetWeb=5ADEEA39560F16744791B100A8E97B5084CCF1797A62CD0FDCD7D6A2B5AF332BCB8CE90CB9C29842A11BC901A4ED61FC1511D72B48D923B4C90916DCEE5330675D6C35671E6B189BA07F7E8B88211256D39868748495BCA26CB7B430C80080CC5C49B6DE92DC00D670D96713ADCA1BBEBC961FFDE813C152CA160B4AA0223971A1A826B94380FBCDB5B9F6607C65478F; PriceNet=53CC422C7D75760E98AEAC745A51B13C8433030ACEC613D5204EB2269460B497012D1A0116227FB24E1D40D999AC52D2CA77EE9AAA8F38209572E466948450322282414E858720E71C946EB4ABEA7B369751ED57B677F2BB7D91640533E7CACAD98562103D52C7395F7D7325628CD591A2CE85AFE9FBE0704484E14DCFFE0F34735380235123A252AFB093D3656E3848; _ga=GA1.2.585712256.1524707551; _gid=GA1.2.346823594.1524824688            
//            con.setRequestProperty("Cookie","_hjIncludedInSample=1");
            
            con.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            writer.write(payloadString);
            writer.close();

    		reporterHelper.log("\nSending '" + requestType + "requestMethod' request to: " + url);

			responseCode = con.getResponseCode();
			
		} catch (Exception e) {
			reporterHelper.log("Exception caught:" + e.toString());
			e.printStackTrace();
		}
		
	}

//	@When("^a pen test '(.*)' request is sent to '(.*)'$")
	@When("^new '(.*)' '(.*)' request is sent to '(.*)'$")
	public void aNewPenTestRequestIsSent(String testType, String requestType, String endpointIdentifier) {
	    // Write code here that turns the phrase above into concrete actions
        
		String applicationURL = Utils.getProperty(Optimus_Hooks.applicationName + "_URL");
		
		String endPointUrl = "";
		String authStringEncoded = "";
		String params = "";
		String payloadString = "";
		String payloadSize = "";
		
		switch(testType) {
			case "pen test 1":
				payloadString = "[{\"id\":\"NSho31sa33eNO80493969' or '5756'='5756\",\"index\":1,\"parent\":\"container2\",\"obj\":\"market-pricing-widget\",\"colour\":\"colour-B\",\"title\":\"Market Pricing\",\"height\":3,\"data\":\"{\\\"searchData\\\":{\\\"queryId\\\":1,\\\"expressionString\\\":\\\"\\\",\\\"subSelectionQry\\\":\\\"\\\",\\\"basicSearch\\\":\\\"\\\",\\\"currentFilters\\\":[],\\\"lastBasicExpressionString\\\":\\\"\\\",\\\"showOwnSites\\\":true,\\\"showCompSites\\\":false,\\\"showLxSites\\\":false,\\\"showDealerTradeAreas\\\":false,\\\"disableBasicTab\\\":false,\\\"haveSFRFilter\\\":false,\\\"tabs\\\":{\\\"0\\\":{\\\"active\\\":false},\\\"2\\\":{\\\"active\\\":true},\\\"3\\\":{\\\"active\\\":false}},\\\"fresh\\\":true,\\\"includeLeadFollow\\\":true,\\\"groups\\\":[]},\\\"searchTypeId\\\":2,\\\"searchType\\\":\\\"Search_OwnSites\\\",\\\"selectedIds\\\":[6,4,5,8,7],\\\"nolink\\\":true,\\\"hasParent\\\":false,\\\"universityOpen\\\":\\\"market-pricing-widget\\\"}\",\"link\":null,\"collapsed\":false,\"deleted\":false,\"disableEdit\":false,\"uaPage\":\"market-pricing-widget\",\"subTitle\":\"\"}]";
				break;
			case "pen test 2":
				payloadString = "[{\"id\":\"NSho31sa33eNO\",\"index\":1,\"parent\":\"container216926803' or '4935'='4935\",\"obj\":\"market-pricing-widget\",\"colour\":\"colour-B\",\"title\":\"Market Pricing\",\"height\":3,\"data\":\"{\\\"searchData\\\":{\\\"queryId\\\":1,\\\"expressionString\\\":\\\"\\\",\\\"subSelectionQry\\\":\\\"\\\",\\\"basicSearch\\\":\\\"\\\",\\\"currentFilters\\\":[],\\\"lastBasicExpressionString\\\":\\\"\\\",\\\"showOwnSites\\\":true,\\\"showCompSites\\\":false,\\\"showLxSites\\\":false,\\\"showDealerTradeAreas\\\":false,\\\"disableBasicTab\\\":false,\\\"haveSFRFilter\\\":false,\\\"tabs\\\":{\\\"0\\\":{\\\"active\\\":false},\\\"2\\\":{\\\"active\\\":true},\\\"3\\\":{\\\"active\\\":false}},\\\"fresh\\\":true,\\\"includeLeadFollow\\\":true,\\\"groups\\\":[]},\\\"searchTypeId\\\":2,\\\"searchType\\\":\\\"Search_OwnSites\\\",\\\"selectedIds\\\":[6,4,5,8,7],\\\"nolink\\\":true,\\\"hasParent\\\":false,\\\"universityOpen\\\":\\\"market-pricing-widget\\\"}\",\"link\":null,\"collapsed\":false,\"deleted\":false,\"disableEdit\":false,\"uaPage\":\"market-pricing-widget\",\"subTitle\":\"\"}]";
				break;
			case "pen test 3":
				payloadString = "";
				break;
			case "search07a":
				payloadString = "<soap:Envelope\n" + 
						"    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" + 
						"    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" + 
						"    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" + 
						"    <soap:Header>\n" + 
						"        <callcreditheaders\n" + 
						"            xmlns=\"urn:callcredit.co.uk/soap:callreport7\">\n" + 
						"            <company>Optimus CR CTest</company>\n" + 
						"            <username>Optimus CR API CTest</username>\n" + 
						"            <password>password123</password>\n" + 
						"        </callcreditheaders>\n" + 
						"    </soap:Header>\n" + 
						"    <soap:Body>\n" + 
						"        <Search07a\n" + 
						"            xmlns=\"urn:callcredit.co.uk/soap:callreport7\">\n" + 
						"            <SearchDefinition>\n" + 
						"                <creditrequest schemaversion=\"7.1\" datasets=\"511\"\n" + 
						"                    xmlns=\"urn:callcredit.co.uk/soap:callreport7\">\n" + 
						"                    <idoutput>1</idoutput>\n" + 
						"                    <logscore>1</logscore>\n" + 
						"                    <applicant>\n" + 
						"                        <address>\n" + 
						"                            <buildingno></buildingno>\n" + 
						"                            <postcode>X9 9AB</postcode>\n" + 
						"                        </address>\n" + 
						"                        <name>\n" + 
						"                            <forename>HARRY</forename>\n" + 
						"                            <surname>HAIRPIN</surname>\n" + 
						"                        </name>\n" + 
						"                        <dob>1950-10-13</dob>\n" + 
						"                    </applicant>\n" + 
						"                    <score>1</score>\n" + 
						"                    <purpose>CL</purpose>\n" + 
						"                </creditrequest>\n" + 
						"            </SearchDefinition>\n" + 
						"        </Search07a>\n" + 
						"    </soap:Body>\n" + 
						"</soap:Envelope>";
				break;
				
			case "numero create dispute":
				payloadString = "<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\">" + 
						"  <s:Header>" + 
						"    <Action s:mustUnderstand=\"1\" xmlns=\"http://schemas.microsoft.com/ws/2005/05/addressing/none\">http://tempuri.org/createCases</Action>" + 
						"  </s:Header>" + 
						"  <s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">" + 
						"    <createCases xmlns=\"http://tempuri.org/\">" + 
						"      <casesInfo>" + 
						"        <BizAgiWSParam xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"\">" + 
						"          <domain>******</domain>" + 
						"          <userName>******</userName>" + 
						"          <Cases>" + 
						"            <Case>" + 
						"              <Process>Disputes</Process>" + 
						"              <Entities>" + 
						"                <CallCredit>" + 
						"                  <Dispute>" + 
						"                    <IsAutomatic>1</IsAutomatic>" + 
						"                    <DateReceived>2018-09-29</DateReceived>" + 
						"                    <DisputeId>999499805</DisputeId>" + 
						"                    <CCCDisputeType>508</CCCDisputeType>" + 
						"                    <CCCAffiliateID>501</CCCAffiliateID>" + 
						"                    <ConsumerRequest>Dispute detail data: INSOLVENCYORDERId: 1712867" + 
						"COURTNAME: TESTTOWN" + 
						"CURRENTSTATUS: D" + 
						"ORDERTYPE: BO" + 
						"ORDERDATE: 05/05/2012 00:00:00" + 
						"CASEYEAR: 2005" + 
						"CASEREF: 410031" + 
						"NAME: MRS JESSICA TWIX" + 
						"ADDRESS: 63 THE RIDGE SK6 7ER" + 
						"</ConsumerRequest>" + 
						"                    <CCCCustomerID>199994</CCCCustomerID>" + 
						"                          <ResidenceID></ResidenceID>" + 
						"                    <Name>" + 
						"                      <TitleOther>MRS</TitleOther>" + 
						"                      <Forename>JESSICA</Forename>" + 
						"                      <Surname>TWIX</Surname>" + 
						"                    </Name>" + 
						"                    <DoB>1966-04-08</DoB>" + 
						"                    <UKAddress>" + 
						"                      <Abode />" + 
						"                      <HouseName />" + 
						"                      <HouseNumber>63</HouseNumber>" + 
						"                      <Street1>THE RIDGE</Street1>" + 
						"                      <Street2 />" + 
						"                      <Town>STOCKPORT</Town>" + 
						"                      <PostCode>SK6 7ER</PostCode>" + 
						"                    </UKAddress>" + 
						"                    <CCCInsolvencyOrderID></CCCInsolvencyOrderID>" + 
						"                  </Dispute>" + 
						"                </CallCredit>" + 
						"              </Entities>" + 
						"            </Case>" + 
						"          </Cases>" + 
						"        </BizAgiWSParam>" + 
						"      </casesInfo>" + 
						"    </createCases>" + 
						"  </s:Body>" + 
						"</s:Envelope>";
				
//				payloadString = "<soap:Envelope" + 
//						"    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"" + 
//						"    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + 
//						"    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">" + 
//						"    <soap:Header>" + 
//						"        <callcreditheaders" + 
//						"            xmlns=\"urn:callcredit.co.uk/soap:callreport7\">" + 
//						"            <company>Optimus CR CTest</company>" + 
//						"            <username>Optimus CR API CTest</username>" + 
//						"            <password>password123</password>" + 
//						"        </callcreditheaders>" + 
//						"    </soap:Header>" + 
//						"    <soap:Body>" + 
//						"        <Search07a" + 
//						"            xmlns=\"urn:callcredit.co.uk/soap:callreport7\">" + 
//						"            <SearchDefinition>" + 
//						"                <creditrequest schemaversion=\"7.1\" datasets=\"511\"" + 
//						"                    xmlns=\"urn:callcredit.co.uk/soap:callreport7\">" + 
//						"                    <idoutput>1</idoutput>" + 
//						"                    <logscore>1</logscore>" + 
//						"                    <applicant>" + 
//						"                        <address>" + 
//						"                            <buildingno></buildingno>" + 
//						"                            <postcode>X9 9AB</postcode>" + 
//						"                        </address>" + 
//						"                        <name>" + 
//						"                            <forename>HARRY</forename>" + 
//						"                            <surname>HAIRPIN</surname>" + 
//						"                        </name>" + 
//						"                        <dob>1950-10-13</dob>" + 
//						"                    </applicant>" + 
//						"                    <score>1</score>" + 
//						"                    <purpose>CL</purpose>" + 
//						"                </creditrequest>" + 
//						"            </SearchDefinition>" + 
//						"        </Search07a>" + 
//						"    </soap:Body>" + 
//						"</soap:Envelope>" + 
//						"";
				break;				
	    	default:
		        reporterHelper.customFailScript("Unknown testType in method aPenTestRequestIsSent: " + testType);
		}
		
		payloadSize = Integer.toString(payloadString.length());

		switch(endpointIdentifier) {

    	case "NumeroCreateDispute":
//    		authStringEncoded = DatatypeConverter.printBase64Binary((adminUsername + ":" + adminPassword).getBytes());
    		endPointUrl = "https://pllwininweb006.cig.local/gateway/BizagiStub/v1/";
//    		params = "workspaceId=111 HTTP/1.1";
//    		params = "workspaceId=111";
    		break;
    	default:
	        reporterHelper.customFailScript("Unknown endpointIdentifier in method aRequestIsSent: " + endpointIdentifier);
		}

//@@@@@@@@@@@
		
		
        try {
        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server
        InputStream is = null;
        String cacheType = "MEMORY";
//        String cacheType = "FILE";
        String payload = "TEST PAYLOAD";
        
        
        reporterHelper.log("payloadString: " + payloadString);
        
		if (cacheType == "MEMORY") {
            is = new ByteArrayInputStream(payloadString.getBytes(Charset.forName("UTF-8")));
        } 
        if (cacheType == "FILE") {
        	reporterHelper.log("read from file");
//            is = new FileInputStream(this.fileName);
        } 
        // copy original message into this.
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage(null, is);                 
//        String url = "http://some.site.com/" + endpoint;
        String url = endPointUrl;
        
//        url = "https://pllwindvweb005.cig.local/Services/CallReport/callreport7.asmx";
        reporterHelper.log("soapMessage.toString(); " + soapMessage.toString());
        reporterHelper.log("soapMessage.getSOAPBody().toString(); " + soapMessage.getSOAPBody().toString());
        
        

        
        reporterHelper.log("invoke url " + url);
        SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
        
        reporterHelper.log("HERE A1");
        SOAPBody soapBody = soapResponse.getSOAPBody();
        reporterHelper.log("HERE A2");
//Adapt processing to your response
        NodeList faultList = soapBody.getElementsByTagName("faultcode");
        reporterHelper.log("HERE A3");
        NodeList resultList = soapBody.getElementsByTagName("Result");
        reporterHelper.log("HERE A4");
        // default value;
        Boolean resultValue = true;
        
        if (faultList.getLength() > 0) {
        	reporterHelper.log("faultList is populated");
        } else {
        	reporterHelper.log("faultList is NOT populated");
        }
        	
        if (resultList.getLength() > 0) {
        	reporterHelper.log("resultList is populated");
            Element value = (Element) resultList.item(0);
            
            if ((value.getTextContent() != null) && (value.getTextContent().equals("false"))) {
                resultValue = false;
            }
        } else {
        	reporterHelper.log("resultList is NOT populated");
        }

        soapConnection.close();
    } catch (Exception e) {
    	reporterHelper.log("Error occurred while sending SOAP Request to Server: " + e);
    }             
        reporterHelper.log("webservice called");
    
    //@@@@@@@@@@@@@@
		
	}	
	@Then("^a '(.*)' response code is received$")
	public void aResponseCodeIsReceived(String expectedResponseCode) {

		if (responseCode != Integer.parseInt(expectedResponseCode)) {
			reporterHelper.customFailScript("Unexpected Response code: " + responseCode);
		} else {
			reporterHelper.log("SUCCESS: Expected response code received: " + responseCode);
		}
		
	}

	@Then("^an authentication token is returned$")
	public void anAuthenticationTokenShouldBeReturned() {
		
		try {
			reporterHelper.log("Response Message: " + con.getResponseMessage());
		} catch (IOException e) {
			reporterHelper.customFailScript("Exception caught in method anAuthenticationTokenShouldBeReturned() when attempting con.getResponseMessage(): " + e);
		}
		
		kssToken = con.getHeaderField("KSS-Token");
		reporterHelper.log("KSS-Token: " + kssToken);
	}
	

	@When("^user is authenticated$")
	public void userIsAuthenticated() {
		validCredentialsAreUsed();
		aRequestIsSent("GET", "GetUserSettings");
		aResponseCodeIsReceived("200");
		anAuthenticationTokenShouldBeReturned();
		 
		useKssToken = true;
		kssTokenToUse = kssToken; 
	}
	
	@When("^user is not authenticated$")
	public void userIsNotAuthenticated() {
		useKssToken = true;
		kssTokenToUse = ""; 
	}

	
	@Then("^the returned json object is not null$")
	public void theReturnedJsonObjectIsNotNull() {

		String responseString = parseResponseString();
		reporterHelper.log("responseString:" + responseString);
		
		
		JSONObject jsonResponseObject = new JSONObject(responseString);
		reporterHelper.log("jsonResponseObject.toString():" + jsonResponseObject.toString());
	}

	@Then("^the returned json object is null$")
	public void theReturnedJsonObjectIsNull() {

		String responseString = parseResponseString();
		reporterHelper.log("responseString:" + responseString);
		
		JSONObject jsonResponseObject = new JSONObject(responseString);
		reporterHelper.log("jsonResponseObject.toString():" + jsonResponseObject.toString());
		
	}

	@Then("^the returned json array is not null$")
	public void theReturnedJsonArrayIsNotNull() {

		String responseString = parseResponseString();
		reporterHelper.log("responseString:" + responseString);
		
		JSONArray jsonResponseArray = new JSONArray(responseString);
		reporterHelper.log("jsonResponseArray.toString():" + jsonResponseArray.toString());
	}

	@Then("^the returned json array is null$")
	public void theReturnedJsonArrayIsNull() {
		// TOO
	}	
	@Then("^a json array should be received$")
	public void ajsonArrayShouldBeReceived() {

		String responseString = parseResponseString();
		reporterHelper.log("responseString:" + responseString);
		
		JSONArray jsonResponseArray = new JSONArray(responseString);
		reporterHelper.log("jsonResponseArray.toString():" + jsonResponseArray.toString());
		
	}
	
	private String parseResponseString() {
		
		String inputLine;
		response = new StringBuffer();
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			
		} catch (Exception e) {
			reporterHelper.log("Exception caught trying to parse api json response: " + e);
			
			in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}

		try {
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			reporterHelper.customFailScript("Exception caught trying to read BufferedReader object created from api response: " + e);
		}

		reporterHelper.log("Response: " + response.toString());
		
		return response.toString();
	}	

    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }

			@Override
			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				// TODO Auto-generated method stub
				
			}
        } };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection
                    .setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {

		@Override
		public boolean verify(String hostname, SSLSession session) {
			// TODO Auto-generated method stub
			return true;
		}
    };	
}	
