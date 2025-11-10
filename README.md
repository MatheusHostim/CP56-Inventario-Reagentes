# 🧪 Sistema de Controle de Reagentes

👥 **Nossa equipe**  
Estevam Melo RM555124  
Eduardo Lima RM554804  
Guilherme Ulacco RM558418  
Matheus Hostim RM556517  

💰 **Objetivo do Projeto**  
Este projeto tem como objetivo criar uma API REST em Java com Spring Boot para gerenciar reagentes químicos em um laboratório. A ideia é permitir cadastrar reagentes, consultar informações, atualizar e deletar registros, incluindo dados do fornecedor de cada reagente. O foco é automatizar o controle de estoque, facilitando o monitoramento de validade, quantidade e lote dos reagentes, além de manter o vínculo com fornecedores.

---

🔍 **Funcionalidades da API**

**Listar todos os reagentes**  
`GET /reagentes` → Retorna a lista completa de reagentes cadastrados.

**Buscar reagente por ID**  
`GET /reagentes/{id}` → Retorna os dados de um reagente específico.

**Criar reagente**  
`POST /reagentes` → Cria um novo reagente.  
Exemplo de JSON de entrada:
```json
{
  "id": null,
  "nome": "Ácido Clorídrico",
  "quantidade": 10,
  "lote": "L1234",
  "validade": "2026-12-31",
  "fornecedor": {
    "id": null,
    "nome": "LabFornecedores",
    "contato": "contato@labfornecedores.com"
  }
}
```



💻 **Tecnologias utilizadas**
* Java 17
* Spring Web
* Spring Boot DevTools
* Spring Data JPA
* H2 Database
* Maven

🏗️ **Estrutura do projeto**

O projeto está organizado em pacotes para manter tudo limpo e fácil de manter. O pacote model contém as entidades Reagente e Fornecedor, o dto contém os objetos de transferência de dados, e o mapper faz a conversão entre DTOs e entidades. O repository é responsável pelo
acesso ao banco de dados, o service contém a lógica de negócio e o controller define os endpoints da API REST.

---

🚀 **Como Executar e Testar**

1. **Build e execução do projeto**  
   - No Git Bash ou terminal da sua preferência, rode:
     ```bash
     ./mvnw -U clean package
     ./mvnw spring-boot:run
     ```
   - A aplicação estará disponível em `http://localhost:8080`.

2. **Acessando o H2 Console**  
   Esse é um site que o Spring Boot expõe automaticamente para o banco em memória.  
   - Abra o navegador e vá para:  
     👉 `http://localhost:8080/h2-console`
   - Preencha o formulário assim:
     - JDBC URL: `jdbc:h2:mem:reagentesdb`
     - User Name: `sa`
     - Password: (deixe vazio mesmo)
   - Clique em **Connect** ✅  
   - Você vai ver as tabelas:
     - `FORNECEDOR`
     - `REAGENTE`
   - E vai poder executar SQL, por exemplo:
     ```sql
     SELECT * FROM REAGENTE;
     ```

3. **Testando a API pelo PowerShell**  
   - Abra o PowerShell e rode o seguinte comando para criar um reagente:
     ```powershell
     $body = @{
       nome = "Ácido Acético"
       quantidade = 10
       lote = "L123"
       validade = "2026-12-31"
       fornecedor = @{ nome = "LabFornece Ltda"; contato = "contato@lab.com" }
     } | ConvertTo-Json -Depth 3

     $bytes = [System.Text.Encoding]::UTF8.GetBytes($body)

     Invoke-RestMethod -Uri 'http://localhost:8080/api/reagentes' -Method Post -Body $bytes -ContentType 'application/json'
     ```
   - Isso vai criar o registro no banco em memória e vai estar permitindo testar os endpoints.


📊 **Concluindo**

A API permite gerenciar reagentes de forma completa, garantindo que as informações de reagentes e fornecedores fiquem sempre consistentes. Usando DTOs e mapeadores, conseguimos separar os dados que são exibidos dos dados que ficam no banco, deixando o sistema mais
organizado e fácil de manter. O Spring Boot facilita muito o processo de configuração e inicialização do projeto, trazendo suporte automático para banco de dados e endpoints REST. Isso tudo faz deixa o projeto simples e funcional, estando pronto pra ser expandido caso
precise adicionar autenticação, relatórios ou dashboards de estoque.
