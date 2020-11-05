const url = 'http://localhost:8080/index/user';

$(document).ready(); {
    getTableUser()
}
function getTableUser() {
    fetch(url).then(
        response => {
            response.json().then(
                data => {
                    let str = '<tr>' +
                        '<td>' + data.id + '</td>' +
                        '<td>' + data.firstName + '</td>' +
                        '<td>' + data.lastName + '</td>' +
                        '<td>' + data.age + '</td>' +
                        '<td>' + data.username + '</td>' +
                        '<td>' + data.roles[0].name + '</td>' +
                        '</tr>';
                    $('#table_user tbody').empty().append(str);
                });
        });
}
