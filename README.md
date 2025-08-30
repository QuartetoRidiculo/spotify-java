# Análise Crítica Comparativa – Projeto Spotify em Java

**Professora:** Samara Sonale Santos Sampaio  

**Integrantes:**  
- Darllan Cabral Sousa  
- Gustavo Travassos Barbosa  
- Rodrigo Silveira Silva  
- José Alison Barbosa Da Silva  

---

## Descrição do Projeto
Este repositório apresenta uma análise crítica comparativa de um projeto **Spotify em Java**, comparando a versão original com uma versão refatorada, destacando melhorias em organização, manutenção, validação e testabilidade.

---

## Estrutura do Código

### Original
- Classes pouco organizadas.  
- Lógica de negócio misturada à interface.  

### Refatorado
- Separação em pacotes: `model`, `service`, `util`, `app`.  
- Código mais limpo e de fácil manutenção.  

---

## Buscas

### Original
- Dependiam de escrita exata (maiúsculas/acentos).  

### Refatorado
- Buscas flexíveis, ignorando acentos e maiúsculas.  
- Aceita partes do texto, tornando a busca mais eficiente e amigável.  

---

## Validação de Dados

### Original
- Pouca validação e uso de comparações frágeis.  

### Refatorado
- Uso de **UUID** para identificar itens de forma única.  
- Validações mais robustas, garantindo maior consistência dos dados.  

---

## Testabilidade

### Original
- Sem testes.  
- Lógica acoplada ao `JOptionPane`.  

### Refatorado
- Lógica desacoplada da interface.  
- Inclusão de **JUnit** para testes automatizados.  

---

## Manutenção e Escalabilidade

### Original
- Adequado como exercício, mas difícil de expandir.  

### Refatorado
- Estrutura modular, facilitando evolução para:  
  - Banco de dados  
  - API  
  - Interface gráfica  

---

## Contribuição do ChatGPT

- Sugestão de boas práticas de programação.  
- Orientações para separação de responsabilidades.  
- Auxílio na implementação de testes e documentação.  

**Limitações:** ajustes finais dependem do desenvolvedor e dos requisitos específicos da disciplina.

---

## Licença
Este projeto é apenas para fins acadêmicos e de estudo.
