package br.edu.ifpb.padroes.api.pizzahot.proxy;

import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotServiceImpl;

import java.util.ArrayList;
import java.util.List;

// TODO - implementar proxy de cache para evitar leitura do json a cada chamada do método
public class PizzaHotServiceProxy implements PizzaHotService {
	private PizzaHotService pizzahotService;
    private List<PizzaHotPizza> cacheAll = new ArrayList<PizzaHotPizza>();
	
    public PizzaHotServiceProxy() {
    	this.pizzahotService = new PizzaHotServiceImpl();
    }
    
    @Override
    public List<PizzaHotPizza> getPizzas() {
    	// TODO - implementar proxy
    	if (cacheAll.isEmpty()) {
            cacheAll = pizzahotService.getPizzas();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cacheAll;
    }
}
