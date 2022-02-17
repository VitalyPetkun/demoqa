package framework;

import framework.browser.WaiterUtils;
import framework.utils.MyLogger;

public abstract class BaseForm {
    private BaseElement uniqElement;
    private String formName;

    protected BaseForm(BaseElement uniqElement, String formName) {
        this.uniqElement = uniqElement;
        this.formName = formName;
    }

    public boolean isFormOpen() {
        if(uniqElement.isPresent())
            MyLogger.logInfo("open " + formName + ".");
        else
            MyLogger.logWarn("not open " + formName + ".");
        return uniqElement.isPresent();
    }

    public boolean isFormClose() {
        if(WaiterUtils.invisibilityOfElementLocated(uniqElement.getLocator()))
            MyLogger.logInfo("close " + formName + ".");
        else
            MyLogger.logWarn("not close " + formName + ".");
        return WaiterUtils.invisibilityOfElementLocated(uniqElement.getLocator());
    }
}
