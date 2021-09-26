package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.domain.Pizza;

public class pizzaDecorator implements Ipizza{
	
	private Ipizza wrapper;
	
	pizzaDecorator(Ipizza source){
		this.wrapper = source;
	}
	
	@Override
	public void orderPizza(Pizza pizza) {
        wrapper.orderPizza(pizza);
    }
}
