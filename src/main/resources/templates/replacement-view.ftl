<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Substituição de Aula</title>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

  <!-- Popper JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>
  <div class="container">
    <div class="jumbotron">
        <h1>Substituição de Aula</h1>
        <p>Essa página é responsável por fazer a substituição de aula. </p>
    </div>
    <div class="row">
      <div class="col">
        <form action="/replacement/new" method="post">
          <div class="form-group">
              <label for="classSelect">Aula</label>
              <select class="form-control" id="classSelect">
                  <option>Aula 1</option>
              </select>
          </div>
          <div class="form-group">
              <label for="teacherSelect">Docente</label>
              <select class="form-control" id="teacherSelect">
                  <option>Pedro</option>
              </select>
          </div>
          <button type="submit" class="btn btn-primary">Salvar</button>
        </form>

      </div>
  </div>
  <!-- <div class="row">
      <div class="col">
          <table class="table table-striped table-hover">
              <thead class="thead-dark">
                  <tr>
                      <th>Nome</th>
                      <th>Sigla</th>
                      <th>Código Telefone</th>
                      <th>Ações</th>
                  </tr>
              </thead>
              <tbody>
                  <#list paises as pais>
                      <tr>
                          <td>${pais.nome}</td>
                          <td>${pais.sigla}</td>
                          <td>${pais.codigoTelefone}</td>
                          <td>
                              <a href="/pais/prepara-alterar?id=${pais.id}">Alterar</a>
                              <a href="/pais/excluir?id=${pais.id}">Excluir</a>
                          </td>
                      </tr>        
                  </#list>
              </tbody>
          </table>
      </div> -->
    </div>
  </div>
</body>

</html>