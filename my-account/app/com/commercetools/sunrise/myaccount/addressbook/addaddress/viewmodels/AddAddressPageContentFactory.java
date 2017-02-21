package com.commercetools.sunrise.myaccount.addressbook.addaddress.viewmodels;

import com.commercetools.sunrise.common.models.FormPageContentFactory;
import com.commercetools.sunrise.common.utils.PageTitleResolver;
import com.commercetools.sunrise.myaccount.addressbook.AddressFormData;
import com.commercetools.sunrise.myaccount.addressbook.addressbookdetail.viewmodels.AddressFormSettingsBeanFactory;
import io.sphere.sdk.customers.Customer;
import play.data.Form;

import javax.inject.Inject;

public class AddAddressPageContentFactory extends FormPageContentFactory<AddAddressPageContent, Customer, AddressFormData> {

    private final PageTitleResolver pageTitleResolver;
    private final AddressFormSettingsBeanFactory addressFormSettingsBeanFactory;

    @Inject
    public AddAddressPageContentFactory(final PageTitleResolver pageTitleResolver, final AddressFormSettingsBeanFactory addressFormSettingsBeanFactory) {
        this.pageTitleResolver = pageTitleResolver;
        this.addressFormSettingsBeanFactory = addressFormSettingsBeanFactory;
    }

    @Override
    protected AddAddressPageContent getViewModelInstance() {
        return new AddAddressPageContent();
    }

    @Override
    public final AddAddressPageContent create(final Customer customer, final Form<? extends AddressFormData> form) {
        return super.create(customer, form);
    }

    @Override
    protected final void initialize(final AddAddressPageContent model, final Customer customer, final Form<? extends AddressFormData> form) {
        super.initialize(model, customer, form);
        fillNewAddressForm(model, customer, form);
        fillNewAddressFormSettings(model, customer, form);
    }

    @Override
    protected void fillTitle(final AddAddressPageContent model, final Customer customer, final Form<? extends AddressFormData> form) {
        model.setTitle(pageTitleResolver.getOrEmpty("myAccount:addAddressPage.title"));
    }

    protected void fillNewAddressForm(final AddAddressPageContent model, final Customer customer, final Form<? extends AddressFormData> form) {
        model.setNewAddressForm(form);
    }

    protected void fillNewAddressFormSettings(final AddAddressPageContent model, final Customer customer, final Form<? extends AddressFormData> form) {
        model.setNewAddressFormSettings(addressFormSettingsBeanFactory.create(customer, form));
    }
}