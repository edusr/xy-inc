# xy-inc
Backend da aplicação xy-inc

## Banco de dados

Esta aplicação utiliza o banco de dados MySql. O esquema e tabela utilizados pela aplicação serão criados pelo hibernate

```
jdbc:mysql://localhost:3306/xy
username=root
password=root

```

## Executando xy-inc localmente

Para o build da aplicação, execute a Classe XyIncApplication como um Java Application

## Executando os testes unitários

Os teste foram desenvolvidos com JUnit test

```
cd xy-inc
mvn spring-boot:run
```

## Serviços Disponibilizados

### Cliente

#### Salva o Cliente

POST localhost:8080/client/

##### Body

```
{
  id: null,
  name: "Eduardo",
  document: "5651316574798",
  email: "test@teste.com",
  phone: "34991999999",
  adress: {
    id: null,
    street: "Rua 1",
    neighborhood: "Umuarama",
    number: "1",
    city: "uberlandia",
    state: "Minas Gerais",
    country: "Brasil"
  }
}
```

#### Busca Todos Cliente

GET localhost:8080/client/all

#### Exclui Cliente

DELETE localhost:8080/client/{id}

#### Atualiza o Cliente

PUT localhost:8080/client/{id}

##### Body

```
{
  id: 1,
  name: "Eduardo Silva",
  document: "5651316574798",
  email: "test@teste.com",
  phone: "34991999999",
  adress: {
    id: null,
    street: "Rua 1",
    neighborhood: "Umuarama",
    number: "1",
    city: "uberlandia",
    state: "Minas Gerais",
    country: "Brasil"
  }
}
```

### Produto

#### Salva o Produto

POST localhost:8080/product/

#### Busca Todos Produto

GET localhost:8080/product/all

#### Exclui Produto

DELETE localhost:8080/product/{id}

#### Atualiza o Produto

PUT localhost:8080/product/{id}

### Pedido

#### Salva o Pedido

##### Body

```
{
  id: null,
  client: {
    id: 1,
    name: null,
    document: null,
    email: null,
    phone: null,
    adress: null
  },
itens: [
  {
    id: null,
    product: {
    id: 1,
    name: null,
    barcode: null,
    price: 4025.25
  },
  quantity: 10,
  unityPrice: 4025.25
  }
  ]
}
```

POST localhost:8080/order/

#### Busca Todos Pedido

GET localhost:8080/order/all

#### Exclui Pedido

DELETE localhost:8080/order/{id}

#### Atualiza o Pedido

PUT localhost:8080/order/{id}


