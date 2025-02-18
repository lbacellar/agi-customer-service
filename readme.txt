# agi-customer-service

S - Princípio da Responsabilidade Única (SRP)
CustomerService - Lida apenas com regras de negócio
CustomerRepositoryAdapter - Cuida apenas do acesso ao MongoDB
CustomerController - Apenas recebe requisições HTTP

O - Princípio do Aberto/Fechado (OCP)
O código está aberto para extensão, mas fechado para modificação.
Se quisermos trocar MongoDB por PostgreSQL, basta criar outro adaptador sem alterar CustomerService.
Se quisermos adicionar uma regra de validação, podemos criar um CustomerValidationService sem mudar o código existente.

L - Princípio de Substituição de Liskov (LSP)
A interface CustomerRepositoryPort define métodos que qualquer repositório pode implementar.
MongoCustomerRepository pode ser substituído por outro banco sem quebrar o código.
Isso garante que o sistema continue funcionando independentemente da implementação do banco.

I - Princípio da Segregação de Interfaces (ISP)
Criei interfaces pequenas e específicas para cada necessidade:
CustomerUseCase - Define apenas os métodos de negócio
CustomerRepositoryPort - Define apenas operações no banco

D - Princípio da Inversão de Dependência (DIP)
O código depende de abstrações e não de implementações concretas:
CustomerService depende da interface CustomerRepositoryPort, e não diretamente do MongoDB.
Isso nos permite trocar o banco de dados sem alterar a regra de negócio.

# Curls

curl -X POST \
http://localhost:8080/customers \
-H 'Accept: */*' \
-H 'Accept-Encoding: gzip, deflate' \
-H 'Cache-Control: no-cache' \
-H 'Connection: keep-alive' \
-H 'Content-Length: 146' \
-H 'Content-Type: application/json' \
-H 'Host: localhost:8080' \
-H 'Postman-Token: e69c0526-4214-4a7b-a22b-904d25f60cf5,64135b5d-6307-4c09-937c-8033236df0a6' \
-H 'User-Agent: PostmanRuntime/7.16.3' \
-H 'cache-control: no-cache' \
-d '{
"cpf": "12345678920",
"name": "Leandro",
"birthDate": "10/01/1980",
"phone": "1998745988",
"address": "Rua test da gloria"
}'

curl -X GET \
http://localhost:8080/customers \
-H 'Accept: */*' \
-H 'Accept-Encoding: gzip, deflate' \
-H 'Cache-Control: no-cache' \
-H 'Connection: keep-alive' \
-H 'Host: localhost:8080' \
-H 'Postman-Token: 752aefba-01fa-44ef-9026-a82da2399f76,b81f237d-7d15-4cf3-8770-6e9ea75525a2' \
-H 'User-Agent: PostmanRuntime/7.16.3' \
-H 'cache-control: no-cache'

curl -X GET \
http://localhost:8080/customers/12345678920 \
-H 'Accept: */*' \
-H 'Accept-Encoding: gzip, deflate' \
-H 'Cache-Control: no-cache' \
-H 'Connection: keep-alive' \
-H 'Host: localhost:8080' \
-H 'Postman-Token: 23ef296a-2351-493f-b6dd-b65de631dea6,2f567710-3f15-4173-af0c-ffece036b159' \
-H 'User-Agent: PostmanRuntime/7.16.3' \
-H 'cache-control: no-cache'

curl -X PUT \
http://localhost:8080/customers \
-H 'Accept: */*' \
-H 'Accept-Encoding: gzip, deflate' \
-H 'Cache-Control: no-cache' \
-H 'Connection: keep-alive' \
-H 'Content-Length: 197' \
-H 'Content-Type: application/json' \
-H 'Host: localhost:8080' \
-H 'Postman-Token: a60e4aad-659e-4054-9835-5f39c3facfb9,41c0b279-1ddc-46b7-9b9d-7f83ec2892f8' \
-H 'User-Agent: PostmanRuntime/7.16.3' \
-H 'cache-control: no-cache' \
-d '{
"id": "67b32ad1dbf4c84d8afd382b",
"cpf": "12345678920",
"name": "Leandro teste",
"birthDate": "10/01/1980",
"phone": "1998745988",
"address": "Rua test da gloria"
}'

curl -X DELETE \
http://localhost:8080/customers/67b232df28c8bf33f7a740ce \
-H 'Accept: */*' \
-H 'Accept-Encoding: gzip, deflate' \
-H 'Cache-Control: no-cache' \
-H 'Connection: keep-alive' \
-H 'Content-Length: ' \
-H 'Content-Type: application/json' \
-H 'Host: localhost:8080' \
-H 'Postman-Token: 3a24416e-58c0-457b-8ef5-fce45635c454,f45c8c01-1bcb-4b98-a7a9-b673212aee1c' \
-H 'User-Agent: PostmanRuntime/7.16.3' \
-H 'cache-control: no-cache'
