package com.systemcontroller;

import org.springframework.boot.test.context.SpringBootTest;

/**import com.systemcontroller.domain.model.Order;
import com.systemcontroller.domain.model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.time.LocalDateTime;
import java.util.UUID;*/

@SpringBootTest
class SystemControllerApplicationTests {

    /**
    Order order;
    Payment payment;

    @BeforeEach
    void instanciarObjeto(){
        this.order = new Order();
        this.payment = new Payment();
        order.setId(1);
        order.setIdentify(UUID.randomUUID().toString());
        order.setCreatedAt(LocalDateTime.now());
        order.setOrderServiceId(1);
        payment.setId(1);
        payment.setApprovedPayment(true);
        order.setPayment(payment);
    }

    @Test
    @DisplayName("1- Testando as entidade do banco")
    void verificaValoresNulos(){
        if(order.getId() == null){
            Assertions.assertNull(order.getId());
        }else {
            Assertions.assertNotNull(order.getId());
        }
    }

    @Test
    @DisplayName("2- Testando-identify")
    void verificaAtributoIdentify(){
        Assertions.assertNotNull(order.getIdentify());
    }

    @Test
    @DisplayName("3- Verificando-pagamento")
    void testandoTopcMailBox(){
        Assertions.assertEquals(true, order.getPayment().getApprovedPayment());
    }
    */
}
