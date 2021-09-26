package br.edu.ifpb.padroes;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.PizzaShopPizza;
import br.edu.ifpb.padroes.domain.adapter.PizzaAdapter;
import br.edu.ifpb.padroes.service.PizzaShopService;
import br.edu.ifpb.padroes.service.bordaRecheada;
import br.edu.ifpb.padroes.service.discountCoupon;
import br.edu.ifpb.padroes.service.extracheese;
import br.edu.ifpb.padroes.service.massaPan;
import br.edu.ifpb.padroes.service.pizzaDecorator;

public class Main {

    public static void main(String[] args) {

        PizzaShopService pizzaShopService = new PizzaShopService();

        System.out.println("Pizzas - menu");

        // TODO - implementar adapter para juntar as pizzas da PizzaHot e Damenos em um único conjunto
        for (Pizza pizza : pizzaShopService.getPizzas()) {
            System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getPrice()));
        }
        
        Pizza pizza = new PizzaShopPizza("pepperoni", 55.0f);

        // TODO - implementar padrão decorator para só precisar passar o objeto pizza
        pizzaDecorator pizzaD = new discountCoupon(
        		new extracheese(
        				new bordaRecheada(
        						new PizzaShopService())));
        pizzaD.orderPizza(pizza);
    }
}
