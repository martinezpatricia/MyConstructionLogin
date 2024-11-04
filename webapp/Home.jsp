<!DOCTYPE html>
<html>
<head>
    <title>Bienvenido</title>
</head>
<body>
    <h2>Bienvenido, <%= session.getAttribute("username") %>!</h2>
    <a href="logout.jsp">Cerrar sesion</a>
</body>
</html>