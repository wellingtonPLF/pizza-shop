package br.edu.ifpb.padroes.domain.adapter;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosService;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotService;
import br.edu.ifpb.padroes.domain.Pizza;

public class PizzaAdapter{
	
	private List<Pizza> pizzas = new ArrayList<Pizza>();
	
	private DamenosService damenos;
	private PizzaHotService pizzahot;
	
	private DamenosAdapter damenosAdapter;
	private PizzahotAdapter pizzahotAdapter;

    public PizzaAdapter(DamenosService damenos, PizzaHotService pizzahot) {
        this.damenos = damenos;
        this.pizzahot = pizzahot;
    }
    
    public List<Pizza> getPizzas(){
    	for (PizzaHotPizza p : this.pizzahot.getPizzas()) {
    		pizzahotAdapter = new PizzahotAdapter(p);
    		pizzas.add(pizzahotAdapter);
        }
    	for (DamenosPizza d : this.damenos.getPizzas()) {
            damenosAdapter = new DamenosAdapter(d);
            pizzas.add(damenosAdapter);
        }
        return pizzas;
    }
}
