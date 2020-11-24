package pet.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pet.petshop.entity.Item;
import pet.petshop.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {
	@Autowired
	private ProductService ps;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "cart/cart";
	}

	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public String buy(@PathVariable("id") int id, ModelMap model, HttpSession session) {
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(ps.get(id), 1));
			session.setAttribute("cart", cart);
		}else
		{
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index=isExists(id, cart);
			if(index==-1) {
				cart.add(new Item(ps.get(id), 1));
			}else {
				int quantity = cart.get(index).getQuantity()+1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		return "redirect:/sanpham";
	}

	private int isExists(int id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}
}
