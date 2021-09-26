package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.PizzaShopPizza;

public class bordaRecheada extends pizzaDecorator{
	
	public bordaRecheada(Ipizza source) {
		super(source);
	}

	@Override
	public void orderPizza(Pizza pizza) {

        Float totalPrice = pizza.getPrice();
        String name = pizza.getName();
        
        // borda recheada
        totalPrice *= 1.20f; // 20% increase
        name += " (stuffed crust)";
        pizza = new PizzaShopPizza(name, totalPrice);
        super.orderPizza(pizza);
    }
}
