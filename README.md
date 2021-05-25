# algalog-api
API do curso Mergulho Spring Rest da Algaworks

# Como Rodar
1. Clone da aplicação
2. Importar na IDE de sua escolha
3. Iniciar a aplicação SpringBoot

* Endereço para os endpoints [[http://localhost:8080/]]
* Endereço do swagger: [[http://localhost:8080/swagger-ui/]]

# Endpoints

## CLIENTE

1. GET /clientes lista
2. POST /clientes adicionar
3. GET /clientes/{id} obter
4. PUT /clientes/{id} atualizar
5. DELETE /clientes/{id} deletar


## ENTREGA


GET /entregas listar
POST /entregas solicitar
GET /entregas/{id} obter
PUT /entregas/{id}/finalizacao finalizar

## OCORRÊNCIA

GET /entregas/{entregaId}/ocorrencias obter
POST /entregas/{entregaId}/ocorrencias registrar
