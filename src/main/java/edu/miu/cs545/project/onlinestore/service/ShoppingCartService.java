package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.ShoppingCart;
import edu.miu.cs545.project.onlinestore.domain.ShoppingCartLine;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    ShoppingCart createShoppingCart(ShoppingCart cart);
    void removeLineFromShoppingCart(Long cartId, Long cartLineId);
    void addLineToShoppingCart(Long cartId, ShoppingCartLine cartLine);
    List<ShoppingCartLine> getLinesByShoppingCart(Long cartId);
    void updateLineInShoppingCart(Long cartId, ShoppingCartLine newCartLine);
    Optional<ShoppingCart> getShoppingCart(Long cartId);
    void updateQuantityInShoppingCartLine(Long cartId,Long lineId,Integer newQuantity);
    Optional<ShoppingCart> getShoppingCartByBuyerNotCompleted(Long buyerId);
}
