//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:27 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:17 AM(foreman)-)
//


package com.ibm.websphere.svt.gs.ccdb.jaxws.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "GarageSaleCCManagerLocal", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GarageSaleCCManagerLocal {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createCCOwnerInfo", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateCCOwnerInfo")
    @ResponseWrapper(localName = "createCCOwnerInfoResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateCCOwnerInfoResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createCCOwnerInfoRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createCCOwnerInfoResponse")
    public boolean createCCOwnerInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        CcOwnerInfo arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createCCHistory", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateCCHistory")
    @ResponseWrapper(localName = "createCCHistoryResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateCCHistoryResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createCCHistoryRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createCCHistoryResponse")
    public boolean createCCHistory(
        @WebParam(name = "arg0", targetNamespace = "")
        CcHistory arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createCCAuthInfo", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateCCAuthInfo")
    @ResponseWrapper(localName = "createCCAuthInfoResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateCCAuthInfoResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createCCAuthInfoRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createCCAuthInfoResponse")
    public boolean createCCAuthInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        CcAuthInfo arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createCCInfo", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateCCInfo")
    @ResponseWrapper(localName = "createCCInfoResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateCCInfoResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createCCInfoRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createCCInfoResponse")
    public boolean createCCInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        CcInfo arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateCCOwnerInfo", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.UpdateCCOwnerInfo")
    @ResponseWrapper(localName = "updateCCOwnerInfoResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.UpdateCCOwnerInfoResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/updateCCOwnerInfoRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/updateCCOwnerInfoResponse")
    public boolean updateCCOwnerInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        CcOwnerInfo arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateCCInfo", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.UpdateCCInfo")
    @ResponseWrapper(localName = "updateCCInfoResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.UpdateCCInfoResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/updateCCInfoRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/updateCCInfoResponse")
    public boolean updateCCInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        CcInfo arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateCCAuthInfo", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.UpdateCCAuthInfo")
    @ResponseWrapper(localName = "updateCCAuthInfoResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.UpdateCCAuthInfoResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/updateCCAuthInfoRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/updateCCAuthInfoResponse")
    public boolean updateCCAuthInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        CcAuthInfo arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeCCOwner", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.RemoveCCOwner")
    @ResponseWrapper(localName = "removeCCOwnerResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.RemoveCCOwnerResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/removeCCOwnerRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/removeCCOwnerResponse")
    public boolean removeCCOwner(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeCCInfo", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.RemoveCCInfo")
    @ResponseWrapper(localName = "removeCCInfoResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.RemoveCCInfoResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/removeCCInfoRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/removeCCInfoResponse")
    public boolean removeCCInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeCCAuthInfo", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.RemoveCCAuthInfo")
    @ResponseWrapper(localName = "removeCCAuthInfoResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.RemoveCCAuthInfoResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/removeCCAuthInfoRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/removeCCAuthInfoResponse")
    public boolean removeCCAuthInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "genCCNum", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.GenCCNum")
    @ResponseWrapper(localName = "genCCNumResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.GenCCNumResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/genCCNumRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/genCCNumResponse")
    public String genCCNum();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "genTransID", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.GenTransID")
    @ResponseWrapper(localName = "genTransIDResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.GenTransIDResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/genTransIDRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/genTransIDResponse")
    public String genTransID();

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createNewCustomer", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateNewCustomer")
    @ResponseWrapper(localName = "createNewCustomerResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateNewCustomerResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createNewCustomerRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createNewCustomerResponse")
    public boolean createNewCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        CcAuthInfo arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        CcInfo arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        CcOwnerInfo arg2);

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "doCredit", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.DoCredit")
    @ResponseWrapper(localName = "doCreditResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.DoCreditResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/doCreditRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/doCreditResponse")
    public boolean doCredit(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        boolean arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "doDebit", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.DoDebit")
    @ResponseWrapper(localName = "doDebitResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.DoDebitResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/doDebitRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/doDebitResponse")
    public boolean doDebit(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        float arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        boolean arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validateCard", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.ValidateCard")
    @ResponseWrapper(localName = "validateCardResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.ValidateCardResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/validateCardRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/validateCardResponse")
    public boolean validateCard(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.ibm.websphere.svt.gs.ccdb.jaxws.client.CcHistory>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "showHistoryInfo", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.ShowHistoryInfo")
    @ResponseWrapper(localName = "showHistoryInfoResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.ShowHistoryInfoResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/showHistoryInfoRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/showHistoryInfoResponse")
    public List<CcHistory> showHistoryInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.ibm.websphere.svt.gs.ccdb.jaxws.client.CCInfoWrapper
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCCInfoWrapper", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.GetCCInfoWrapper")
    @ResponseWrapper(localName = "getCCInfoWrapperResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.GetCCInfoWrapperResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/getCCInfoWrapperRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/getCCInfoWrapperResponse")
    public CCInfoWrapper getCCInfoWrapper(
        @WebParam(name = "arg0", targetNamespace = "")
        CcInfo arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.ibm.websphere.svt.gs.ccdb.jaxws.client.CCInfoWrapper
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCCInfo", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.GetCCInfo")
    @ResponseWrapper(localName = "getCCInfoResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.GetCCInfoResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/getCCInfoRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/getCCInfoResponse")
    public CCInfoWrapper getCCInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.ibm.websphere.svt.gs.ccdb.jaxws.client.CCInfoWrapper>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createAccountForGS", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateAccountForGS")
    @ResponseWrapper(localName = "createAccountForGSResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.CreateAccountForGSResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createAccountForGSRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/createAccountForGSResponse")
    public List<CCInfoWrapper> createAccountForGS(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "resetCCDB", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.ResetCCDB")
    @ResponseWrapper(localName = "resetCCDBResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.ResetCCDBResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/resetCCDBRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/resetCCDBResponse")
    public boolean resetCCDB();

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "clearCCDB", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.ClearCCDB")
    @ResponseWrapper(localName = "clearCCDBResponse", targetNamespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/", className = "com.ibm.websphere.svt.gs.ccdb.jaxws.client.ClearCCDBResponse")
    @Action(input = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/clearCCDBRequest", output = "http://view.session.ccdb.gs.svt.websphere.ibm.com/GarageSaleCCManagerLocal/clearCCDBResponse")
    public boolean clearCCDB();

}
