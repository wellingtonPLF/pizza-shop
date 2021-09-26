package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.PizzaShopPizza;

public class massaPan extends pizzaDecorator{
	
	public massaPan(Ipizza source) {
		super(source);
	}

	@Override
	public void orderPizza(Pizza pizza) {

        Float totalPrice = pizza.getPrice();
        String name = pizza.getName();

        // massa pan
        totalPrice *= 1.15f; // 15% increase
        name += " (pan pizza)";
        pizza = new PizzaShopPizza(name, totalPrice);
        super.orderPizza(pizza);
    }
}
