<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Sign Up!
    </div>
    <form method="post" action="/signUp">
        <label for="login">Логин
            <input class="input-field" type="text" id="login" name="login">
        </label>
        <br>
        <label for="password">Пароль
            <input class="input-field" type="password" id="password" name="password">
        </label>

        <label for="login">Имя
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <br>
        <label for="password">Фамилия
            <input class="input-field" type="text" id="surname" name="surname">
        </label>
        <br>
        <input type="submit" value="SignUp">
    </form>
</div>
</body>
</html>