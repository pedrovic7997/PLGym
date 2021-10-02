function handleForm() {
    let data = {
        "name" : $("#name").val(),
        "email" : $("#email").val(),
        "password" : $("#password").val(),
        "weight" : $("#weight").val(),
        "height" : $("#height").val(),
        "birthdate" : $("#birthdate").val(),
        "exerciseIdList" : []
    };
    $.ajax("http://localhost:8080/user", {
        type : 'POST',
        contentType : 'application/json',
        data : JSON.stringify(data),
        dataType : 'json',
        async : false,
        success : function() {
            alert("Registrado com sucesso!");
            window.location.href = '/';
        },
    });
}