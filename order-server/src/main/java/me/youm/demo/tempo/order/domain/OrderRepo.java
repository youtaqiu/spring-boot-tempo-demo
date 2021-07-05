package me.youm.demo.tempo.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
* 订单表 Repo
*
* @author youta
*/
@Repository
public interface OrderRepo  extends JpaRepository<Order, Long> {

    Optional<Order> findByOrderNo(String orderNo);
}