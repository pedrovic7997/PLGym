$(document).ready(function() {
    let tableDiscover = $('#table-discover').DataTable( {
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
        columns: [
            {
                "data": "id",
                visible: false,
            },
            { "data": "name" },
            { "data": "category" },
            { "data": "difficulty" },
            { "data": "link" },
            { orderable: false },
        ]
    } );

    $('#table-discover tbody').on('click', '.btn', function () {
        let row = $(this).closest('tr');
        let id = tableDiscover.row(row).data().id;
        $.ajax("http://localhost:8080/user/exercises", {
            type : 'PUT',
            contentType : 'application/json',
            data : JSON.stringify(id),
            dataType : 'json',
            async : false,
            success : function() {
                window.location.href = 'http://localhost:8080/myworkout';
            },
        });
    } );

    let tableMyWorkout = $('#table-myworkout').DataTable( {
        "paging": true,
        "pagingType": "simple",
        "searching": true,
        "language": {
            "decimal":        ",",
            "emptyTable":     "Lista vazia",
            "info":           "",
            "infoEmpty":      "",
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
        columns: [
            {
                "data": "id",
                visible: false,
            },
            { "data": "name" },
            { "data": "category" },
            { "data": "difficulty" },
            { "data": "link" },
            { orderable: false },
        ]
    } );

    $('#table-myworkout tbody').on('click', '.btn', function () {
        let row = $(this).closest('tr');
        let id = tableMyWorkout.row(row).data().id;
        $.ajax("http://localhost:8080/user/exercises", {
            type : 'DELETE',
            contentType : 'application/json',
            data : JSON.stringify(id),
            dataType : 'json',
            async : false,
            success : function() {
                window.location.href = 'http://localhost:8080/myworkout';
            },
        });
    } );
} );