<html>

    <head>
        <title>Title</title>
        <link href="../static/css/styles.css" rel="stylesheet" type="text/css">
    </head>

    <body>

        <div class="form-style-2">
            <div class="form-style-2-heading">
                Already in System!
            </div>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
                <#list usersFromServer as user>
                    <tr>
                        <td>${user.name}</td>
                        <td>${user.surname}</td>
                    </tr>
                </#list>
            </table>
        </div>

    </body>

</html>