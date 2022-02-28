package com.systemorderservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.systemorderservice.aplicatiton.core.service.SOrderService;
import com.systemorderservice.domain.model.BoxBody;
import com.systemorderservice.domain.model.OrderService;
import com.systemorderservice.domain.model.OrderStatus;
import com.systemorderservice.domain.model.Payment;
import com.systemorderservice.insfrastructure.repository.IOrderServiceRepository;
import com.systemorderservice.insfrastructure.repository.IStatusOrderServiceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class SystemOrderServiceApplicationTests {
    @Autowired
    IOrderServiceRepository iOrderServiceRepository;
    @Autowired
    IStatusOrderServiceRepository iStatusOrderServiceRepository;
    @Autowired
    SOrderService sOrderService;

    OrderService orderService;
    BoxBody boxBody;
    Payment payment;
    OrderStatus orderStatus;

    @BeforeEach
    void instanciarObjeto(){
        this.orderService = new OrderService();
        this.boxBody = new BoxBody();
        this.payment = new Payment();
        orderService.setId(1);
        orderService.setIdentify(UUID.randomUUID().toString());
        orderService.setCreatedAt(LocalDateTime.now());
        orderService.setDeliveryDate(LocalDateTime.now().plusDays(15));
        orderService.setShippingForProduction(true);
        boxBody.setId(1);
        boxBody.setLength(300);
        boxBody.setWidth(300);
        boxBody.setHeight(300);
        boxBody.setValueLengthCalc(3);
        boxBody.setValueWidthCalc(3);
        boxBody.setValueHeigthCalc(6);
        orderService.setBoxBody(boxBody);
        payment.setId(1);
        payment.setApprovedPayment(true);
        orderService.setPayment(payment);
        this.orderStatus = new OrderStatus();
        orderService.setIdentify(UUID.randomUUID().toString());
    }

    @Test
    @DisplayName("1- Testando as entidade do banco")
    void verificaValoresNulos(){
        if(orderService.getId() == null){
            Assertions.assertNull(orderService.getId());
        }else if(orderStatus.getId() == null){
            Assertions.assertNull(orderStatus.getId());
        }else {
            Assertions.assertNotNull(orderService.getId());
            Assertions.assertNotNull(orderStatus.getId());
        }
    }

    @Test
    @DisplayName("2- Testando-identify")
    void verificaAtributoIdentify(){
        Assertions.assertNotNull(orderStatus.getIdentify());
        Assertions.assertNotNull(orderService.getIdentify());
    }

    @Test
    @DisplayName("3- Testando-Contrução-do-objeto")
    void testandoConstrucaoObjeto(){
        OrderService orderServiceTest = this.sOrderService.creatObject(orderService);
        Assertions.assertNotNull(orderServiceTest.getCreatedAt());
        Assertions.assertNotNull(orderServiceTest.getDeliveryDate());
    }

    @Test
    @DisplayName("4- Testando-Calculo-corpo-da-caixa")
    void testandoCalculoBox(){
        OrderService orderServiceTest = this.sOrderService.creatObject(orderService);
        Assertions.assertEquals(300, orderServiceTest.getBoxBody().getLength());
        Assertions.assertEquals(300, orderServiceTest.getBoxBody().getWidth());
        Assertions.assertEquals(300, orderServiceTest.getBoxBody().getWidth());

        Assertions.assertEquals(3, orderServiceTest.getBoxBody().getValueLengthCalc());
        Assertions.assertEquals(3, orderServiceTest.getBoxBody().getValueWidthCalc());
        Assertions.assertEquals(6, orderServiceTest.getBoxBody().getValueHeigthCalc());

        Assertions.assertEquals(303, orderServiceTest.getBoxBody().getDilatedLengthOne());
        Assertions.assertEquals(303, orderServiceTest.getBoxBody().getDilatedWidthOne());
        Assertions.assertEquals(303, orderServiceTest.getBoxBody().getDilatedLengthTwo());
        Assertions.assertEquals(297, orderServiceTest.getBoxBody().getDilatedWidthTwo());
        Assertions.assertEquals(306, orderServiceTest.getBoxBody().getDilatedHeight());

    }

    @Test
    @DisplayName("4- Testando-envio-para-ActiveMQ")
    void testandoTopcMailBox() throws JsonProcessingException {
        Boolean bool = this.sOrderService.observableTrue();
        Assertions.assertEquals(true, bool);
    }

}
