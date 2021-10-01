$(document).ready(function() {
    $('#table-discover').DataTable( {
        "language": {
            "decimal":        ",",
            "emptyTable":     "Lista vazia",
            "info":           "Mostrando de _START_ a _END_ dentre _TOTAL_ exercícios",
            "infoEmpty":      "Mostrando de 0 a 0 dentre 0 exercícios",
            "infoFiltered":   "(filtrado de _MAX_ exercícios ao todo)",
            "infoPostFix":    "",
            "thousands":      " ",
            "lengthMenu":     "Mostrar _MENU_ exercícios",
            "loadingRecords": "Carregando...",
            "processing":     "Processando...",
            "search":         "Buscar:",
            "zeroRecords":    "Nenhum exercício correspondente encontrado",
            "paginate": {
                "first":      "Ínicio",
                "last":       "Fim",
                "next":       "Próximo",
                "previous":   "Anterior"
            },
            "aria": {
                "sortAscending":  ": ative para ordenar coluna em ordem crescente",
                "sortDescending": ": ative para ordenar coluna em ordem decrescente"
            }
        }
    } );

    let table = $('#table-myworkout').DataTable( {
        "paging": false,
        "searching": true,
        "language": {
            "decimal":        ",",
            "emptyTable":     "Lista vazia",
            "info":           "Mostrando de _START_ a _END_ dentre _TOTAL_ exercícios",
            "infoEmpty":      "Mostrando de 0 a 0 dentre 0 exercícios",
            "infoFiltered":   "(filtrado de _MAX_ exercícios ao todo)",
            "infoPostFix":    "",
            "thousands":      " ",
            "lengthMenu":     "Mostrar _MENU_ exercícios",
            "loadingRecords": "Carregando...",
            "processing":     "Processando...",
            "search":         "Buscar:",
            "zeroRecords":    "Nenhum exercício correspondente encontrado",
            "paginate": {
                "first":      "Ínicio",
                "last":       "Fim",
                "next":       "Próximo",
                "previous":   "Anterior"
            },
            "aria": {
                "sortAscending":  ": ative para ordenar coluna em ordem crescente",
                "sortDescending": ": ative para ordenar coluna em ordem decrescente"
            }
        },
        "columns": [
            {
                defaultContent: '<input type="button" class="btn btn-primary" value="Add"/>'
            },
            { "data": "name" },
            { "data": "category" },
            { "data": "difficulty" },
            { "data": "linkYT" },
        ],
    } );

    $('#table-myworkout tbody').on('click', '.btn', function () {
        let row = $(this).closest('tr');
        let data = table.row(row).data().name;
        console.log(data);
    } );
} );