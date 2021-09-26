package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.PizzaShopPizza;

public class discountCoupon extends pizzaDecorator{
	
	public discountCoupon(Ipizza source) {
		super(source);
	}

	@Override
	public void orderPizza(Pizza pizza) {

        Float totalPrice = pizza.getPrice();

        // cupom de desconto
        totalPrice *= 0.25f; // 25% discount
        pizza = new PizzaShopPizza(pizza.getName(), totalPrice);
        super.orderPizza(pizza);
    }
}
