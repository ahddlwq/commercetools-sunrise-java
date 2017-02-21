package com.commercetools.sunrise.common.models.carts;

import com.commercetools.sunrise.framework.injection.RequestScoped;
import com.commercetools.sunrise.common.utils.PriceFormatter;
import io.sphere.sdk.carts.LineItem;

import javax.inject.Inject;

@RequestScoped
public class LineItemBeanFactory extends AbstractLineItemBeanFactory<LineItemBean> {

    @Inject
    public LineItemBeanFactory(final PriceFormatter priceFormatter, final LineItemProductVariantBeanFactory lineItemProductVariantBeanFactory) {
        super(priceFormatter, lineItemProductVariantBeanFactory);
    }

    @Override
    protected LineItemBean getViewModelInstance() {
        return new LineItemBean();
    }

    @Override
    public final LineItemBean create(final LineItem data) {
        return super.create(data);
    }

    @Override
    protected final void initialize(final LineItemBean model, final LineItem data) {
        super.initialize(model, data);
    }
}