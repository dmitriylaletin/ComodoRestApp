<%--
  Created by IntelliJ IDEA.
  User: lalet
  Date: 5/10/2018
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>

    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>

    <title>Users Page</title>

    <link rel="stylesheet" href="../resources/css/bootstrap.min.css">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script src="../resources/js/bootstrap.bundle.min.js"></script>

    <script type="text/javascript" src="../resources/js/users.js"></script>

    <style type="text/css">
        body {
            background: #1e5799; /* Old browsers */
            background: -moz-linear-gradient(top,  #1e5799 0%, #207cca 30%, #2989d8 50%, #7db9e8 100%); /* FF3.6+ */
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#1e5799), color-stop(30%,#207cca), color-stop(50%,#2989d8), color-stop(100%,#7db9e8)); /* Chrome,Safari4+ */
            background: -webkit-linear-gradient(top,  #1e5799 0%,#207cca 30%,#2989d8 50%,#7db9e8 100%); /* Chrome10+,Safari5.1+ */
            background: -o-linear-gradient(top,  #1e5799 0%,#207cca 30%,#2989d8 50%,#7db9e8 100%); /* Opera 11.10+ */
            background: -ms-linear-gradient(top,  #1e5799 0%,#207cca 30%,#2989d8 50%,#7db9e8 100%); /* IE10+ */
            background: linear-gradient(to bottom,  #1e5799 0%,#207cca 30%,#2989d8 50%,#7db9e8 100%); /* W3C */
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1e5799', endColorstr='#7db9e8',GradientType=0 ); /* IE6-9 */
        }
        td {text-decoration-color: white}
        .btn-primary,
        .btn-warning,
        .btn-success,
        .btn-primary:hover,
        .btn-primary:active,
        .btn-primary:visited,
        .btn-primary:focus {
            background-color: #80bdff;
            border-color: #abdde5;
        }
        .template {
            display: none;
        }
    </style>

</head>
<body>
<div class="container-fluid">

    <header class="text-center" style="color: white">
        <p> COMODO TEST FULL STACK APP </p>
    </header>

    <div class="row">
        <div class="col-6 mx-auto text-center">
            <h2 style="color: white">USERS REST CRUD MANAGEMENT</h2>
        </div>
    </div>

    <div class="row">
        <div class="col-6 m-auto">
            <form class="m-auto" id="addUserForm">
                <div class="form-group">
                    <label for="firstName" style="color: white">First name</label>
                    <input type="text" name="firstName" class="form-control" id="firstName">
                </div>
                <div class="form-group">
                    <label for="lastName" style="color: white">Last name</label>
                    <input type="text" name="lastName" class="form-control" id="lastName">
                </div>
                <div class="form-group">
                    <label for="birthDate" style="color: white">Birthdate</label>
                    <input type="date" id="birthDate" name="birthDate">
                </div>
                <div class="form-group">
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="male" name="gender" value="male" class="custom-control-input" style="color: white">
                        <label class="custom-control-label" for="male" style="color: white">Male</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="female" name="gender" value="female" class="custom-control-input" style="color: white">
                        <label class="custom-control-label" for="female" style="color: white">Female</label>
                    </div>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary user-add" style="color: white">Add User</button>
                    <button type="reset" class="btn btn-warning user-form-reset" style="color: white">Reset</button>
                </div>
            </form>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-6 mx-auto">
            <form id="userSearchForm">
                <div class="form-row">
                    <div class="col">
                        <select class="custom-select" name="searchBy">
                            <option selected disabled value="none">Search By</option>
                            <option value="firstName">FirstName</option>
                            <option value="lastName">LastName</option>
                            <option value="gender">Gender</option>
                        </select>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" name="text" placeholder="When empty gets the full list of users">
                    </div>
                    <div class="col">
                        <button type="button" class="btn btn-success user-search">Search</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-12" style="text-decoration-color: white">
            <table class="table table-bordered">
                <thead>
                <td style="color: white">id</td>
                <td style="color: white">First Name</td>
                <td style="color: white">LastName</td>
                <td style="color: white">BirthDate</td>
                <td style="color: white">Gender</td>
                <td></td>
                </thead>
                <tbody>
                <tr class="user template">
                    <td class="id" style="color: white"></td>
                    <td class="firstName" style="color: white"></td>
                    <td class="lastName" style="color: white"></td>
                    <td class="birthDate" style="color: white"></td>
                    <td class="gender" style="color: white"></td>
                    <td>
                        <a href="#" class="user-edit" style="color: white">Edit</a>
                        <a href="#" class="user-remove" style="color: white">Remove</a>
                    </td>
                </tr>
                </tbody>

            </table>
        </div>
    </div>

    <footer class="text-center" style="color: white">
        <p> MADE BY DMITRIY LALETIN@ AS A TEST PROJECT FOR A JAVA DEV POSITION IN COMODO Co. 2018 </p>
    </footer>

</div>

<div class="modal fade" id="userEdit" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">User edit</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="m-auto" id="editUserForm">
                    <input type="hidden" name="id">
                    <div class="form-group">
                        <label for="firstName">First name</label>
                        <input type="text" name="firstName" class="form-control" id="edit-firstName">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last name</label>
                        <input type="text" name="lastName" class="form-control" id="edit-lastName">
                    </div>
                    <div class="form-group">
                        <label for="birthday">Birthdate</label>
                        <input type="date" id="edit-birthday" name="birthDate">
                    </div>
                    <div class="form-group">
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="edit-male" name="gender" value="male" class="custom-control-input">
                            <label class="custom-control-label" for="edit-male">Male</label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="edit-female" name="gender" value="female" class="custom-control-input">
                            <label class="custom-control-label" for="edit-female">Female</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-primary user-save">Save User</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

