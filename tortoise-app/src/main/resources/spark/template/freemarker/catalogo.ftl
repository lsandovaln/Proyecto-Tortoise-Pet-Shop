<h1>Catalogo de Productos</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Categoria</th>
        <th>Precio</th>
        <th>Stock</th>
        <th>Accion</th>
    </tr>
    <#list productos as producto>
    <tr>
        <td>${producto.identificador}</td>
        <td>${producto.nombre}</td>
        <td>${producto.categoria.descripcion}</td>
        <td>${producto.precio}</td>
        <td>${producto.stock}</td>
        <td><a href="#">Agregar</a></td>
    </tr>
    </#list>
</table>