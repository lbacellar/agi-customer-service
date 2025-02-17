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