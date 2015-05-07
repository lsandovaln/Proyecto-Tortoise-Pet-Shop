<html>
    <head>
        <title>Tortoise Pet Shop</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <img src="http://i.imgur.com/OXlSVU1.png" align="middle" class="center"/>
            </div>

            <div id="menu">
                <ul>
                    <li><a href="/Catalogo">Catalogo</a></li>
                    <li><a href="/Mantenimiento/Productos">Mantenimiento Productos</a></li>
                    <li><a href="/Mantenimiento/Categorias">Mantenimiento Categorias</a></li>
                </ul>
            </div>

            <div id="content">
                <#include "${templateName}">
            </div>
        </div>
    </body>    
</html>