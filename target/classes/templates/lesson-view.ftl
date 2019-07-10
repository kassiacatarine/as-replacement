<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Gerencia Aula</title>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>

<body>
  <div class="container">
    <div class="jumbotron">
      <h1>Gerenciamento de Aula</h1>
      <p>Essa página é responsável por fazer o geranciamento de aulas. </p>
    </div>
    <div class="row">
      <div class="col">
<<<<<<< HEAD
        <form action="/lesson/new" method="post">
=======
        <form action="/lesson/new" method="POST">
>>>>>>> 5fdeedd8314fc710ef2410f058ea4dcb92811950
          <div class="form-group">
            <label for="titulo">Título:</label>
            <input name="titulo" type="text" class="form-control" id="titulo" required>
          </div>
          <div class="form-group">
            <label for="data-pagamento">Data:</label>
            <div class="input-group date" data-date-format="dd/mm/yyyy">
              <input name="data" id="data" type="text" class="form-control" placeholder="dd/mm/yyyy" required>
              <div class="input-group-addon">
                <span class="glyphicon glyphicon-th"></span>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="aulas">Quantidade de aulas diarias:</label>
            <input name="aulas" type="number" class="form-control" id="aulas" required>
          </div>
          <div class="form-group">
            <label for="turma">Turma:</label>
            <select name="turmaId" id="turma" class="form-control" required>
              <#list turmas as turma>
                <option value="${turma.id}">${turma.codigo} - ${turma.disciplinaNome}</option>
              </#list>
            </select>
          </div>
          <button type="submit" class="btn btn-primary">Criar</button>
        </form>

      </div>
    </div>
    <div class="row">
      <div class="col">
        <table class="table table-striped table-hover">
          <thead class="thead-dark">
            <tr>
              <th>Título</th>
              <th>Data</th>
              <th>Quantidade de Aulas</th>
              <th>Turma</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
            <#list aulas as aula>
              <tr>
                <td>${aula.titulo}</td>
                <td>${(aula.data?date?string("dd/MM/yyyy"))!}</td>
                <td>${aula.aulas}</td>
                <td>${aula.turmaNome}</td>
                <td>
                  <a href="/aulas/prepara-alterar?id=${aula.id}">Alterar</a>
                  <a href="/lesson/delete?id=${aula.id}">Excluir</a>
                </td>
              </tr>
            </#list>
          </tbody>
        </table>
      </div>
    </div>
  </div>


  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

  <!-- Popper JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script>
    $('.input-group.date').datepicker({ format: "dd/mm/yyyy" });
  </script>
</body>

</html>