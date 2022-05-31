# navigation-between-screens
1. Crie um aplicativo Android com duas Activities. Na primeira vocês devem apresentar uma lista de itens inseridas pelo usuário. Esses itens podem ser, por exemplo, Carros, Livros, etc. O resumo das informações sobre os itens podem ser apresentadas em uma caixa de texto normal (TextView). Caso vocês desejem, podem usar o ListView apresentado na aula anterior (Opcional).

2. Na Activity 01, além de apresentar a lista de itens, ela deve gerenciar também o identificador deles. Por exemplo, caso o seu aplicativo apresente uma lista de carros, cada carro deve ter um identificador único, gerenciado pela Activity 01.

3. Na Activity 02, vocês devem colocar as funcionalidades para editar e adicionar novos itens. 

    a. Caso o usuário deseje editar, a Activity 01 vai passar para a Activity 02, utilizando um Intent, todas as informações sobre o item a ser editado. Logo a seguir, a Activity 02 apresenta essas informações para o usuário, que pode editar e repassar as novas informações para a Activity 01, ou cancelar e nada ser passado para a Activity 01.

    b. Caso o usuário deseje adicionar, a Activity 01 vai passar apenas o identificador do novo item. A Activity 02 apresenta para o usuário o identificador recebido da Activity 01, com os outros campos vazios. O usuário deve preencher esses campos e retorna-los para a Activity 01 clicando no botão Adicionar, ou cancelar não fazer nada.

4. De volta na Activity 01, ao receber o retorno com o resultado da Activity 02, as informações da lista de item devem ser atualizadas.

    a. Caso o usuário tenha decidido adicionar um item, as informações sobre esse novo item devem estar presentes na caixa de texto, juntamente com os itens anteriores
    
    b. Caso o usuário tenha decidido editar um item existente, ele deve apresentar a lista de itens com as informações editadas sobre o item escolhido.
    
5. A Activity 01 deve conter os seguintes itens:

    a. Dois botões, um para adicionar e outro para editar

    b. Uma caixa de texto que o usuário deve preencher com o identificar do item a ser editado, caso ele escolha pela edição

    c. Uma caixa de texto contendo a descrição de todos os itens presentes na lista

6. Dicas

    a. Crie uma classe modelo para representar cada um dos itens criados. Você deve escolher o que é um Item. Um item pode ser um carro, um livro, um objeto. Fica a seu critério.
    
    b. Adicione um método toString() e os getters e setters à sua classe modelo.
    
    c. Use um ArrayList<Item> para gerenciar todos os itens adicionados.
    
    d. O identificador pode ser um contador para cada item adicionado.
    
    e. Ao editar um item, você deve percorrer toda a sua lista, procurando pelo identificador digitado pelo usuário. Caso encontre, você deve passar todas as informações sobre esse item para a Activity 02. Caso não encontre, mostre um Toast com uma mensagem informando que o identificador digitado não existe.