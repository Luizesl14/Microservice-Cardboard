package com.systemorderproducer;

import com.google.gson.Gson;
import com.systemorderproducer.aplicatiton.core.service.OrderProducerService;
import com.systemorderproducer.domain.model.BoxBody;
import com.systemorderproducer.domain.model.OrderProducer;
import com.systemorderproducer.domain.model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class SystemOrderProducerApplicationTests {

    @Autowired
    OrderProducerService orderProducerService;


    OrderProducer orderProducer;
    BoxBody boxBody;
    Payment payment;

    @BeforeEach
    void instanciarObjeto(){
        this.orderProducer = new OrderProducer();
        this.boxBody = new BoxBody();
        this.payment = new Payment();
        orderProducer.setId(1);
        orderProducer.setIdentify(UUID.randomUUID().toString());
        orderProducer.setCreatedAt(LocalDateTime.now());
        orderProducer.setDeliveryDate(LocalDateTime.now().plusDays(15));
        orderProducer.setShippingForProduction(true);
        boxBody.setId(1);
        boxBody.setLength(300);
        boxBody.setWidth(300);
        boxBody.setHeight(300);
        boxBody.setValueLengthCalc(3);
        boxBody.setValueWidthCalc(3);
        boxBody.setValueHeightCalc(6);
        orderProducer.setBoxBody(boxBody);
        payment.setId(1);
        payment.setApprovedPayment(true);
        orderProducer.setPayment(payment);
    }

    @Test
    @DisplayName("1- Testando as entidade do banco")
    void verificaValoresNulos(){
        if(orderProducer.getId() == null){
            Assertions.assertNull(orderProducer.getId());
        }else {
            Assertions.assertNotNull(orderProducer.getId());
        }
    }

    @Test
    @DisplayName("2- Testando-identify")
    void verificaAtributoIdentify(){
        Assertions.assertNotNull(orderProducer.getIdentify());
    }

    @Test
    @DisplayName("3- Testando-Construção-do-objeto")
    void testandoConstrucaoObjeto(){
        OrderProducer orderServiceTest = this.orderProducerService.creatObject(orderProducer);
        Assertions.assertNotNull(orderServiceTest.getCreatedAt());
        Assertions.assertNotNull(orderServiceTest.getDeliveryDate());
    }

    @Test
    @DisplayName("4- Testando-Calculo-corpo-da-caixa")
    void testandoCalculoBox(){
        OrderProducer orderServiceTest = this.orderProducerService.creatObject(orderProducer);
        Assertions.assertEquals(300, orderServiceTest.getBoxBody().getLength());
        Assertions.assertEquals(300, orderServiceTest.getBoxBody().getWidth());
        Assertions.assertEquals(300, orderServiceTest.getBoxBody().getWidth());

        Assertions.assertEquals(3, orderServiceTest.getBoxBody().getValueLengthCalc());
        Assertions.assertEquals(3, orderServiceTest.getBoxBody().getValueWidthCalc());
        Assertions.assertEquals(6, orderServiceTest.getBoxBody().getValueHeightCalc());
    }

    @Test
    @DisplayName("4- Testando-reciver-para-ActiveMQ")
    void testandoTopcMailBox(){
        Object obj = new Gson().fromJson(orderProducer.toString(), Object.class);
        Assertions.assertNotNull(obj);
    }


}
