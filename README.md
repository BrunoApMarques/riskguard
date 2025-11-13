# RiskGuard

🛡️ RiskGuard — Motor de Análise de Risco (Java + Spring Boot)




O RiskGuard é um mini motor de análise de risco desenvolvido em Java + Spring Boot, capaz de avaliar transações, clientes ou qualquer entrada de dados usando regras configuráveis.

Esse tipo de projeto é muito usado em empresas como Itaú, BTG, Stone, XP, Mercado Pago, Serasa, bancos digitais e fintechs — mostrando que você entende domínio bancário, lógica de risco e cálculos determinísticos.

🎯 Objetivo do Sistema

O RiskGuard processa entradas (como transações, limites, pontuação, histórico) e retorna:

✔ Score de risco
✔ Classificação (baixo, médio, alto risco)
✔ Motivos da classificação
✔ Sinalização de alerta

Ideal para estudos, projetos de portfólio e demonstração de lógica aplicada.

🧠 Exemplo simples do que o motor analisa

Valor da transação

Histórico do cliente

Limite diário

Ocorrências suspeitas

Score de crédito

Fatores de comportamento

Regras gerais de segurança

Esse tipo de inteligência aparece em sistemas antifraude, análise de crédito e autorização de pagamentos.


🚀 Tecnologias Utilizadas

Tecnologia	Utilização

☕ Java 17+	Linguagem principal
🍃 Spring Boot	Estrutura da API
🧠 Service Layer	Lógica de risco
🔍 Validation	Regras de entrada
🐙 Git & GitHub	Versionamento

📁 Estrutura do Projeto


riskguard/
 ├── controller      # Endpoints REST para avaliação de risco
 ├── model           # Dados de entrada (RiskRequest)
 ├── service         # RiskService com lógicas de risco
 ├── rules           # (Opcional) Camada de regras separadas
 └── util            # Helpers e funções auxiliares

🔎 Endpoint Principal
📌 Avaliar risco

POST /risk/evaluate

📥 Exemplo de Request:
{
  "valorTransacao": 1200.00,
  "scoreCredito": 580,
  "transacoesUltimas24h": 5,
  "limiteDiario": 1500,
  "clienteBloqueado": false
}

📤 Exemplo de Response:
{
  "risco": "ALTO",
  "scoreFinal": 87,
  "motivos": [
    "Valor alto comparado ao limite diário",
    "Score de crédito baixo",
    "Muitas transações nas últimas 24h"
  ],
  "aprovado": false
}

🛠 Como rodar o projeto
1️⃣ Clonar repositório
git clone https://github.com/BrunoApMarques/riskguard.git
cd riskguard

2️⃣ Rodar com Maven
mvn spring-boot:run

3️⃣ Acessar a API
POST http://localhost:8080/risk/evaluate

📈 Regras Exemplos (implementadas ou futuras)

Score de crédito < 600 → risco ↑

Valor da transação > 70% do limite diário → risco ↑

Cliente bloqueado → risco máximo

Muitas transações em pouco tempo → risco ↑

Score alto + comportamento baixo → risco ↓

🧪 Testes Automatizados (planejamento)

Serão adicionados:

✔ Testes unitários de regras
✔ Testes de integração com MockMvc
✔ Teste de carga de regras
✔ Cenários de fraude simulada

🐳 Docker (futuro)
docker build -t riskguard-api .
docker run -p 8080:8080 riskguard-api

🗺 Roadmap de Evolução

Criar base dinâmica de regras

Adicionar Swagger

Configurar banco de dados

Criar alertas por nível de risco

Logs com correlação de eventos

Criar dashboard com métricas

👨‍💻 Autor

Bruno Marques
Desenvolvedor Back-end | Java | APIs REST | Lógica de Negócio
GitHub: https://github.com/BrunoApMarques
