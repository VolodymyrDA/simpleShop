package org.vdoloka.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vdoloka.entity.OrderEntity;
import org.vdoloka.entity.UserEntity;
import org.vdoloka.repository.OrdersRepository;
import org.vdoloka.repository.ProductsRepository;
import org.vdoloka.repository.UsersRepository;

import javax.transaction.Transactional;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final ProductsRepository productsRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository, ProductsRepository productsRepository, UsersRepository usersRepository) {
        this.ordersRepository = ordersRepository;
        this.productsRepository = productsRepository;
        this.usersRepository = usersRepository;
    }
    @Transactional
    public Boolean save(OrderEntity orderEntity) {
        UserEntity user =usersRepository.findById(orderEntity.getUserId()).get();
        int userAmmountMoney = user.getAmmountMoney();
        int productPrice = productsRepository.findById(orderEntity.getProductId()).get().getPrice();
        if (userAmmountMoney > productPrice) {
            ordersRepository.save(orderEntity);
            user.setAmmountMoney(user.getAmmountMoney()-productPrice);
            return true;
        }
        return false;
    }
    @Transactional
    public void deleteProductById(long id) {
        ordersRepository.deleteAllByProductId(id);
        productsRepository.deleteById(id);
    }
}
