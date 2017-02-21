package com.commercetools.sunrise.framework.checkout.shipping.viewmodels;

import com.commercetools.sunrise.framework.checkout.AbstractCheckoutPageContent;
import play.data.Form;

public class CheckoutShippingPageContent extends AbstractCheckoutPageContent {

    private Form<?> shippingForm;
    private CheckoutShippingFormSettingsBean shippingFormSettings;

    public CheckoutShippingPageContent() {
    }

    public Form<?> getShippingForm() {
        return shippingForm;
    }

    public void setShippingForm(final Form<?> shippingForm) {
        this.shippingForm = shippingForm;
    }

    public CheckoutShippingFormSettingsBean getShippingFormSettings() {
        return shippingFormSettings;
    }

    public void setShippingFormSettings(final CheckoutShippingFormSettingsBean shippingFormSettings) {
        this.shippingFormSettings = shippingFormSettings;
    }
}