package com.commercetools.sunrise.framework.cart.cartdetail;

import com.commercetools.sunrise.common.pages.PageContent;
import com.commercetools.sunrise.framework.controllers.SunriseTemplateController;
import com.commercetools.sunrise.framework.controllers.WithQueryFlow;
import com.commercetools.sunrise.framework.hooks.RunRequestStartedHook;
import com.commercetools.sunrise.framework.reverserouters.SunriseRoute;
import com.commercetools.sunrise.framework.reverserouters.shoppingcart.CartReverseRouter;
import com.commercetools.sunrise.framework.template.engine.TemplateRenderer;
import com.commercetools.sunrise.framework.CartFinder;
import com.commercetools.sunrise.framework.WithRequiredCart;
import com.commercetools.sunrise.framework.cart.cartdetail.viewmodels.CartDetailPageContentFactory;
import io.sphere.sdk.carts.Cart;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

public abstract class SunriseCartDetailController extends SunriseTemplateController implements WithQueryFlow<Cart>, WithRequiredCart {

    private final CartFinder cartFinder;
    private final CartDetailPageContentFactory cartDetailPageContentFactory;

    protected SunriseCartDetailController(final TemplateRenderer templateRenderer,
                                          final CartFinder cartFinder,
                                          final CartDetailPageContentFactory cartDetailPageContentFactory) {
        super(templateRenderer);
        this.cartFinder = cartFinder;
        this.cartDetailPageContentFactory = cartDetailPageContentFactory;
    }

    @Override
    public CartFinder getCartFinder() {
        return cartFinder;
    }

    @RunRequestStartedHook
    @SunriseRoute(CartReverseRouter.CART_DETAIL_PAGE)
    public CompletionStage<Result> show(final String languageTag) {
        return requireCart(this::showPage);
    }

    @Override
    public CompletionStage<Result> handleNotFoundCart() {
        return okResultWithPageContent(cartDetailPageContentFactory.create(null));
    }

    @Override
    public PageContent createPageContent(final Cart cart) {
        return cartDetailPageContentFactory.create(cart);
    }
}