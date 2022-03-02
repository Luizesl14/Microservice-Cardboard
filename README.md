# Microservice-Cardboard
Microservices system for cardboard company

# Modulos-microservice
* discorery

* gateway

* system-controller

* system-order-service

* system-order-producer

# Tecnologias aplicadas

* servidor Netiflix: Discovery

* roteador Spring-Cloud: Gateway

* comunicação Spring-Cloud: Open Feign

* comunicação Mensageria: ActiveMQ

* versionamento banco de dados: Flyway

* banco de dados: PostgresSQL

* imagem banco: Docker

* segurança: Spring-Security

* Segurança: Oauth2

* Segurança: Keycloack

# Sobre uso das Tecnologias
Algumas das ferramentas apresantadas aqui, não foram abordadas no curso mais como foi solicitado para
criar algo diferente com proposta de aprendizado implementei as ferramentas no codigo do spring cloud,
sei que algumas dessas ferramentas as empresas AWS, AZURE, ORACLE oferecem esses serviços mais achei
interassante aprender e apresenta-las no projeto assim como algumas ferramentas como Docker.

# Consumindo API 

* Primeiro devemos instalar  as ferramentas Keycloack e ActiveMQ

 Adicionar aos admim-cli  premissão "Admin" e "User" / ActiveMQ criar um "topc.mailbox"
 Podemos Acessar os endpois através do Gateway Ex: http://localhost:8765/system-controller/controller-order-service/1
 
 
* Solicitar token para acessar aplicação Barear Token/ Oauth2 
* Primeiro passo devemos criar uma Order passando RequestBody: "order/save"
* Segundo passo devemos alterar uma Order passando RequestBody: "order/update"

alterando o objeto payment atributo approvedPayment para "true", simulanto 
assim um resposta pagamento.

* Terceiro passo podemos criar order-service passando PathVariable(orderId) e RequestBody(body): "controller-order-service/save/order/{orderId}"

se estiver tudo ok com order e pagamento estiver confirmado,vamos criar uma order service antes de criar ele verifica se pagamento
foi aprovado se não foi aprovado ele gera uma mensagem de error e order-service não será criada.

* Quarto passo podemos atualizar order-service passando PathVariable(orderId) e RequestBody(body): "controller-order-service/update/order/{orderId}"

dentro  RequestBody(body) podemos alterar o atributo shippingForProduction "true", após  atualizar e so aguardar;

* Quinto passo aguardar após um periodo de 1 hora metodo vai buscar todas as order-services com shippingForProduction "true", tudo isso automaticamente.
* Sexto passo aguardar após agendamento order-service sera enviado atraves de um topc mensageria para order-producer finalizando a automação e ultimo estagio do servico;

Esse serviço principal podemos através do controller criar order-service (crud) , order-producer(crud), order(crud)
outros demais servicos são agentes externos que não atrapalham a execução do servico;

Atenção: devemos aguardar alguns minutos após a execução de todos os serviços para consumir api, todos os microserviços se registram no Discovery antes de ser utilizado;




