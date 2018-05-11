
'use strict';

function getFormData($form){
    let unindexed_array = $form.serializeArray();
    let indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

$(function () {

    let editUserModal = $('#userEdit');
    let usersTable = $('table');

    function loadUsers() {

        $.ajax({
            url: '/users',
            type: "POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8"
        }).done(result=>{

            console.log(result);

        clearUsersTable();

        for(let r in result) {
            appendUser(result[r]);
        }

        initUsersHandlers();

    });
    }

    function clearUsersTable() {
        usersTable.find('.user:not(.template)').remove();
    }

    function initUsersHandlers() {
        usersTable.find('.user .user-edit').click(function (e) {
            e.preventDefault();

            $.ajax({
                url: '/user/get',
                type: "GET",
                data: 'id='+$(this).closest('tr').attr('data-id'),
                dataType: 'json',
                contentType: "application/json; charset=utf-8"
            }).done(result=>{

                console.log(result);

            for(let f in result) {
                editUserModal.find('[type=text][name="'+f+'"]').val(result[f]);
            }

            editUserModal.find('[name=id]').val(result.id);

            editUserModal.find('[type=date]').val(result.birthDate);

            editUserModal.find('#edit-male').prop('checked', result.gender === 'male');
            editUserModal.find('#edit-female').prop('checked', result.gender === 'female');

            editUserModal.modal('show');

        });

        });

        usersTable.find('.user .user-remove').click(function (e) {
            e.preventDefault();
            $.ajax({
                url: '/user/remove',
                type: "GET",
                data: 'id='+$(this).closest('tr').attr('data-id'),
                dataType: 'json',
                contentType: "application/json; charset=utf-8"
            }).done(result=>{
                loadUsers();
        });
        });
    }

    function appendUser(user) {

        let tpl = $('tr.template').clone().removeClass('template');

        tpl.attr('data-id', user.id);

        tpl.find('.id').text(user.id);
        tpl.find('.firstName').text(user.firstName);
        tpl.find('.lastName').text(user.lastName);
        tpl.find('.birthDate').text(user.birthDate);
        tpl.find('.gender').text(user.gender);

        usersTable.append(tpl);
    }

    $('.user-add').click(function (e) {

        e.preventDefault();

        $.ajax({
            url: '/user/add',
            data: JSON.stringify(getFormData($('#addUserForm'))),
            type: "POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            beforeSend: function(xhr) {

            }
        }).done(result=>{
            console.log(result);
        $('.user-form-reset').click();
        //loadUsers();
        appendUser(result.data.user);
    });

    });

    $('.user-save').click(function (e) {
        $.ajax({
            url: '/user/save',
            data: JSON.stringify(getFormData(editUserModal.find('form'))),
            type: "POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
        }).done(result=>{
            editUserModal.modal('hide');
        loadUsers();
    });
    });

    $('.user-search').click(function (e) {

        e.preventDefault();

        $.ajax({
            url: '/user/search',
            data: JSON.stringify(getFormData($('#userSearchForm'))),
            type: "POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
        }).done(result=>{
            console.log(result);
        clearUsersTable();
        for(let u in result.data.users) {
            appendUser(result.data.users[u]);
        }
        initUsersHandlers();
    });

    });

    loadUsers();

});