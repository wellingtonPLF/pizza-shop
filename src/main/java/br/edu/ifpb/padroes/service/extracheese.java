package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.PizzaShopPizza;

public class extracheese extends pizzaDecorator{
	
	public extracheese(Ipizza source) {
		super(source);
	}

	@Override
	public void orderPizza(Pizza pizza) {

        Float totalPrice = pizza.getPrice();
        String name = pizza.getName();

        // queijo extra
        totalPrice *= 1.10f; // 10% increase
        name += " (extra cheese)";
        pizza = new PizzaShopPizza(name, totalPrice);
        super.orderPizza(pizza);
    }
}
