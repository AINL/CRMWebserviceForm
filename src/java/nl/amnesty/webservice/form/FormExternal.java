package nl.amnesty.webservice.form;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import nl.amnesty.sys.controller.CRMWebformController;
import nl.amnesty.sys.webform.entity.Form;

/**
 *
 * @author evelzen
 */
@WebService()
@Stateless()
public class FormExternal {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "submitform")
    public long submitform(@WebParam(name = "form") Form form) {
        
        //DEBUG
        //for (Property property : form.getPropertylist()) {
        //    Logger.getLogger(FormExternal.class.getName()).log(Level.INFO, "Key [{0}] value [{1}]", new Object[]{property.getKey(), property.getValue()});
        //}
        
        CRMWebformController.processForm(form);
        return form.getSubmissionid();
    }
}
